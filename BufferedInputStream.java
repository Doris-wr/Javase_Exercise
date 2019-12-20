package java.io;

 

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

//该类主要完成对被包装流，加上一个缓存的功能

public class BufferedInputStream extends FilterInputStream {

    private static int defaultBufferSize = 8192;                                      //默认缓存的大小

    protected volatile byte buf[];                                                            //内部的缓存

    protected int count;                                                                                            //buffer的大小

    protected int pos;                                                                               //buffer中cursor的位置

    protected int markpos = -1;                                                                     //mark的位置

    protected int marklimit;                                                                            //mark的范围

 

//原子性更新。和一致性编程相关

    private static final

        AtomicReferenceFieldUpdater<BufferedInputStream, byte[]> bufUpdater =

        AtomicReferenceFieldUpdater.newUpdater (BufferedInputStream.class,  byte[].class, "buf");

 

    private InputStream getInIfOpen() throws IOException {  //检查输入流是否关闭，同时返回被包装流

        InputStream input = in;

         if (input == null)    throw new IOException("Stream closed");

        return input;

    }

 

    private byte[] getBufIfOpen() throws IOException {                       //检查buffer的状态，同时返回缓存

        byte[] buffer = buf;

         if (buffer == null)   throw new IOException("Stream closed");            //不太可能发生的状态

        return buffer;

    }

 

    public BufferedInputStream(InputStream in) {                               //构造器

                   this(in, defaultBufferSize);                                                              //指定默认长度的buffer

    }

 

    public BufferedInputStream(InputStream in, int size) {                           //构造器

                   super(in);

        if (size <= 0) {                                                                                         //检查输入参数

            throw new IllegalArgumentException("Buffer size <= 0");

        }

                   buf = new byte[size];                                                                     //创建指定长度的buffer

    }

 

         //从流中读取数据，填充如缓存中。

    private void fill() throws IOException {

        byte[] buffer = getBufIfOpen();                            //得到buffer

         if (markpos < 0)

             pos = 0;                                                             //mark位置小于0，此时pos为0

         else if (pos >= buffer.length)                               //pos大于buffer的长度

             if (markpos > 0) {        

                   int sz = pos - markpos;                            //

                   System.arraycopy(buffer, markpos, buffer, 0, sz);

                   pos = sz;

                   markpos = 0;

             } else if (buffer.length >= marklimit) {                 //buffer的长度大于marklimit时，mark失效

                   markpos = -1;                                                   //

                   pos = 0;                                                             //丢弃buffer中的内容

             } else {                                                                         //buffer的长度小于marklimit时对buffer扩容

                   int nsz = pos * 2;

                   if (nsz > marklimit)           nsz = marklimit;//扩容为原来的2倍，太大则为marklimit大小

                   byte nbuf[] = new byte[nsz];                    

                   System.arraycopy(buffer, 0, nbuf, 0, pos);        //将buffer中的字节拷贝如扩容后的buf中

                if (!bufUpdater.compareAndSet(this, buffer, nbuf)) {

                                                                                                                         //在buffer在被操作时，不能取代此buffer

                    throw new IOException("Stream closed");

                }

                buffer = nbuf;                                                               //将新buf赋值给buffer

             }

        count = pos;

         int n = getInIfOpen().read(buffer, pos, buffer.length - pos);

        if (n > 0)     count = n + pos;

    }

 

    public synchronized int read() throws IOException { //读取下一个字节

         if (pos >= count) {                                                                 //到达buffer的末端

             fill();                                                                    //就从流中读取数据，填充buffer

             if (pos >= count)  return -1;                                //读过一次，没有数据则返回-1

         }

         return getBufIfOpen()[pos++] & 0xff;                           //返回buffer中下一个位置的字节

    }

 

    private int read1(byte[] b, int off, int len) throws IOException {                 //将数据从流中读入buffer中

         int avail = count - pos;                                                                             //buffer中还剩的可读字符

         if (avail <= 0) {                                                                                        //buffer中没有可以读取的数据时

             if (len >= getBufIfOpen().length && markpos < 0) {             //将输入流中的字节读入b中

                   return getInIfOpen().read(b, off, len);

             }

             fill();                                                                                                //填充

             avail = count - pos;

             if (avail <= 0) return -1;

         }

         int cnt = (avail < len) ? avail : len;                                                  //从流中读取后，检查可以读取的数目

         System.arraycopy(getBufIfOpen(), pos, b, off, cnt);            //将当前buffer中的字节放入b的末端

         pos += cnt;

         return cnt;

    }

 

 

    public synchronized int read(byte b[], int off, int len)throws IOException {

        getBufIfOpen();                                                                             // 检查buffer是否open

        if ((off | len | (off + len) | (b.length - (off + len))) < 0) {            //检查输入参数是否正确

             throw new IndexOutOfBoundsException();

         } else if (len == 0) {

            return 0;

        }

         int n = 0;

        for (;;) {

            int nread = read1(b, off + n, len - n);

            if (nread <= 0)     return (n == 0) ? nread : n;

            n += nread;

            if (n >= len)     return n;

            // if not closed but no bytes available, return

            InputStream input = in;

            if (input != null && input.available() <= 0)     return n;

        }

    }

 

 

    public synchronized long skip(long n) throws IOException {

        getBufIfOpen();                                        // 检查buffer是否关闭

         if (n <= 0) {    return 0;      }                 //检查输入参数是否正确

         long avail = count - pos;                    //buffered中可以读取字节的数目

        if (avail <= 0) {                                          //可以读取的小于0，则从流中读取

            if (markpos <0)  return getInIfOpen().skip(n); //mark小于0，则mark在流中      

            fill();                                  // 从流中读取数据，填充缓冲区。

            avail = count - pos;                                   //可以读的取字节为buffer的容量减当前位置

            if (avail <= 0)     return 0;

        }       

        long skipped = (avail < n) ? avail : n;      

        pos += skipped;                                       //当前位置改变

        return skipped;

    }

 

    public synchronized int available() throws IOException {

                   return getInIfOpen().available() + (count - pos);                 

    }

         //该方法不会block！返回流中可以读取的字节的数目。

         //该方法的返回值为缓存中的可读字节数目加流中可读字节数目的和

 

    public synchronized void mark(int readlimit) {  //当前位置处为mark位置

         marklimit = readlimit;

         markpos = pos;

    }

 

    public synchronized void reset() throws IOException {

        getBufIfOpen(); // 缓冲去关闭了，肯定就抛出异常！程序设计中经常的手段

                   if (markpos < 0)     throw new IOException("Resetting to invalid mark");

                   pos = markpos;

    }

 

    public boolean markSupported() {           //该流和ByteArrayInputStream一样都支持mark

                   return true;

    }

 

         //关闭当前流同时释放相应的系统资源。

    public void close() throws IOException {

        byte[] buffer;

        while ( (buffer = buf) != null) {

            if (bufUpdater.compareAndSet(this, buffer, null)) {

                InputStream input = in;

                in = null;

                if (input != null)    input.close();

                return;

            }

            // Else retry in case a new buf was CASed in fill()

        }

    }

}

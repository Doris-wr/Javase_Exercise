package File.IO流;

import org.junit.Test;

import java.io.*;

/**
 * @Author:wangrui
 * @Date:2020/2/14 20:04
 */
/*
①read()的理解：返回读入的一个字节，入过到达文件末尾，返回-1
②异常的处理：为了保证流西元一定可以执行关闭操作，需要使用try-catch-finally
③读入的文件一定要存在，否则就会报FileNotFoundException
 */
public class FileReadWriteTest {
    @Test
    public void test1(){
        //实例化File类的对象
        FileReader fr= null;
        try {
            File file=new File("hello.txt");
            //2具体的流
            fr = new FileReader(file);
            //3/数据据的读入
            int data=fr.read();
            while(data!=-1){
                System.out.print((char)data);
                data=fr.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //  4.流的关闭
            try {
                if(fr!=null){
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    //对read的操作升级
    public void testFoleReader1()  {
        FileReader fr=null;
        try {
            File file=new File("hellle.txt");
            fr=new FileReader(file);
            char[]  cbuf=new char[5];
            int len;
            while((len=fr.read(cbuf))!=-1){
                for(int i=0;i<len;i++){
                    System.out.println(cbuf[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fr!=null){
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    /*
      写出去
    1.输出操作，对应的file是可以不存在的，并不会报异常
     2.File对应的硬盘中的文件如果不存在，如果不存在，在输出的过程中就会自动创建文件
       File对应的硬盘中的文件如果存在，File Writer（file,false)/FilWriter(fale):对原有文件的覆盖
                                        FileWriter(false,true):不会对原有覆盖，而是在原有文件基础上追加内容
     */
    public void testFileWrirer()  {
        //1 提供File类的对象，指明写出到的文件
        FileWriter fw= null;
        try {
            File file=new File("helle1.txt");
            //2提供FileWriter的对象，用于数据的写出
            fw = new FileWriter(file);
            //3.写出的具有的操作
            fw.write("I have a dream\n");
            fw.write("you have to have a dream!");
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //4.资源的关闭
            try {
                if(fw!=null){
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void testFIleReaderFileWriter(){
        FileReader fr= null;
        FileWriter fw= null;
        try {
            //1.创建File类的对象，指明读入和写入的文件
            File srcFile=new File("hello.txt");
            File destFile=new File("hello2.txt");
            //2  创建输入流和输出流的对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);
            //3数据的读入和写出操作
            char[] cbuf=new char[5];
            int len;//记录每次读入到cbuf数组中的字符的个数
            while((len=fr.read(cbuf))!=-1){
                //每次写出len个字符
                fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4 关闭资源
            try {
                if(fw!=null){
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fr!=null){
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

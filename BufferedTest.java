
import org.junit.Test;

import java.io.*;

/**
 * @Author:wangrui
 * @Date:2020/2/16 19:51
 */
public class BufferedTest {
    @Test
    public void BufferedStreamTest() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1 造文件
            File srcFile = new File("爱情与友谊.jpg");
            File destFile = new File("爱情与友谊3.jpg");
            //2造流
            //2.1造节点流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            //2.2造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //3.复制的细节，读入，写入
            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4 资源关闭
            //关闭顺序：先关外层的，再关闭内层的流
            try {
                if (bos != null) {
                    bos.close();
                }
                if (bis != null) {
                    bis.close();
                }
                //说明：关闭在层流的同时，内层也会自动的进行关闭，关于内层流的关闭，我们可以省略
                /*fos.close();
                fis.close();*/
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void testBufferedReaderBufferedWriter(){
        BufferedReader br= null;
        BufferedWriter bw= null;
        try {
            //创建文件和相应的流
            br = new BufferedReader(new FileReader(new File("hello.txt")));
            bw = new BufferedWriter(new FileWriter(new File("hello3.txt")));
            //方式一
           /* //读写操作
            char[] cbuf=new char[1024];
            int len;
            while((len=br.read(cbuf))!=-1){
                bw.write(cbuf,0,len);
                //bw.flush();
            }*/
           //方式二：readLine()——一次可以读一行
            String data;
            while((data=br.readLine())!=null){
                //方法一：
                bw.write((data+"\n"));//data中不包含换行符
                //方法二
                bw.write(data);//data中不包含换行符
                bw.newLine();//提供换行的操作
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            try {
                if(bw!=null){
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(br!=null){
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

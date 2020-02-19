package File.IO流;

import org.junit.Test;

import java.io.*;

/**
 * @Author:wangrui
 * @Date:2020/2/14 23:34
 */
/*说明：英文字母也是按照一个字节存的，所以hello.txt中如果含有英文字母，用FileInputStream
也可以存下，但是如果里面有汉字，就会出现乱码。UTF-8里中文是用三个字节存的
结论：对于文本文件（.txt/.java/.c/.cpp)，使用字符流处理
     对于非文本文件(.jpg/.mp3/.mp4/.avi/.doc/.ppt……），使用字节流处理
 */
public class FileInputStreamOutputStreamTest {
    @Test
    //使用字节流FileInputStream来处理文本文件，是可能出现乱码的
    public void testFileInputStream() throws IOException {
    //
        File file=new File("hello.txt");
        FileInputStream fis=new FileInputStream(file);
        byte[]buffer=new byte[5];
        int len;
        while((len=fis.read(buffer))!=-1){
            String str=new String(buffer,0,len);
            System.out.println(str);
        }
        fis.close();
    }
    @Test
    //图片的复制
    public void testFIleInputStreamOutputStream() throws FileNotFoundException {
        FileInputStream fis= null;
        FileOutputStream fos= null;
        try {
            File srcFile=new File("爱情与友谊.jpg");
            File destFile=new File("爱情与友谊2.jpg");
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            byte[] buffer=new byte[5];
            int len;
            while((len=fis.read(buffer))!=-1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fis!=null){
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fos!=null){
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //指定路径下的文件的复制
    public void copyFile(String srcPath,String destPath){
        FileInputStream fis= null;
        FileOutputStream fos= null;
        try {
            File srcFile=new File(srcPath);
            File destFile=new File(destPath);
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            byte[] buffer=new byte[5];
            int len;
            while((len=fis.read(buffer))!=-1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fis!=null){
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fos!=null){
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void testCopyFile(){
        long start=System.currentTimeMillis();
        String srcPath="D:\\MyJava\\JavaWeb\\爱情与友谊.jpg";
        String destPath="D:\\MyJava\\JavaWeb\\爱情与友谊5.jpg";
        copyFile(srcPath,destPath);
        long end=System.currentTimeMillis();
        System.out.println("文件复制花费的时间为："+(end-start));
    }










}

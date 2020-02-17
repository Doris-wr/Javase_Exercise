package File.练习题;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author:wangrui
 * @Date:2020/2/16 21:46
 * 图片的加密
 */
public class PicTest {
    //图片的加密
    @Test
    public void test1(){
        FileInputStream fis= null;
        FileOutputStream fos= null;
        try {
            fis = new FileInputStream("爱情与友谊.jpg");
            fos = new FileOutputStream("爱情与友谊secret.jpg");
            byte[] buffer=new byte[20];
            int len;
            while((len=fis.read(buffer))!=-1){
                for(int i=0;i<len;i++){
                    buffer[i]= (byte) (buffer[i]^5);
                }
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
        if(fis!=null){
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(fos!=null){
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //图片的解密
    @Test
    public void test2(){
        FileInputStream fis= null;
        FileOutputStream fos= null;
        try {
            fis = new FileInputStream("爱情与友谊secret.jpg");
            fos = new FileOutputStream("爱情与友谊5.jpg");
            byte[] buffer=new byte[20];
            int len;
            while((len=fis.read(buffer))!=-1){
                for(int i=0;i<len;i++){
                    buffer[i]= (byte) (buffer[i]^5);
                }
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
        if(fis!=null){
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(fos!=null){
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

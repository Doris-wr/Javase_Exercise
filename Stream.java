package File;
import java.io.*;

public class Stream {
    public static void main(String[] args) throws IOException {
        File file=new File("测试目录\\测试文件.txt");
        file.createNewFile();
        //OutputStream os= new FileOutputStream(file);//写
        /*os.write(97);
        os.write(98);
        os.write(99);*/
       // byte[] buf="我是中国人".getBytes("UTF-8");//把文本转化成二进制流（默认按照UTF8进行编码和解码）
      //  os.write(buf);
        /*byte[] buf2="我是中国人".getBytes("GB18030");//把文本转化国标系列，也就是GBK
        os.write(buf2);*/
        InputStream is=new FileInputStream(file);//读
        byte[] buf=new byte[1024];
        int len=is.read(buf);
        System.out.println(len);
        String s=new String(buf,0,len,"UTF-8   ");
        System.out.println(s);

        /*System.out.println(is.available());//返回流中可能有多少字节，是一个估算值,平时不要用
        int b ;
        //正确的方式
        while((b=is.read())!=-1){
            System.out.println(b);
        }*/

        /*File file = new File("测试目录\\测试文件.txt");
        InputStream is=new FileInputStream(file);
        for(int i=0;i<15;i++){
            int b=is.read();
            System.out.println(b);
        }*/

        /*file.createNewFile();
        OutputStream os=new FileOutputStream(file);
        byte[] but="我是中国人".getBytes("UTF-8");
        os.*/

    }
}

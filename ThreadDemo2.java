package 多线程;
import java.util.Scanner;
class Fib{
    public static int  calc(int num){
        if(num==0||num==1){
            return 1;
        }else{
            return calc(num-1)+calc(num-2);
        }
    }
}
class FibnacciThread extends Thread{
    private int n;
    FibnacciThread(int n){
        this.n=n;
    }
    @Override
    public void run() {
        long result=Fib.calc(n);
        System.out.printf("第%d项斐波那契数为:%d%n",n,result);
    }
}
public class ThreadDemo2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(true){
            System.out.println("请输入要计算第几项斐波那契数：");
            int n=scanner.nextInt();
            Thread thread=new FibnacciThread(n);
            thread.start();
        }
    }
}

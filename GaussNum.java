import java.util.Random;
import java.util.Scanner;

public class GaussNum {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        Random random=new Random();
        int randNum=random.nextInt(100)+1;
        int num=0;
        while(true){
            System.out.println("请猜一个数字：");
            num=scan.nextInt();
            if(num>randNum){
                System.out.println("猜大了");
            }else if(num==randNum){
                System.out.println("猜对了");
                break;
            }else{
                System.out.println("猜小了");
            }
        }
    }
}

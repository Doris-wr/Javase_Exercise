public class Main {
    //    打印数字的每一位,例如1234打印为1   2   3   4
    public static void func(int num){
        if(num>9){
            func(num/10);//123   12   1
        }
        System.out.println(num&10);
    }
    //    递归求 1+2+3+……10
    public static int sum(int num){
        if(num==1){
            return 1;
        }
        return num+sum(num-1);
    }
    //    写一个递归方法，输入一个非负整数，返回组成他的数字之和，例如输入1729，则他的和是19
    public static int sumNum(int num){
        if(num<10){
            return num;
        }
        return num%10+sumNum(num/10);
    }
    //利用递归求第n个斐波那契数
    public static int fib(int n){
        if(n==1||n==2){
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }
//青蛙跳台阶（递归）
    public static int forgDrop(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return forgDrop(n-1)+forgDrop(n-2);
    }
//    非递归青蛙跳台阶
    public static int forgDrop2(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int f1=1;
        int f2=2;
        int f3=1;
        for(int i=3;i<=n;i++){
            f2=f2+f1;
            f1=f2;
            f2=f3;
        }
        return  f3;
    }
    public static void main(String[] args) {
        System.out.println(sumNum(123));
        System.out.println(fib(7));
        System.out.println(sum(3));
    }
}

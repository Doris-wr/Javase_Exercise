package 异常;

public class TryCatchTest {
    public int test(){
        int divided=10;
        int result=100;
        try{
            while(divided>-1){
                divided--;
                result=result+100/divided;
            }
            return result;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("抛出异常");
            return -1;
        }
    }

    public static void main(String[] args) {
        TryCatchTest t=new TryCatchTest();
        System.out.println("result="+t.test());
    }
}

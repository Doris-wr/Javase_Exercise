
public class Test {
    public static void main(String[] args){
        System.out.println(test());
    }
    public static String test(){
        try{
            System.out.println("try Bolck");
            return test2();
        }finally{
            System.out.println("finally Biock");
        }
    }
    public static String test2(){
        System.out.println("statement");
        return "after return";
    }
}

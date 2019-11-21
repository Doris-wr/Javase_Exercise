import java.util.*;
import.java.math.BigInteger;
public class AddBigInteger{
  public static void main(String[] args){
    while(input.hasNext()){
      String s1=input.next();
      String s2=input.next();
      BigInteger num1=new BigInteger(s2);
      BigInteger num2=new BigInteger(s2);
      System.out.println(num1.add(num2));
    }
  }
}

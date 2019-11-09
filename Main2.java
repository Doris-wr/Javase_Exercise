public class Main{
     public static boolean isHuiwen(Strings){
          int i=0;
          int j=s.length()-1;
          while(i<j){
             if(s.charAt(i)!=s.charAt(j)){
                  returnfalse;
             }
             i++;
             j--;
          }
         returntrue;
      }
     public  static void main(String[]args){
          Scannersc=newScanner(System.in);
          Stringstr1=sc.nextLine();
          Stringstr2=sc.nextLine();
          intcount=0;
          for(inti=0;i<=str1.length();i++){
               StringBuildersb=newStringBuilder(str1);
               sb.insert(i,str2);
               if(isHuiwen(sb.toString())){
                    count++;
               }
           }
          System.out.println(count);
     }
}

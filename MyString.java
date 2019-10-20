//自己实现String类中的一些方法
public final class MyString2 {
    private final char[] value;
    public MyString2(char[] value){
        this.value=Arrays.copyOf(value,value.length);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyString2)) return false;
        MyString2 myString2 = (MyString2) o;
        return Arrays.equals(value, myString2.value);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(value);
    }

    public MyString2(char[] value, int offset, int count){
        this.value=Arrays.copyOfRange(value,offset,offset+count);
    }
    
    public char charAt(int index){
        return value[index];
    }
   public char[] toCharArray(){
       return Arrays.copyOf(value,value.length);
   }
    //将所有字符装换成大写
   public MyString2 toUpperCase(){
       char[] value=toCharArray();
       for(int i=0;i<value.length;i++){
           if(Character.isLowerCase(value[i])){
               value[i]=Character.toUpperCase(value[i]);
           }
       }
       return new MyString2(value);
   }
   //忽略大小写，判断两个字符串是否相等
   public boolean equalsIgnoreCase(MyString2 o){
       if(o==null){
           return false;
       }
       if(value.length!=o.value.length){
           return false;
       }
       for(int i=0;i<value.length;i++){
           char c=Character.toUpperCase(value[i]);
           char d=Character.toUpperCase(o.value[i]);
           if(c!=d){
               return false;
           }
       }
       return true;
    }
    //拼接字符串
    public MyString2 concat(MyString2 o){
       char[] v=new char[value.length];
        System.arraycopy(value,0,v,0,value.length);
        System.arraycopy(o.value,0,v,value.length,o.value.length);
        return new MyString2(v);
    }
}

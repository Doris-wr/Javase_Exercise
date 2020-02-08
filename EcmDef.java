/*
编写程序EcmDef.java，接收命令行的两个参数，要求不能输入负数，计算两数相除
对数据类型不一致（NumberFormatException),缺少命令行参数（ArrayIndexOutOfBoundsException）
除0（ArithmeticException ）及除以负数（EcDef ）自定义的异常进行处理
 */
class EcDEf extends Exception {
    static final long serialVersionUID=-33875164229948L;
    public EcDEf(){

    }
    public EcDEf(String msg){
        super(msg);
    }
}
public class EcmDef {
    public static void main(String[] args){
        try {
            int i = Integer.parseInt(args[0]);
            int j = Integer.parseInt(args[1]);
            int result = ecm(i, j);
            System.out.println(result);
        }catch(NumberFormatException e){
            System.out.println("数据类型不一致");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("缺少命令行参数");
        }catch(ArithmeticException e){
            System.out.println("除0");
        }catch(EcDEf e){
            System.out.println(e.getMessage());
        }
    }
    public static int ecm(int i,int j) throws EcDEf {
        if(i<0||j<0) {
            throw new EcDEf("分子或分母为负数了");
        }
        return i/j;
    }
}


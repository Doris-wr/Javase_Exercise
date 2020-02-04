package Static.银行账户;

public class Accout {
    private int id;
    private String pwd="000000";//密码
    private double balance;//余额
    private static double interedstRate;//利率
    private static double minMoney=1.0;
    private static int init=1001;//用于自定生成id
    public Accout(){
        id=init++;
    }

    public Accout(String pwd,double balance){
        id=init++;
        this.pwd=pwd;
        this.balance=balance;
    }

    public int getId() {
        return id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public double getBalance() {
        return balance;
    }

    public static double getInteredstRate() {
        return interedstRate;
    }

    public static void setInteredstRate(double interedstRate) {
        Accout.interedstRate = interedstRate;
    }

    public static double getMinMoney() {
        return minMoney;
    }

    public static void setMinMoney(double minMoney) {
        Accout.minMoney = minMoney;
    }

    @Override
    public String toString() {
        return "Accout[id="+id+",pwd="+pwd+".balance="+balance+"]";
    }
}

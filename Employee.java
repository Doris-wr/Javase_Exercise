package 抽象类.工资系统;

public abstract class Employee {
    private String name;
    private int number;//员工号
    private Mydate birthday;

    public Employee(String name, int number, Mydate birthday) {
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Mydate getBirthday() {
        return birthday;
    }

    public void setBirthday(Mydate birthday) {
        this.birthday = birthday;
    }

    public abstract double earning();
    @Override
    public String toString() {
        return "Employee[name"+name+",number"+number+",birthday="+birthday+"]";
    }
}
 class Mydate {
    private int year;
    private int month;
    private int day;

    public Mydate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String toDateString(){
        return year+"年"+month+"月"+day+"日";
    }
}

abstract class Employee {
    private String name;
    private int number;//员工号
    private Mydate birthday;

    public Employee(String name, int number, Mydate birthday) {
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Mydate getBirthday() {
        return birthday;
    }

    public void setBirthday(Mydate birthday) {
        this.birthday = birthday;
    }

    public abstract double earning();
    @Override
    public String toString() {
        return "Employee[name"+name+",number"+number+",birthday="+birthday+"]";
    }
}
class SalariedEmployee extends Employee{
    private double monthlySalary;
    public SalariedEmployee(String name,int number,Mydate birthday){
        super(name,number,birthday);
    }
    public SalariedEmployee(String name,int number,Mydate birthday,double monthlySalary){
        super(name,number,birthday);
        this.monthlySalary=monthlySalary;
    }
    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double earning() {
        return monthlySalary;
    }

    @Override
    public String toString() {
        return "SalaryEmployee["+super.toString()+"]";
    }
}
package 抽象类.工资系统;

import java.util.Scanner;

/*测试类
定义PayrollSystem类，创建Employee变量数组并初始化，该数组存放各类雇员对象的引用
利用循环遍历数组元素，输出各个对象的类型，name，number，birthday
当键盘输入本月分值时，如果本月是某个Employee对象的生日，还要输出增加工资信息
 */
public class PayrollSystem {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int month=scanner.nextInt();
        System.out.println("请输入当前的月份");
        Employee[] emps=new Employee[2];
        emps[0]=new SalariedEmployee("马森",1002,new Mydate(1992,2,28),10000);
        emps[1]=new HourlyEmployee("潘裕生",2001,new Mydate(1991,1,6),60,240);
        for (int i = 0; i < emps.length; i++) {
            System.out.println(emps[i]);
            double salary=emps[i].earning();
            System.out.println("月工资为"+salary);
            if(emps[i].getBirthday().getMonth()==month){
                System.out.println("生日快乐，奖励100元！");
            }
        }
    }
}


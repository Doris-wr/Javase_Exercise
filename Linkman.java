package contact;

import java.io.*;
import java.util.Scanner;

public class Linkman {
    Linkman(){phone=new String[10];}
    private String name;//姓名
    private String[] phone;//电话
    private String address;//地址
    private String code;//邮政编码
    private String email;//电子邮箱
    private String fphone;//家庭电话
    String  getName()//获取姓名
    {
        return name;
    }
    void setName(String name)//修改姓名
    {
        this.name=name;
    }
    String[]  getPhone()//获取电话
    {
        return phone;
    }
    void setPhone(String[] phone)//修改电话
    {
        this.phone=phone;
    }
    String  getAddress()//获取地址
    {
        return address;
    }
    void setAddress(String address)//修改地址
    {
        this.address=address;
    }
    String  getCode()//获取邮政编码
    {
        return code;
    }
    void setCode(String code)//修改邮政编码
    {
        this.code=code;
    }
    String  getEmail()//获取电子邮箱
    {
        return email;
    }
    void setEmail(String email)//修改电子邮箱
    {
        this.email=email;
    }
    String  getFphone()//获取家庭电话
    {
        return fphone;
    }
    void setFphone(String fphone)//修改家庭电话
    {
        this.fphone=fphone;
    }
}
//管理联系人类
class manageLinkman{
    Linkman[] l=new Linkman[1000];
    Scanner input=new Scanner(System.in);
    manageLinkman() {
        for(int i=0;i<l.length;i++)
        {
            if(l[i]==null)
                l[i]=new Linkman();
        }

    }
    Linkman[] list(Linkman x)//联系人列表
    {
        for(int i=0;i<l.length;i++)
        {
            if(l[i].getName()==null)
            {
                l[i]=x;
                break;
            }
        }
        return l;
    }
    void addLinkman()//添加实现
    {
        Linkman l1=new Linkman();
        boolean f=false;
        System.out.println("姓名:");
        String name=input.next();
        for(int i=0;i<l.length&&l[i].getName()!=null;i++)
        {
            if(l[i].getName().equals(name))
                f=true;
        }
        if(f)
            System.out.println("添加失败,该联系人已存在!");
        else
        {l1.setName(name);
            String[] phone=new String[10];
            for(int i=0;i<10;i++)
            {System.out.println("电话号码"+(i+1)+":");
                phone[i]=input.next();
                System.out.print("是否还要添加其他号码:1.是 0.否");
                String x =input.next();
                if(x.equals("1"))
                    System.out.println("请继续!");
                else if(x.equals("0"))
                {break;}
                else
                {System.out.println("指令错误,已退出!");
                    break;}
            }
            l1.setPhone(phone);
            System.out.println("地址:");
            String address=input.next();
            l1.setAddress(address);
            System.out.println("邮政编码:");
            String code=input.next();
            l1.setCode(code);
            System.out.println("电子邮箱:");
            String email=input.next();
            l1.setEmail(email);
            System.out.println("家庭电话:");
            String fphone=input.next();
            l1.setFphone(fphone);
            list(l1);
            System.out.println("添加成功!");}
    }
    int nameFind(String name) {//按姓名查找实现
        int i;
        boolean f=false;
        for(i=0;i<l.length&&l[i].getName()!=null;i++)
        {
            if(l[i].getName().equals(name))
            {f=true;
                break;
            }
        }
        if(f)
            return i;
        else
            return -1;
    }
    void del(int i) {//删除实现
        if(i==-1) {
            System.out.println("对不起，通讯录中没有此联系人");
            System.out.println("是否添加为新联系人：1.YES 2.NO");
            String x=input.next();
            if(x.equals("1"))
                addLinkman();
        }else {
            System.out.println("请选择你要删除的内容：");
            System.out.println("1.该联系人 2.电话 3.地址 4.邮政编码 5.电子邮箱 6.家庭电话");
            String x=input.next();
            switch(x){
                case "1":{
                    System.out.println("已删除联系人"+l[i].getName()+"!");
                    l[i].setName(" ");
                    String[] phone=new String[10];
                    System.arraycopy(l[i].getPhone(),0, phone,0, 10);
                    for(int j=0;j<phone.length&&phone[j]!=null;j++){
                        phone[j]=" ";
                    }
                    l[i].setPhone(phone);
                    l[i].setAddress(" ");
                    l[i].setCode(" ");
                    l[i].setEmail(" ");
                    l[i].setFphone(" ");
                }
                break;
                case "2":{
                    String[] phone=new String[10];
                    System.arraycopy(l[i].getPhone(),0, phone,0, 10);
                    for(int j=0;j<phone.length&&phone[j]!=null;j++){
                        System.out.print("是否要删除号码:"+phone[j]+" 1.是 0.否");
                        String c =input.next();
                        if(c.equals("1")){
                            System.out.println("号码"+phone[j]+"已删除!");
                            phone[j]=" ";
                            System.out.println("1.继续 2.退出");
                            String b1 =input.next();
                            if(b1.equals("2"))
                                break;
                        }
                        else
                            continue;
                    }
                    l[i].setPhone(phone);
                };
                break;
                case "3":{
                    System.out.println("地址已删除!");
                    l[i].setAddress(" ");
                }
                break;
                case "4":{
                    System.out.println("邮政编码已删除!");
                    l[i].setCode(" ");
                }
                break;
                case "5":{
                    System.out.println("电子邮箱已删除!");
                    l[i].setEmail(" ");
                }
                break;
                case "6":{
                    System.out.println("家庭电话已删除!");
                    l[i].setFphone(" ");
                }
                break;
                default:
                    System.out.println("输入错误！");
            }
        }
    }
    void printLinkman(int i) {//打印实现
        if(i==-1){
            System.out.println("对不起,通讯录中没有此联系人!");
            System.out.println("是否添加为新联系人:1.YES 2.NO");
            String x=input.next();
            if(x.equals("1"))
                addLinkman();
        }else{
            System.out.println("已为你找到该联系人!");
            System.out.println("姓名:"+l[i].getName());
            String[] num=new String[10];
            System.arraycopy(l[i].getPhone(), 0, num, 0, 10);
            for(int j=0;j<10&&num[j]!=null;j++){
                System.out.println("电话"+(j+1)+":"+num[j]);
            }
            System.out.println("地址:"+l[i].getAddress());
            System.out.println("邮政编码:"+l[i].getCode());
            System.out.println("电子邮箱:"+l[i].getEmail());
            System.out.println("家庭电话:"+l[i].getFphone());
        }
    }
    void updata(int i) {//修改实现
        if(i==-1){
            System.out.println("对不起,通讯录中没有此联系人!");
            System.out.println("是否添加为新联系人:1.YES 2.NO");
            String x=input.next();
            if(x.equals("1"))
                addLinkman();
        }else{
            System.out.println("请选择你要更新的内容:");
            System.out.println("1.姓名 2.电话 3.地址 4.邮政编码 5.电子邮箱 6.家庭电话");
            int x=input.nextInt();
            switch(x) {
                case 1:{
                    System.out.println("输入你要更新的姓名:");
                    String name=input.next();
                    l[i].setName(name);
                }
                break;
                case 2:{
                    String[] phone=new String[10];
                    System.arraycopy(l[i].getPhone(),0, phone,0, 10);
                    for(int j=0;j<phone.length;j++){
                        if(phone[j].equals(" ")){
                            continue;
                        }
                        System.out.println("是否要更新号码:"+phone[j]+" 1.是 0.否");
                        String b =input.next();
                        if(b.equals("1")){
                            System.out.println("请输入你要更新的号码:");
                            phone[j]=input.next();
                            System.out.print("原号码已更新为:"+phone[j]);
                            System.out.println("1.继续 2.退出");
                            String b1 =input.next();
                            if(b1.equals("2"))
                                break;
                        }else
                            continue;
                    }
                    l[i].setPhone(phone);
                }
                break;
                case 3:{
                    System.out.println("输入你要更新的地址:");
                    String address=input.next();
                    System.out.print("你已修改地址"+l[i].getAddress()+"为");
                    l[i].setAddress(address);
                    System.out.println(l[i].getAddress());
                }
                break;
                case 4:{
                    System.out.println("输入你要更新的邮政编码:");
                    String code=input.next();
                    System.out.print("你已修改邮政编码:"+l[i].getCode()+"为");
                    l[i].setCode(code);
                    System.out.println(l[i].getCode());
                }
                break;
                case 5:{
                    System.out.println("输入你要更新的电子邮箱:");
                    String email=input.next();
                    System.out.print("你已修改电子邮箱:"+l[i].getEmail()+"为");
                    l[i].setEmail(email);
                    System.out.print(l[i].getEmail());
                }
                break;
                case 6:{
                    System.out.println("输入你要更新的家庭电话:");
                    String fphone=input.next();
                    System.out.print("你已修改家庭电话:"+l[i].getFphone()+"为");
                    l[i].setFphone(fphone);
                    System.out.print(l[i].getFphone());
                }
                break;
                default:
                    System.out.println("输入错误！");
            }
        }
    }

}
class Test{//测试类
    Scanner input=new Scanner(System.in);
    manageLinkman m=new manageLinkman();
    public void add() {//添加执行
        System.out.println("开始添加联系人......");
        m.addLinkman();
    }
    public void find() {//查找执行
        System.out.println("输入你要查找联系人的姓名:");
        String name=input.next();
        m.printLinkman(m.nameFind(name));
    }

    public void del() {//删除执行
        System.out.println("输入你要删除联系人的姓名:");
        String name=input.next();
        m.del(m.nameFind(name));
    }
    public void up() {//修改执行
        System.out.println("输入你要修改联系人的姓名:");
        String name=input.next();
        m.updata((m.nameFind(name)));
    }
    public void cout() {//打印执行
        System.out.println("输入你要打印联系人的姓名:");
        String name=input.next();
        m.printLinkman(m.nameFind(name));
        System.out.println("打印完毕!");
    }

    public void Menu()throws java.io.IOException {//菜单
        do {
            System.out.println("-----------------欢迎使用通讯录管理系统!-----------------");
            System.out.println(" 1.添加联系人 ");
            System.out.println(" 2.删除联系人 ");
            System.out.println(" 3.修改联系人 ");
            System.out.println(" 4.搜索联系人 ");
            System.out.println(" 5.打印联系人 ");
            System.out.println("请输入指令数字进行操作：");
            String key = input.next();
            switch (key) {
                case "1":
                    add();
                    break;
                case "2":
                    del();
                    break;
                case "3":
                    up();
                    break;
                case "4":
                    find();
                    break;
                case "5":
                    cout();
                    break;
                default:
                    System.out.println("输入错误！");
                    continue;
            }
            break;
        }
        while(true);
    }
    public static void main(String[] args)throws java.io.IOException 	{
        Test t=new Test();
        while(true){
            t.Menu();
        }
    }
}

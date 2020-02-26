package 栈和队列;

import java.util.Stack;

class Node{
    public  int data;
    public Node next;
    public Node(int data){
        next=null;
        this.data=data;
    }
}

class Test20200225{
    //递归方式实现逆序打印
    public static void print(Node head){
        if(head!=null){
            print(head.next);
            System.out.println(head.data);
        }

    }
    //循环方式实现逆序打印
    public static void print2(Node head){
        Node cur=head;
        Stack<Node>s=new Stack();
        while(cur!=null){
            s.push(cur);
            cur=cur.next;
        }
        //将栈中的元素依次出栈
        while(!s.empty()){
            Node top=s.peek();//取栈顶元素
            System.out.println(top.data);
            s.pop();
        }
    }
    public static void main(String[] args){
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(4);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        print(n1);
        print2(n1);
    }
}
class Node{
    public  int data;
    public Node next;
    public Node(int data){
        next=null;
        this.data=data;
    }
}

public class Test20200225 {
    //递归方式实现逆序打印
    public static void print(Node head){
        if(head!=null){
            print(head.next);
            System.out.println(head.data);
        }

    }
    //循环方式实现逆序打印
    public static void print2(Node head){
        Node cur=head;
        Stack<Node>s=new Stack();
        while(cur!=null){
            s.push(cur);
            cur=cur.next;
        }
        //将栈中的元素依次出栈
        while(!s.empty()){
            Node top=s.peek();//取栈顶元素
            System.out.println(top.data);
            s.pop();
        }
    }
    public static void main(String[] args){
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(4);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        print(n1);
        print2(n1);
    }
}

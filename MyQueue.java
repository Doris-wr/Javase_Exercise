package 栈和队列.面试题.用栈实现队列;

import java.util.Stack;
/*
* 用s1模拟入队列，s2迷你出队列
 *  */
public class MyQueue {
    private Stack<Integer>s1;//模拟入队列
    private Stack<Integer>s2;//模拟出队列
    public MyQueue(){
        s1=new Stack<>();
        s2=new Stack<>();
    }
    //入队列
    public void push(int x) {
        s1.push(x);
    }
    //出队列
    public int pop(){
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    //返回队顶元素
    public int peek(){
        if(s2.empty()){
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }
    //判空
    public boolean empty() {
        return s1.empty()&&s2.empty();
    }
}

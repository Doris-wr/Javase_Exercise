package 栈和队列.面试题.有效的括号;

import java.util.Stack;

public class isValid{
    public boolean isValid(String s) {
        Stack<Character> ss = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //左括号入栈
            if (ch == '(' || ch == '[' || ch =='{') {
                 ss.push(ch);
            }else{
                //ch是右括号
                //如果栈是空，说明右括号比左括号多
                if(ss.empty()){
                    return false;
                }
                char chLeft=ss.peek();
                //检测ch的右括号与chLeft左括号是否匹配
                if(chLeft=='('&&ch==')'||chLeft=='['&&ch==']'||chLeft=='{'&&ch=='}'){
                    ss.pop();
                }else{
                    //左右括号匹配有问题
                    return false;
                }
            }
        }
        if(!ss.empty()){
            //左括号比右括号多
            return false;
        }
        return true;
    }
}

class Node{
    int val;
    Node next;
    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}
public class MyLinkedList {
    public Node head;

    public MyLinkedList() {
        this.head = null;
    }
    //    头插法
    public void addFirst(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    //    尾插法
    public void addLast(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
        } else {
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }
// 查找是否包含关键字key是否在单链表中
    public boolean contains(int key) {
        Node cur = head;
        while (cur != null) {
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
//  得到链表的长度
    public int getLength(){
        int count=0;
        Node cur=head;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        return  count;
    }
//  找到index-1的位置
    public Node searchIndex(int index){
        Node cur=head;
        for(int i=0;i<index-1;i++){
            cur=cur.next;
        }
        return cur;
    }
// 在任意位置插入
    public boolean addIndex(int index,int val){
        if(index<0|index>getLength()){
            System.out.println("index不合法");
            return false;
        }
        if(index==0){
            addFirst(val);
            return true;
        }
        //找到index-1的位置
        Node cur=searchIndex(index);
        Node node =new Node(val);
        node.next=cur.next;
        cur.next=node;
        return true;
    }
// 打印
    public void  display(){
        Node cur=head;
        while(cur!=null){
            System.out.println(cur.val+" ");
            cur=cur.next;
        }
        System.out.println();
    }
}

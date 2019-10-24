public class ReverseList{
    class Node{
        int val;
        Node next;
        public Node(int val){
            this.val=val;
        }
    }
    public Node reverseList(Node head){
        Node cur=head;
        Node result=null;
        while(cur!=null){
            Node next=cur.next;
            cur.next=result;
            result=cur;
            cur=next;
        }
        return result;
    }
}

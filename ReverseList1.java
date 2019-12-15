 public Node reverseList1(Node head){
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

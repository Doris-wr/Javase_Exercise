public class RemoveElements{
    class Node{
        int val;
        Node next;
        public Node(int val){
            this.val=val;
        }
    }
   public ListNode removeElements(ListNode head, int val) {
        ListNode prev=null;
		ListNode cur=head;
		while(cur!=null){
			if(cur.val==val){
				if(cur==head){
					head=cur.next;
				}else{
					prev.next=cur.next;
				}
			}else{
				prev=cur;
			}
			cur=cur.next;
		}
		return head;
	 }
}

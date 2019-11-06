    public boolean chkPalindromde(){
        Node fast=head;
        Node slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        //反转单链表后半部分
        Node p=slow.next;
        while(p!=null){
            Node pNext=p.next;
            p.next=slow;
            slow=p;
            p=pNext;
        }
        //判断是有回文
        while(head.val==slow.val){
            head=head.next;
            slow=slow.next;
            if(head==slow){
                return true;
            }
        }
        return false;
    }

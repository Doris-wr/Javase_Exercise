   public Node partition(int x) {
        Node cur = head;
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;
        while (cur != null) {
            if (cur.val < x) {
                if (beforeStart == null) {//第一次插入
                    beforeStart = cur;
                    beforeEnd = cur;
                } else {
                    beforeEnd.next = cur;
                    beforeEnd = beforeEnd.next;
                }
            } else {
                if (afterStart == null) {//第一次插入
                    afterStart = cur;
                    afterEnd = cur;
                } else {
                    afterEnd.next = cur;
                    afterEnd = afterEnd.next;
                }
            }
            cur = cur.next;
        }
        if (beforeStart == null) {
            return afterStart;
        }
        beforeEnd.next = afterStart;
        if (afterStart != null) {
            afterEnd.next = null;
        }
        return beforeStart;
    }

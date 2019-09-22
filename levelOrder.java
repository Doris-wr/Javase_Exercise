public static void levelOrder(Node root) {
		if(root==null) {
			return;
		}
		Queue<Node>queue=new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			Node front=queue.poll();
			System.out.println(front.val);
			if(front.left!=null) {
				queue.offer(front.left);
			}
			if(front.right!=null) {
				queue.offer(front.right);
			}
		}
	}

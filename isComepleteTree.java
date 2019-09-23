public static boolean isComepleteTree(Node root) {
		if(root==null) {
			return true;
		}
		Queue<Node>queue=new LinkedList<>();
		queue.offer(root);
		while(true) {
			Node front=queue.poll();
			//判读front是不是空节点
			if(front==null) {
				break;
			}
			queue.offer(front.left);
			queue.offer(front.right);
		}
			//去检查队列中是否全为null
		while(!queue.isEmpty()) {
			Node n=queue.poll();
			if(n!=null) {
				return false;
			}
		}
		return true;
	}

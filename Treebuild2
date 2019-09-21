private static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {
			val=x;
		}
}
private static class BTRV{
		private TreeNode root;
		private int used;
	}
public BTRV buildTree4(List<Integer>preorder) {
		BTRV returnValue=new BTRV();
		if(preorder.size()==0) {
			returnValue.root=null;
			returnValue.used=0;
			return returnValue;
		}
		int rootValue=preorder.get(0);
		if(rootValue=='#') {
			returnValue.root=null;
			returnValue.used=1;
			return returnValue;
		}
		BTRV leftReturn=buildTree4(preorder.subList(1,preorder.size()));
		BTRV rightReturn=buildTree4(preorder.subList(1+leftReturn.used,preorder.size()));
		TreeNode root =new TreeNode(rootValue);
		root.left=leftReturn.root;
		root.right=rightReturn.root;
		returnValue.root=root;
		returnValue.used=1+leftReturn.used+rightReturn.used;
		return returnValue;
}
	
	

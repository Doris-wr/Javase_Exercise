/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Mirror {
    public void mirror(TreeNode root) {
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            return;
        }
        TreeNode pTemp=root.left;
        root.left=root.right;
        root.right=pTemp;
        if(root.left!=null){
            mirror(root.left);
        }
        if(root.right!=null){
            mirror(root.right);
        }
    }
}

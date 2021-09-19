package Binary_tree;

class BinaryTreeNode<Integer> {
	public Integer data;
	public BinaryTreeNode <Integer> left, right,parent;
	BinaryTreeNode(Integer data) 
    { 
        this.data = data; 
        left = right = null;
    }

}
public class COMPUTE_THE_LOWEST_COMMON_ANCESTOR_IN_A_BINARY_TREE {
	private static class Status {
		public int numTargetNodes ;
		public BinaryTreeNode <Integer> ancestor;
		public Status(int numTargetNodes, BinaryTreeNode <Integer> node) {
			this.numTargetNodes = numTargetNodes;
		    this.ancestor = node ;
		}
	}
	public static BinaryTreeNode<Integer> LCA(BinaryTreeNode <Integer> tree,BinaryTreeNode <Integer> node0,BinaryTreeNode <Integer> node1) {
		return LCAHelper(tree , node0, node1).ancestor ;
	}
	private static Status LCAHelper(BinaryTreeNode <Integer> tree,BinaryTreeNode <Integer> node0,BinaryTreeNode <Integer> node1) {
		if (tree == null) {
			return new Status(0, null);
		}
		Status leftResult = LCAHelper(tree.left , node0, node1);
		if(leftResult.numTargetNodes == 2) {
			// Found both nodes in the left subtree.
		    return leftResult;
		}
		Status rightResult = LCAHelper(tree.right , node0, node1);
		if (rightResult.numTargetNodes == 2){
			// Found both nodes in the right subtree.
		    return rightResult;
		}
		int numTargetNodes = leftResult.numTargetNodes + rightResult.numTargetNodes+ (tree == node0 ? 1 : 0) + (tree == node1 ? 1 : 0) ;
		return new Status (numTargetNodes , numTargetNodes == 2 ? tree : null);
	}
		public static void main(String[] args) {
		// TODO Auto-generated method stub
			BinaryTreeNode<Integer> tree = new BinaryTreeNode<Integer>(1);
			tree.left = new BinaryTreeNode<Integer>(2);						//            1
	        tree.right = new BinaryTreeNode<Integer>(3);					//		     /  \
	        tree.left.left = new BinaryTreeNode<Integer>(4);				//			2    3
	        tree.left.right = new BinaryTreeNode<Integer>(5);				//		   / \   /\
	        tree.right.left = new BinaryTreeNode<Integer>(6);				//		  4	  5 6  7
	        tree.right.right = new BinaryTreeNode<Integer>(7);				//
	 
	        System.out.println("LCA(4,5): " +LCA(tree,tree.left.left, tree.left.right).data);
	        System.out.println("LCA(4,6): " +LCA(tree,tree.left.left, tree.right.left).data);
	        System.out.println("LCA(3,5): " +LCA(tree,tree.right, tree.left.right).data);
	     
	    }
}

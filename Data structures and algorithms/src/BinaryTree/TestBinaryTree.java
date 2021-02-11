package BinaryTree;

public class TestBinaryTree {

    public static void main(String[] args) {
        //创建二叉树
        BinaryTree binaryTree = new BinaryTree();

        //设置根节点
        TreeNode root = new TreeNode(1);
        binaryTree.setRootNode(root);

        //设置左节点
        TreeNode rootLeftNode = new TreeNode(2);
        root.setLeftNode(rootLeftNode);
        //设置又节点
        TreeNode rootRightNode = new TreeNode(3);
        root.setRightNode(rootRightNode);

        //为第二层节点创建子节点
        rootLeftNode.setLeftNode(new TreeNode(4));
        rootLeftNode.setRightNode(new TreeNode(5));

        rootRightNode.setLeftNode(new TreeNode(6));
        rootRightNode.setRightNode(new TreeNode(7));

        //先序遍历
//        binaryTree.frontShow();
////        System.out.println("=================");
////        binaryTree.midShow();
////        System.out.println("=================");
////        binaryTree.afterShow();

        // 查找节点
       // System.out.println(binaryTree.frontSearch(2));
        //删除节点
        binaryTree.delete(1);
        binaryTree.frontShow();
    }
}

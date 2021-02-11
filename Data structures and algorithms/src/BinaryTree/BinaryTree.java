package BinaryTree;

/**
 * 二叉树
 */
public class BinaryTree {

    TreeNode treeNode;

    /*public BinaryTree(TreeNode treeNode){
        this.treeNode = treeNode;
    }*/

    /*
        设置根节点
     */
    public void setRootNode(TreeNode treeNode){
        this.treeNode = treeNode;
    }

    /*
        获取根节点
     */
    public TreeNode getTreeNode(){
        return treeNode;
    }

    /*
        前序遍历
     */
    public void frontShow(){
        if (treeNode != null) {
            treeNode.frontShow();
        }
    }

    /**
     * 中序遍历
     */
    public void midShow() {
        if (treeNode != null) {
            treeNode.midShow();
        }
    }

    /**
     * 后序遍历
     */
    public void afterShow() {
        if (treeNode != null) {
            treeNode.afterShow();
        }
    }

    /**
     * 前序查找
     */
    public TreeNode frontSearch(int value) {
        return treeNode.frontSearch(value);
    }

    public void delete(int i) {
        if (treeNode.value == i) {
            treeNode = null;
        }else{
            treeNode.delete(i);
        }
    }
}

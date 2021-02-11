package BinaryTree;


/**
 * 二叉树节点
 */
public class TreeNode {
    /*
       节点权值
     */
    int value;

    /*
        左节点
     */
    TreeNode leftNode;

    /*
        右节点
     */
    TreeNode rightNode;

    public TreeNode(int value){
        this.value = value;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    /**
     * 前序遍历
     */
    public void frontShow() {
        System.out.println(value);
        if (leftNode != null) {
            leftNode.frontShow();
        }
        if (rightNode != null) {
            rightNode.frontShow();
        }
    }

    /**
     * 中序遍历
     */
    public void midShow() {
        if (leftNode != null) {
            leftNode.midShow();
        }
        System.out.println(value);
        if (rightNode != null) {
            rightNode.midShow();
        }
    }

    /**
     * 后续遍历
     */
    public void afterShow() {
        if (leftNode != null) {
            leftNode.afterShow();
        }
        if (rightNode != null) {
            rightNode.afterShow();
        }
        System.out.println(value);
    }

    /**
     * 前序查找
     */
    public TreeNode frontSearch(int value) {
        // 目标元素
        TreeNode target = null;
        //如果是根节点
        if(this.value == value){
            return this;
        }else {
            if (leftNode != null) {
                target = leftNode.frontSearch(value);
            }
            if (target != null) {
                return target;
            }
            if (rightNode != null) {
                target = rightNode.frontSearch(value);
            }
        }
        return target;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                ", leftNode=" + leftNode +
                ", rightNode=" + rightNode +
                '}';
    }

    /**
     * 删除节点
     * @param i
     */
    public void delete(int i) {
        // 记录父节点
        TreeNode parent = this;
        if (parent.leftNode != null && parent.leftNode.value == i) {
            parent.leftNode = null;
        }
        if (parent.rightNode != null && parent.rightNode.value == i) {
            parent.rightNode = null;
        }
        parent = this.leftNode;
        if (parent != null) {
            parent.delete(i);
        }
        parent = this.rightNode;
        if (parent != null) {
            parent.delete(i);
        }

    }
}

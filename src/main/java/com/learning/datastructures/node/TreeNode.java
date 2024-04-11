package com.learning.datastructures.node;

public class TreeNode<T> extends Node<T> {
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T data) {
        super(data);
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }
}

package com.learning.datastructures.tree;

import com.learning.datastructures.node.BinaryTreeNode;

public class BinaryTree<T> {
    protected BinaryTreeNode<T> root;
    protected int nodes;

    public BinaryTree() {
        this.root = null;
        this.nodes = 0;
    }

    public BinaryTree(T[] array, int size) {
        this.root = generateBalancedTree(array, 0, size);
        this.nodes = size;
    }

    public static void main(String[] args) {
        Integer[] array = { 1, 2, 3, 4, 5, 6, 7 };
        BinaryTree<Integer> tree = new BinaryTree<>(array, array.length);

        System.out.println("Tree root: " + tree.getRoot().getData());
        tree.printTree();
    }

    protected BinaryTreeNode<T> generateBalancedTree(T[] array, int index, int size) {
        if (index >= size || index >= array.length) return null;

        BinaryTreeNode<T> node = new BinaryTreeNode<>(array[index]);
        node.setLeft(generateBalancedTree(array, index * 2 + 1, size));
        node.setRight(generateBalancedTree(array, index * 2 + 2, size));

        return node;
    }

    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode<T> root) {
        this.root = root;
    }

    public int getNodes() {
        return nodes;
    }

    public boolean isEmpty() {
        return nodes == 0;
    }

    @SuppressWarnings("unchecked")
    public T[] toArray() {
        T[] array = (T[]) new Object[nodes];
        toArray(root, array, 0);

        return array;
    }

    private void toArray(BinaryTreeNode<T> node, T[] array, int index) {
        if (node == null) return;

        array[index] = node.getData();
        toArray(node.getLeft(), array, index * 2 + 1);
        toArray(node.getRight(), array, index * 2 + 2);
    }

    public void printTree() {
        printTree(root, 0);
    }

    private void printTree(BinaryTreeNode<T> node, int level) {
        if (node == null) return;

        printTree(node.getRight(), level + 1);
        for (int i = 0; i < level; i++)
            System.out.print("    ");
        System.out.println("[ " + node.getData() + " ]");
        printTree(node.getLeft(), level + 1);
    }
}

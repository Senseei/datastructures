package com.learning.datastructures.tree;

public class BinaryHeap<T> extends BinaryTree<T> {

    public static void main(String[] args) {
        Integer[] array = { 1, 2, 3, 4, 5, 6, 7 };
        BinaryHeap<Integer> heap = new BinaryHeap<>(array, array.length);

        System.out.println("Heap root: " + heap.getRoot().getData());
        heap.printTree();
    }

    public BinaryHeap() {
        super();
    }

    public BinaryHeap(T[] array, int size) {
        super(array, size);
        heapify();
    }

    private void heapify() {
        if (isEmpty()) return;

        T[] array = toArray();

        for (int i = nodes / 2 - 1; i >= 0; i--)
            heapify(array, nodes, i);

        root = generateBalancedTree(array, 0, nodes);
    }

    @SuppressWarnings("unchecked")
    private void heapify(T[] array, int size, int index) {
        int biggest = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;  
        
        if (leftChild < size && ((Comparable<T>)array[leftChild]).compareTo(array[biggest]) > 0)
            biggest = leftChild;
        if (rightChild < size && ((Comparable<T>)array[rightChild]).compareTo(array[biggest]) > 0)
            biggest = rightChild;
        
        if (biggest != index) {
            swap(array, index, biggest);
            heapify(array, size, biggest);
        }
    }

    @SuppressWarnings("unchecked")
    private void swap(T[] array, int index1, int index2) {
        Object temp = array[index1];
        array[index1] = array[index2];
        array[index2] = (T) temp;
    }
}

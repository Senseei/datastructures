package com.learning.datastructures.queue;

import java.util.NoSuchElementException;
import java.util.Random;

public class PriorityQueueImplementation<T extends Comparable<T>> {
    private Object[] array = new Object[15];
    private int size;

    public static void main(String[] args) {
        PriorityQueueImplementation<Integer> queue = new PriorityQueueImplementation<>();

        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            queue.enqueue(random.nextInt(10));
        }

        queue.printTree();
        System.out.println("------------");
        while (!queue.isEmpty()) {
            System.out.println("Dequeued: " + queue.dequeue());
            queue.printTree();
            System.out.println("------------");
        }
    }

    public void enqueue(T element) {
        array[size] = element;
        size++;

        // Increases the capacity if the array is full
        if (size == array.length) {
            Object[] resized = new Object[size * 3/2];
            for (int i = 0; i < array.length; i++) {
                resized[i] = array[i];
            }
            array = resized;
        }

        heapify(size);
    }

    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (size == 0)
            throw new NoSuchElementException("Queue is empty");

        T element = (T) array[0];
        array[0] = array[size - 1];
        array[size - 1] = null;
        size--;

        heapify(size);
        
        return element;
    }

    private void heapify(int size) {
        if (size <= 1) return;

        for (int i = size / 2 - 1; i >= 0; i--)
            heapify(size, i);
    }

    @SuppressWarnings("unchecked")
    private void heapify(int size, int index) {
        int biggest = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;  
        
        if (leftChild < size && ((Comparable<T>)array[leftChild]).compareTo((T)array[biggest]) > 0)
            biggest = leftChild;
        if (rightChild < size && ((Comparable<T>)array[rightChild]).compareTo((T)array[biggest]) > 0)
            biggest = rightChild;
        
        if (biggest != index) {
            swap(index, biggest);
            heapify(size, biggest);
        }
    }

    private void swap(int index1, int index2) {
        Object temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (size == 0)
            return null;

        return (T) array[0];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printTree() {
        printTree(0, 0);
    }

    private void printTree(int index, int level) {
        if (index >= size) return;

        printTree(index * 2 + 2, level + 1);

        for (int i = 0; i < level; i++)
            System.out.print("   ");
        System.out.println("[ " + array[index] + " ]");

        printTree(index * 2 + 1, level + 1);
    }
}

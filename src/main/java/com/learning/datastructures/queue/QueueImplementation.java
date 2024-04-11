package com.learning.datastructures.queue;

import com.learning.datastructures.node.LinkedNode;

public class QueueImplementation<T> {
    private LinkedNode<T> front;
    private LinkedNode<T> rear;
    private int size;

    public void enqueue(T data) {
        LinkedNode<T> newNode = new LinkedNode<>(data);
        if (front == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
        size++;
    }

    public T dequeue() {
        if (front == null)
            return null;

        T data = front.getData();
        front = front.getNext();
        size--;

        if (front == null)
            rear = null;

        return data;
    }

    public T peek() {
        if (front == null)
            return null;

        return front.getData();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        LinkedNode<T> current = front;
        sb.append("[ ");
        while (current.getNext() != null) {
            sb.append(current).append(", ");
            current = current.getNext();
        }
        sb.append(current);
        sb.append(" ]");
        return sb.toString();
    }
}

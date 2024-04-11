package com.learning.datastructures.stack;

import com.learning.datastructures.node.LinkedNode;

public class StackImplementation<T> {

    private LinkedNode<T> top;
    private int size;

    public void push(T data) {
        if (top == null) {
            top = new LinkedNode<>(data);
        } else {
            LinkedNode<T> newNode = new LinkedNode<>(data);
            newNode.setNext(top);
            top = newNode;
        }
        size++;
    }

    public T pop() {
        if (top == null)
            return null;

        T data = top.getData();
        top = top.getNext();
        size--;
        return data;
    }

    public T peek() {
        if (top == null)
            return null;

        return top.getData();
    }
}

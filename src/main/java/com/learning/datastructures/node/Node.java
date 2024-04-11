package com.learning.datastructures.node;

public class Node<T> {
    protected Object data;

    public Node(T data) {
        this.data = data;
    }

    @SuppressWarnings("unchecked")
    public T getData() {
        return (T) data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}

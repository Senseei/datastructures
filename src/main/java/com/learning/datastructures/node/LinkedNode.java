package com.learning.datastructures.node;

public class LinkedNode<T> extends Node<T> {
    private LinkedNode<T> next;
    
    public LinkedNode(T data) {
        super(data);
    }

    public LinkedNode<T> getNext() {
        return this.next;
    }

    public void setNext(LinkedNode<T> next) {
        this.next = next;
    }
}

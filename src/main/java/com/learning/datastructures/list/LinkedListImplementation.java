package com.learning.datastructures.list;

import com.learning.datastructures.node.LinkedNode;

public class LinkedListImplementation<T> {
    private LinkedNode<T> head;
    private int size;

    public static void main(String[] args) {
        LinkedListImplementation<Integer> list = new LinkedListImplementation<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list);
        System.out.println("Element at index 2: " + list.get(2));
        System.out.println("Element removed at index 2: " + list.remove(2));
        System.out.println(list);
    }

    public void add(T element) {
        if (head == null) {
            head = new LinkedNode<>(element);
            size++;
            return;
        }

        add(element, head);
        size++;
    }

    private void add(T element, LinkedNode<T> current) {
        // Se o proximo for nulo, chegamos ao fim da lista
        if (current.getNext() == null) {
            LinkedNode<T> newNode = new LinkedNode<>(element);
            current.setNext(newNode);
            return;
        }
        add(element, current.getNext());
    }

    public T remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        if (index == 0) {
            size--;
            return head != null ? head.getData() : null;
        }

        LinkedNode<T> prev = head;
        for (int i = 1; i < index; i++) {
            prev = prev.getNext();
        }

        LinkedNode<T> current = prev.getNext();
        prev.setNext(current.getNext());
        size--;
        return current.getData();
    }

    public boolean remove(T element) {
        if (head == null)
            return false;

        if (head.getData().equals(element)) {
            head = head.getNext();
            size--;
            return true;
        }

        LinkedNode<T> prev = head;
        LinkedNode<T> current = head.getNext();
        while(current != null) {
            if (current.getData().equals(element)) {
                prev.setNext(current.getNext());
                size--;
                return true;
            }
            prev = current;
            current = current.getNext();
        }

        return false;
    }

    public T get(int index) {
        if (index < 0 || index >= size || head == null)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        LinkedNode<T> current = head;
        for (int i = 0; i < index; i++)
            current = current.getNext();

        return current.getData();
    }

    public boolean contains(T element) {
        for (LinkedNode<T> n = head; n != null; n = n.getNext()) {
            if (n.getData().equals(element))
                return true;
        }
        return false;
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
        sb.append("[ ");
        LinkedNode<T> current = head;
        while (current.getNext() != null) {
            sb.append(current).append(", ");
            current = current.getNext();
        }
        sb.append(current);
        sb.append(" ]");

        return sb.toString();
    }
}

package com.learning.datastructures.list;

public class ArrayListImplementation<T> {
    private static final int INITIAL_CAPACITY = 10;
    private int size;
    private Object[] array = new Object[INITIAL_CAPACITY];
    // lista1

    public static void main(String[] args){
        ArrayListImplementation<Integer> list = new ArrayListImplementation<>();
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

    public void add(T element){
        if(size == array.length)
            increaseCapacity();

        array[size++] = element;
    }

    @SuppressWarnings("unchecked")
    public T remove(int index){
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        T element = (T) array[index];
        for(int i = index; i < size - 1; i++){
            array[i] = array[i + 1];
        }
        size--;

        if (size < array.length / 2) {
            int newSize = array.length * (2 / 3);
            Object[] newArray = new Object[newSize];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }

        return element;
    }

    @SuppressWarnings("unchecked")
    public T get(int index){
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        return (T) array[index];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < size - 1; i++) {
            sb.append(array[i]).append(", ");
        }
        sb.append(array[size - 1]);
        sb.append(" ]");

        return sb.toString();
    }

    private void increaseCapacity(){
        int newSize = array.length * (3/2);
        Object[] newArray = new Object[newSize];
        for(int i = 0; i < array.length; i++){
            newArray[i] = array[i];
        }
        array = newArray;
    }
}
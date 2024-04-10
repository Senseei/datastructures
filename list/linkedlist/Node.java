package list.linkedlist;

public class Node<T> {
    private Object data;
    private Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    @SuppressWarnings("unchecked")
    public T getData() {
        return (T) data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}

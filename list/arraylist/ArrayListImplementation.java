package list.arraylist;

public class ArrayListImplementation<T>{
    private static final int INITIAL_CAPACITY = 10;
    private int size = 0;
    private Object[] list = new Object[INITIAL_CAPACITY];

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
        if(size == list.length)
            increaseCapacity();

        list[size++] = element;
    }

    @SuppressWarnings("unchecked")
    public T remove(int index){
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        T element = (T) list[index];
        for(int i = index; i < size - 1; i++){
            list[i] = list[i + 1];
        }
        size--;
        return element;
    }

    @SuppressWarnings("unchecked")
    public T get(int index){
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        return (T) list[index];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < size - 1; i++) {
            sb.append(list[i]).append(", ");
        }
        sb.append(list[size - 1]);
        sb.append(" ]");

        return sb.toString();
    }

    private void increaseCapacity(){
        int newSize = list.length * (3/2);
        Object[] newList = new Object[newSize];
        for(int i = 0; i < list.length; i++){
            newList[i] = list[i];
        }
        list = newList;
    }
}
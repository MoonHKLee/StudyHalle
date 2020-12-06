package issue4.chapter5;

public class ArrayQueue {
    int[] arr;
    private int capacity;
    private int size;
    private int tail;

    public ArrayQueue() {
        this.arr = new int[5];
        capacity = 5;
        tail = -1;
    }

    public void offer(int data) {
        tail++;
        arr[tail] = data;
        size++;
        checkSize();
    }

    public int poll() {
        int tmp = arr[0];
        fillEmptyPlace();
        size--;
        tail--;
        return tmp;
    }

    private void fillEmptyPlace() {
        if (arr.length - 1 >= 0) {
            System.arraycopy(arr, 1, arr, 0, arr.length - 1);
        }
    }

    public int peek() {
        return arr[0];
    }

    private void sizeUp() {
        int[] newArray = new int[2 * capacity];
        System.arraycopy(arr, 0, newArray, 0, capacity);
        capacity *= 2;
        arr = newArray;
    }

    private boolean isLeftOne() {
        return size == capacity - 1;
    }

    private void checkSize() {
        if (isLeftOne()) {
            sizeUp();
        }
    }

    public int getSize() {
        return size;
    }
}

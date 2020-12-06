package issue4.chapter3;

public class Stack {

    int[] arr;
    private int capacity;
    private int size;
    private int top;

    public Stack() {
        this.arr = new int[5];
        capacity = 5;
        top = -1;
    }

    public void push(int data) {
        top++;
        arr[top] = data;
        size++;
        checkSize();
    }

    public int pop() {
        size--;
        top--;
        return arr[top + 1];
    }

    public int peek() {
        return arr[top];
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

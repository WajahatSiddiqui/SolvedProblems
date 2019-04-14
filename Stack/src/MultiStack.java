import java.util.Arrays;

/**
 * Class Implement Multi Stack in an Array
 * Created by wajahat
 */
public class MultiStack {
    private int numberOfStacks;
    private int [] storage;
    private int size;
    private int [] stackTop;
    private int stackCapacity;

    MultiStack(int numberOfStacks, int N) {
        this.numberOfStacks = numberOfStacks;
        this.size = N;
        storage = new int [this.size];
        stackTop = new int[numberOfStacks];
        Arrays.fill(stackTop, -1);
        stackCapacity = this.size / numberOfStacks;
    }

    private int getTop(int stackNum, int top) {
        return (top + getStackIndex(stackNum) * stackCapacity);
    }

    private int getStackIndex(int stackNum) {
        return stackNum - 1;
    }

    public void push(int stackNum, int data) {
        if (isFull(stackNum)) // overflow
            return;
        storage[getTop(stackNum, ++stackTop[getStackIndex(stackNum)])] = data;
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) // underflow
            return -1;
        int data = peek(stackNum);
        stackTop[getStackIndex(stackNum)]--;
        return data;
    }

    public int peek(int stackNum) {
        return storage[getTop(stackNum, stackTop[getStackIndex(stackNum)])];
    }

    public boolean isFull(int stackNum) {
        return stackTop[getStackIndex(stackNum)] == stackCapacity - 1;
    }

    public boolean isEmpty(int stackNum) {
        return stackTop[getStackIndex(stackNum)] == -1;
    }

    public int size(int stackNum) {
        return stackTop[getStackIndex(stackNum)] + 1;
    }
}

/*
 * Name: Queue
 * Date: May 3, 2016
 * Version: v0.1
 * Author: Mr. R. Misiak
 * Description: Creates a Queue object.
 */
package part4;

/**
 *
 * @author 1misiakrya
 */
public class Queue implements QueueInterface {

    public static final int DEFAULT_CAPACITY = 6;

    private int front;
    private int back;
    private int[] data;

    public Queue() {
        this(DEFAULT_CAPACITY);
    }

    public Queue(int capacity) {
        this.front = -1;
        this.back = -1;
        data = new int[capacity];
    }

    @Override
    public int front() {
        return front;
    }

    @Override
    public int back() {
        return back;
    }

    @Override
    public void enqueue(int value) {
        if (this.isEmpty()) {
            this.front = 0;
            this.back = 0;
            this.data[back] = value;
        } else if (this.isFull()) {
            System.out.println("ERROR - LINE IS FULL");
        } else {
            this.back++;
            this.back = this.back % this.capacity();
            this.data[this.back] = value;
        }

//        if (this.back++ % this.size() == 0) {
//            back = 0;
//        }
//        data[back] = value;
    }

    @Override
    public int dequeue() {
        int value;
        if (this.size() == 0) {
            return -1;
        } else if (this.size() == 1) {
            value = data[front];
            makeEmpty();
        } else {
            value = data[front];
            this.front++;
            this.front = this.front % this.capacity();
        }
        return value;
    }

    @Override
    public int size() {
        if (this.back > this.front) {
            return (this.back - this.front) + 1;
        } else if (this.isEmpty()) {
            return 0;
        } else if (this.back == this.front) {
            return 1;
        } else {
            return this.back + 1 + data.length - this.front;
        }
    }

    @Override
    public int capacity() {
        return this.data.length;
    }

    @Override
    public boolean isEmpty() {
        return front == -1;
    }

    @Override
    public boolean isFull() {
        return this.size() == this.capacity();
    }

    @Override
    public void makeEmpty() {
        this.front = -1;
        this.back = -1;
    }

}

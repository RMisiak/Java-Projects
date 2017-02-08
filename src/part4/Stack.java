/*
 * Name: Stack
 * Date: May 2, 2016
 * Version: v0.1
 * Author: Mr. R. Misiak
 * Description: Creates a Stack object.
 */
package part4;

/**
 *
 * @author 1misiakrya
 */
public class Stack implements StackInterface {

    private int top = -1;
    private int[] stack;

    public Stack() {
        this(5);
    }

    public Stack(int size) {
        stack = new int[size];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public int capacity() {
        return this.stack.length;
    }

    @Override
    public int size() {
        return this.top + 1;
    }

    @Override
    public boolean isFull() {
        return top + 1 == this.stack.length;
    }

    @Override
    public int pop() {
        if (this.isEmpty()) {
            return -1;
        }
        top--;
        return stack[top + 1];
    }

    @Override
    public int top() {
        return this.top;
    }

    @Override
    public void push(int x) {
        if (x < 0) {
            System.out.println("ERROR - Number must be >= 0.");
        } else if (this.isFull()){
            System.out.println("ERROR - FULL");
        } else {
            this.top++;
            this.stack[this.top] = x;
        }
    }

    @Override
    public void makeEmpty() {
        top = -1;
    }

}

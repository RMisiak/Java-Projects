/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package part4;

/**
 *
 * @author 1misiakrya
 */
public class QueueTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Queue q = new Queue(10);

        // EMPTY
        assert (q.front() == -1);
        assert (q.back() == -1);
        assert (q.dequeue() == -1);
        assert (q.size() == 0);
        assert (q.capacity() == 10);
        assert (q.isEmpty());
        assert (!q.isFull());

        // ENQUEUE
        q.enqueue(5);
        assert (q.front() == 0);
        assert (q.back() == 0);
        assert (q.size() == 1);
        assert (q.capacity() == 10);
        assert (!q.isEmpty());
        assert (!q.isFull());

        // DEQUEUE WHEN SIZE == 1
        assert (q.dequeue() == 5);
        assert (q.front() == -1);
        assert (q.back() == -1);
        assert (q.size() == 0);
        assert (q.capacity() == 10);
        assert (q.isEmpty());
        assert (!q.isFull());

        q.enqueue(5);
        q.enqueue(9);
        q.enqueue(5);
        assert (q.front() == 0);
        assert (q.back() == 2);
        assert (q.size() == 3);
        assert (q.capacity() == 10);
        assert (!q.isEmpty());
        assert (!q.isFull());

        // DEQUEUE WHEN NOT EMPTY & SIZE != 1
        assert (q.dequeue() == 5);
        assert (q.front() == 1);
        assert (q.back() == 2);

    }

}

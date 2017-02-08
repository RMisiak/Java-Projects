/*
 */
package part4;

/**
 */
public class QueueTester1 {

    /**
     */
    public static void main(String[] args) {

        Queue q = new Queue(10);

        // EMPTY QUEUE
        assert (q.size() == 0);
        assert (q.isEmpty() == true);
        assert (q.isFull() == false);
        System.out.println("CASE 1: DEQUEUE EMPTY");
        assert (q.dequeue() == -1);

        // ENQUEUE; NO WRAP AROUND
        System.out.println("=== FILL QUEUE ===");
        for (int i = 0; i < q.capacity(); i++) {
            assert (q.isFull() == false);
            q.enqueue(i);
            assert (q.isEmpty() == false);
            assert (q.size() == i + 1);
            assert (q.front() == 0);
            assert (q.back() == i);
        }

        //  DEQUEUE; NO WRAP AROUND
        System.out.println("=== EMPTY QUEUE ===");
        int value;
        for (int i = 0; i < q.capacity(); i++) {
            assert (q.back() == q.capacity() - 1);
            assert (q.front() == i);
            value = q.dequeue();
            if (i != q.capacity() - 1) {
                assert (q.front() == i + 1);
            }
            assert( q.size() == q.capacity() - i - 1 );
        }

        // EMPTY QUEUE
        assert (q.front() == -1);
        assert (q.back() == -1);
        System.out.println("CASE 4: DEQUEUE EMPTY");
        assert (q.dequeue() == -1);
        assert (q.size() == 0);
        assert (q.isEmpty() == true);
        assert (q.isFull() == false);

        // ENQUEUE; FULL  
        System.out.println("=== FILL QUEUE ===");
        for (int i = 0; i < q.capacity(); i++) {
            assert (q.isFull() == false);
            q.enqueue(i);
            assert (q.isEmpty() == false);
            assert (q.size() == i + 1);
            assert (q.front() == 0);
            assert (q.back() == i);
        }

        System.out.println("=== EMPTY 1/2 QUEUE ===");
        //  DEQUEUE; HALF
        int half = q.capacity() / 2;
        for (int i = 0; i < half; i++) {
            assert (q.back() == q.capacity() - 1);
            assert (q.front() == i);
            value = q.dequeue();
            if (i != q.capacity() - 1) {
                assert (q.front() == i + 1);
            }
            assert( q.size() == q.capacity() - i - 1 );
        }

        // ENQUEUE; HALF to FILL
        System.out.println("=== ENQUEUE 1/2 WRAP AROUND ===");
        System.out.println(q.size());
        for (int i = half; i < q.capacity(); i++) {
            assert (q.isFull() == false);
            q.enqueue( half + i );
            assert( q.isEmpty() == false );
            assert( q.size() == (i + 1) );
        }
        
        // MAKE EMPTY
        assert( q.isFull() == true );
        q.makeEmpty();
        assert( q.size() == 0 );
        assert( q.isEmpty() == true );
        
    }

}

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
public class StackTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stack s = new Stack();

        // INITIAL VALUES
        assert (s.size() == 0);
        assert (s.isEmpty());
        assert (!s.isFull());
        assert (s.top() == -1);
        assert (s.capacity() == 5);

        // PUSHING VALUES
        s.push(5);
        assert (s.size() == 1);
        assert (!s.isEmpty());
        assert (!s.isFull());
        assert (s.top() == 0);
        assert (s.capacity() == 5);

        s.push(19);
        assert (s.size() == 2);
        assert (!s.isEmpty());
        assert (!s.isFull());
        assert (s.top() == 1);
        assert (s.capacity() == 5);

        //POP
        assert (s.pop() == 19);
        assert (s.size() == 1);
        assert (!s.isEmpty());
        assert (!s.isFull());
        assert (s.top() == 0);
        assert (s.capacity() == 5);

        s.push(19);
        s.push(19);
        s.push(19);
        s.push(19);
        assert (s.isFull());
    }

}

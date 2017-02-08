/*
 */
package part4;

/**
 */
public class StackTester1 {
   
    /**
     */
    public static void main( String[] args ) {

        Stack s = new Stack( 10 );

        // EMPTY STACK
        System.out.println( "CASE 1: TOP EMPTY" );
        assert ( s.top() == -1 );
        assert ( s.size() == 0 );
        assert ( s.isEmpty() == true );
        assert ( s.isFull() == false );
        assert ( s.pop() == -1 );

        // PUSH TILL FULL
        for ( int i = 0; i < s.capacity(); i++ ) {

            assert ( s.isFull() == false );
            s.push( i );
            assert ( s.isEmpty() == false );
            assert ( s.top() == i );
            assert ( s.size() == i + 1 );

        }

        // PUSH FULL
        System.out.println( "CASE 2: PUSH FULL" );
        s.push( 99 );

        // FULL!
        assert ( s.isFull() == true );

        // POP TILL EMPTY
        int value;
        for ( int i = s.capacity() - 1; i >= 0; i-- ) {

            assert ( s.top() == i );
            value = s.pop();
            assert ( value == i );
            if ( i != 0 ) {
                assert ( s.top() == i - 1 );
            }

        }

        // EMPTY STACK
        System.out.println( "CASE 3: TOP EMPTY" );
        assert ( s.top() == -1 );
        System.out.println( "CASE 4: POP EMPTY" );
        assert ( s.pop() == -1 );
        assert ( s.size() == 0 );
        assert ( s.isEmpty() == true );
        assert ( s.isFull() == false );

        // FILL, to MAKE EMPTY
        for ( int i = 0; i < s.capacity(); i++ ) {
            s.push( (int) ( Math.random() * 100 ) + 1 );
        }

        // MAKE EMPTY
        assert ( s.isFull() == true );
        s.makeEmpty();
        assert ( s.isEmpty() == true );
        assert ( s.size() == 0 );

    }

}

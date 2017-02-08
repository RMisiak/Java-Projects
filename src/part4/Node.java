package part4;

/**
 * Lesson: 6.03 - a Node
 */
public class Node implements NodeInterface {

    private String data;
    private Node next;

    public Node( String newData ) {
        this.data = newData;
        this.next = null;
    }

    @Override
    public Node getNext() {
        return this.next;
    }

    @Override
    public void setNext( Node nextNode ) {
        this.next = nextNode;
    }

    @Override
    public String getData() {
        return this.data;
    }     

}

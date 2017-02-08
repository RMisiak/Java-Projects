package part4;

/**
 * Lesson: 6.02 - Queue
 */
public interface LinkListInterface {
    
    public int size();
    
    public void makeEmpty();
    
    public boolean isEmpty();

    public void addAtFront(String str);

    public void addAtEnd(String str);
    
    public void remove(String str);

    public String removeFromEnd();
    
    public String removeFromFront();

    public String head();
    
    public String tail();
    
    public String toString();

}

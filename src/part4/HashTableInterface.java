package part4;

/**
 * Lesson: 6.02 - Queue
 */
public interface HashTableInterface {
    
    public int size();
    
    public int capacity();
    
    public double loadFactor();
    
    public void makeEmpty();
    
    public boolean isEmpty();

    public void resize();

    public Student get(int key);
    
    public Student remove(int key);

    public void put(int key, Student value);
    
    public boolean contains(Student student);

    public boolean containsKey(int key);
    
    public int hash(int key);

}

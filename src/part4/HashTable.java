/*
 * Name: HashTable
 * Date: May 3, 2016
 * Version: v0.1
 * Author: Mr. R. Misiak
 * Description: Creates a HashTable object.
 */
package part4;

/**
 *
 * @author 1misiakrya
 */
public class HashTable implements HashTableInterface {

    private static final int FILLED = 1;
    private static final int EMPTY = 0;
    private static final int DELETED = -1;

    // PUBLIC ONLY FOR TESTING
    public Student[] hashTable;
    private int[] data;

    public HashTable() {
        this(50);
    }

    public HashTable(int capacity) {
        this.hashTable = new Student[HashTable.nextPrime(capacity)];
        this.data = new int[hashTable.length];
    }

    @Override
    public int size() {
        // LOOP THROUGH ARRAY, count non-NULL items
        // TODO: deleted items???
        int numFilled = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == FILLED) {
                numFilled++;
            }
        }
        return numFilled;
    }

    @Override
    public int capacity() {
        return hashTable.length;
    }

    @Override
    public double loadFactor() {
        return (double) this.size() / this.capacity();
    }

    @Override
    public void makeEmpty() {
        this.hashTable = new Student[this.capacity()];
        this.data = new int[this.capacity()];
    }

    @Override
    public boolean isEmpty() {
        // LOOP THROUGH to find 1 that is not null
        for (Student hashTable1 : hashTable) {
            if (hashTable1 != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void resize() {
        if (this.loadFactor() >= 0.75) {
            Student[] oldHash = this.hashTable;
            int[] oldData = this.data;

            this.hashTable = new Student[this.nextPrime(this.size() * 4)];
            this.data = new int[this.hashTable.length];

            for (int i = 0; i < oldData.length; i++) {
                if (oldData[i] == FILLED) {
                    this.put(oldHash[i].getKey(), oldHash[i]);
                }
            }
            // CREATE SECOND TABLE, call put to fill it.
            // IF list loadfactor > 75%, resize it so that it is now full to 25%
        }
    }

    @Override
    public Student get(int key) {
        boolean found = false;
        int i = hash(key);
        while (!found) {
            if (this.data[i] == EMPTY) {
                found = true;
            } else if (this.data[i] == FILLED && this.hashTable[i].getKey() == key) {
                return this.hashTable[i];
            } else {
                i++;
                i = i % this.capacity();
            }
        }
        return null;
    }

    @Override
    public Student remove(int key) {
        Student s = null;
        int i = hash(key);
        boolean removed = false;
        while (!removed) {
            if (hashTable[i].getStudentID() == key && data[i] == FILLED) {
                s = this.hashTable[i];
                this.hashTable[i] = null;
                this.data[i] = DELETED;
                return s;
            } else if (this.data[i] == EMPTY) {
                removed = true;
            } else {
                i++;
                i = i % capacity();
            }
        }
        return s;
    }

    @Override
    public void put(int key, Student value) {
        boolean placed = false;
        int i = hash(key);
        while (!placed) {
            if (this.data[i] != FILLED) {
                this.hashTable[i] = value;
                this.data[i] = FILLED;
                placed = true;
            } else {
                i++;
                i = i % this.capacity();
            }
        }
        resize();
    }

    @Override
    public boolean contains(Student student) {
        boolean studentFound = false;
        int i = hash(student.getKey());
        while (!studentFound) {
            if (this.data[i] == EMPTY) {
                studentFound = true;
            } else if (this.data[i] == FILLED && this.hashTable[i].equals(student)) {
                return true;
            } else {
                i++;
                i = i % this.capacity();
            }

        }
        return false;
    }

    @Override
    public boolean containsKey(int key) {
        boolean keyFound = false;
        int i = hash(key);
        while (!keyFound) {
            if (this.data[i] == EMPTY) {
                keyFound = true;
            } else if (this.data[i] == FILLED && this.hashTable[i].getKey() == key) {
                return true;
            } else {
                i++;
                i = i % this.capacity();
            }
        }
        return false;
    }

    @Override
    public int hash(int key) {
        return key % capacity();
    }

    public static int nextPrime(int x) {
        boolean primeFound = false;
        while (!primeFound) {
            x++;
            primeFound = true;
            for (int i = 2; i < x; i++) {
                if (x % i == 0) {
                    i = x;
                    primeFound = false;
                }
            }
        }
        return x;
    }
}

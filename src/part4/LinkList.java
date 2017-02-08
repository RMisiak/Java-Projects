/*
 * Name: LinkedList
 * Date: May 3, 2016
 * Version: v0.1
 * Author: Mr. R. Misiak
 * Description: Creates a LinkList object.
 */
package part4;

/**
 *
 * @author 1misiakrya
 */
public class LinkList implements LinkListInterface {

    private Node head;
    private Node tail;

    public LinkList() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public int size() {
        return size(this.head);
    }

    public int size(Node n) {
        if (n == null) {
            return 0;
        } else {
            return 1 + size(n.getNext());
        }
    }

    @Override
    public void makeEmpty() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null && this.tail == null;
    }

    /**
     * Adds a node to the front of the linked list .
     *
     * @param str
     */
    @Override
    public void addAtFront(String str) {
        Node newNode = new Node(str);
        if (isEmpty()) {
            this.tail = newNode;
        } else {
            newNode.setNext(this.head);
        }
        this.head = newNode;
    }

    /**
     * Adds a node to the end of the linked list.
     *
     * @param str
     */
    @Override
    public void addAtEnd(String str) {
        Node newNode = new Node(str);
        if (isEmpty()) {
            this.head = newNode;
        } else {
            this.tail.setNext(newNode);
        }
        this.tail = newNode;

//        Node n = this.head;
//        if (str == null) {
//            System.out.println("Invalid Data");
//        } else {
//            if (this.isEmpty()) {
//                this.tail = n;
//                this.head = n;
//            } else {
//                this.tail.setNext(n);
//                this.tail = n;
//            }
//        }
    }

    /**
     * Deletes a node in the linked list.
     *
     * @param str
     */
    @Override
    public void remove(String str) {
        if (this.isEmpty()) {
            System.out.println("ERROR - Hash Table is EMPTY!");
        } else {
            if (this.size() == 1) {
                if (this.head.getData().equals(str)) {
                    this.makeEmpty();
                }
            } else if (this.head.getData().equals(str)) {
                this.head = this.head.getNext();
            } else if (this.tail.getData().equals(str)) {
                Node m = this.head;
                Node n = m;
                for (int i = 0; i < this.size() - 1; i++) {
                    n = m;
                    m = n.getNext();
                }
                n.setNext(null);
                this.tail = m;
            } else {
                Node m = this.head;
                Node o;
                for (int i = 0; i < this.size() - 1; i++) {
                    o = m;
                    m = o.getNext();
                    if (m.getData().equals(str)) {
                        if (m.getNext() != null) {
                            o.setNext(m.getNext());
                        }
                    }
                }
            }
        }
    }

    @Override
    public String removeFromEnd() {
        if (this.tail.getNext().getNext() == null) {
            this.tail.setNext(null);
        } else {
            this.remove(this.tail.getNext().getData());
        }
        return this.tail.getNext().getData();
    }

    @Override
    public String removeFromFront() {
        this.remove(this.head.getData());
        return this.tail.getNext().getData();
    }

    @Override
    public String head() {
        return head.toString();
    }

    @Override
    public String tail() {
        return tail.toString();
    }

    @Override
    public String toString() {
        return "LinkList{" + "head=" + head + ", tail=" + tail + ", size=" + this.size() +'}';
    }

    /**
     * Creates a string that lists the nodes of the linked list.
     *
     * @return string
     */
}

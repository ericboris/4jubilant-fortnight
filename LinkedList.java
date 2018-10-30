// Class LinkedList<E> can be used to store a list of values of type E.

import java.util.*;
import java.io.Serializable;
import java.lang.Math;

/**
 * A generic linked list
 * 
 * @author Reges and Stepp updated by Eric Boris
 * @version 10/27/18
 */
public class LinkedList<E> implements Serializable {
    /** front       first value in the list */
    private ListNode<E> front;  // first value in the list
    /** back        last value in the list */
    private ListNode<E> back;   // last value in the list
    /** size        current number of elements */
    private int size;           // current number of elements

    // post: constructs an empty list
    /** 
     * create a list
     */
    public LinkedList() {
        front = new ListNode<E>(null);
        back = new ListNode<E>(null);
        clear();
    }

    // post: returns the current number of elements in the list
    /**
     * return the size of the list
     * 
     * @return              the size of the list
     */
    public int size() {
        return size;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: returns the value at the given index in the list
    /**
     * return the value at the given index in the list
     * 
     * @param   index       the index of the list
     * @return              the value at the index
     */
    public E get(int index) {
        checkIndex(index);
        ListNode<E> current = nodeAt(index);
        return current.data;
    }

    // post: creates a comma-separated, bracketed version of the list
    /**
     * creates a comma-separated, bracked version of the list
     * 
     * @return              a string version of the list
     */
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            String result = "[" + front.next.data;
            ListNode<E> current = front.next.next;
            while (current != back) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }

    // post : returns the position of the first occurrence of the given
    //        value (-1 if not found)
    /**
     * return the position of the first occurrence of the given value
     * 
     * @param   value       the value to look for
     * @return              the first position of the value
     */
    public int indexOf(E value) {
        int index = 0;
        ListNode<E> current = front.next;
        while (current !=  back) {
            if (current.data.equals(value)) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    // post: returns true if list is empty, false otherwise
    /**
     * returns if the list is empty or not
     * 
     * @return              true if list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    // post: returns true if the given value is contained in the list,
    //       false otherwise
    /**
     * returns if list contains given value
     * 
     * @param   value       the value to check for
     * @return              true if value is in list, false otherwise
     */
    public boolean contains(E value) {
        return indexOf(value) >= 0;
    }

    // post: appends the given value to the end of the list
    /**
     * append the given value to the end of the list
     * 
     * @param   value       the value to append
     */
    public void add(E value) {
        add(size, value);
    }

    // pre: 0 <= index <= size() (throws IndexOutOfBoundsException if not)
    // post: inserts the given value at the given index, shifting subsequent
    //       values right
    /**
     * add a new value at the given index
     * 
     * @param   index       the position to add the value
     * @param   value       the value to add
     */
    public void add(int index, E value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        ListNode<E> current = nodeAt(index - 1);
        ListNode<E> newNode = new ListNode<E>(value, current.next, current);
        current.next = newNode;
        newNode.next.prev = newNode;
        size++;
    }

    // post: appends all values in the given list to the end of this list
    /**
     * append a list onto this list
     * 
     * @param   other       the list to add to this list
     */
    public void addAll(List<E> other) {
        for (E value: other) {
            add(value);
        }
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: removes value at the given index, shifting subsequent values left
    /**
     * remove the value at the given index
     * 
     * @param   index       the index to remove
     */
    public void remove(int index) {
        checkIndex(index);
        ListNode<E> current = nodeAt(index - 1);
        current.next = current.next.next;
        current.next.prev = current;
        size--;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: replaces the value at the given index with the given value
    /**
     * replace the value at the given index with the given value
     * 
     * @param   index       the position to replace
     * @param   value       the value to replace at index
     */
    public void set(int index, E value) {
        checkIndex(index);
        ListNode<E> current = nodeAt(index);
        current.data = value;
    }

    /**
     * move the value at the given index in the direction and amount specified
     * 
     * @param   index       the the index value to move
     * @param   direction   the direction (+ or -) and amount to move
     */
    public void move(int index, int direction) {
        // check that the current index and the index of placement are valid
        checkIndex(index);
        checkIndex(index + direction);
        
        // store the current node's data
        E nodeData = get(index);
        
        // delete the node's current location and replace it at the desired
        // location direction units away from the current index.
        remove(index);
        add(index + direction, nodeData);
    }
    
    // post: list is empty
    /**
     * clear the list
     */
    public void clear() {
        front.next = back;
        back.prev = front;
        size = 0;
    }

    // post: returns an iterator for this list
    // public Iterator<E> iterator() {
        // return new LinkedIterator();
    // }

    // pre : 0 <= index < size()
    // post: returns the node at a specific index.  Uses the fact that the list
    //       is doubly-linked to start from the front or the back, whichever
    //       is closer.
    /**
     * get the node a the given index
     * 
     * @param   index       the index of the node to return
     * @return              the node at index
     */
    private ListNode<E> nodeAt(int index) {
        ListNode<E> current;
        if (index < size / 2) {
            current = front;
            for (int i = 0; i < index + 1; i++) {
                current = current.next;
            }
        } else {
            current = back;
            for (int i = size; i >= index + 1; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    // post: throws an IndexOutOfBoundsException if the given index is
    //       not a legal index of the current list
    /**
     * ensure provided index is valid
     * 
     * @param   index       the index to check
     * @return              nothing if return is invalid, true otherwise
     */
    private boolean checkIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        return true;
    }

    /**
     * a node of the linked list
     */
    private static class ListNode<E> implements Serializable {
        /** data        data stored in this node */
        public E data;         // data stored in this node
        /** next        link to next node in the list */
        public ListNode<E> next;  // link to next node in the list
        /** prev        link to the previous node in the list */
        public ListNode<E> prev;  // link to previous node in the list

        // post: constructs a node with given data and null links
        /**
         * create a new node with given data
         * 
         * @param   data        the data in the node
         */
        public ListNode(E data) {
            this(data, null, null);
        }

        // post: constructs a node with given data and given links
        /**
         * create a node with given data and and a particular location in list
         * 
         * @param   data        the data in the node
         * @param   next        the element after this new node
         * @param   prev        the element before this new node
         */
        public ListNode(E data, ListNode<E> next, ListNode<E> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    // private class LinkedIterator implements Iterator<E> {
        // private ListNode<E> current;  // location of next value to return
        // private boolean removeOK;  // whether it's okay to remove now

        // // post: constructs an iterator for the given list
        // public LinkedIterator() {
            // current = front.next;
            // removeOK = false;
        // }

        // // post: returns true if there are more elements left, false otherwise
        // public boolean hasNext() {
            // return current != back;
        // }

        // // pre : hasNext()
        // // post: returns the next element in the iteration
        // public E next() {
            // if (!hasNext()) {
                // throw new NoSuchElementException();
            // }
            // E result = current.data;
            // current = current.next;
            // removeOK = true;
            // return result;
        // }

        // // pre : next() has been called without a call on remove (i.e., at most
        // //       one call per call on next)
        // // post: removes the last element returned by the iterator
        // public void remove() {
            // if (!removeOK) {
                // throw new IllegalStateException();
            // }
            // ListNode<E> prev2 = current.prev.prev;
            // prev2.next = current;
            // current.prev = prev2;
            // size--;
            // removeOK = false;
        // }
    // }
}

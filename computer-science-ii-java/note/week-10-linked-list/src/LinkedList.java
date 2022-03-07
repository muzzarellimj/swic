package semester_two.week_eleven;

/**
 * For an array...
 *
 * To add an element k to an array of N elements...
 *      - loop through the array to find the destination index.
 *      - reallocate memory for N+1 elements.
 *      - as we are searching for the correct index, copy the smaller values into the new array.
 *      - insert value k.
 *      - copy the rest of the larger values into the new array.
 *
 * To remove an element k from an array of N elements...
 *      - reallocate memory for N-1 elements.
 *      - copy the first k-1 items.
 *      - skip the value at the index we want to remove.
 *      - copy the remaining N-k items.
 *
 * For a linked list... a "node" points to the next element in the list. A major disadvantage of linked lists is
 * access: to access the thousandth element of a linked list, we must trace through all the elements that come before
 * it. A major advantage of linked lists is modification: adding or removing data is much simpler than in an array.
 *
 * Question: what if k is less than all the elements in the list? We would have to create a node with next = head and
 * reassign the value of the head via head = address of node k.
 *
 * Question: what if K (different from k) is larger than all of the elements in the list? We would have to create a
 * node with head = K and insert it at the end of the list, then erase the null pointer in the previous node and
 * point it to node K.
 *
 * Question: what if a node with value M should be inserted in the middle of the list? We would have to keep track of
 * the current node, point it to the value of the node just greater than M, set M node.next = current.next, and set
 * current.next = M node.
 *
 * The examples above are referred to as a singly-linked list because there is a single link between each node. There
 * also exists a doubly-linked list, which is purposed to go forward and backward in a list. In a doubly-linked list,
 * there is a head with data and a next and previous pointer. There also exists a circular-linked list wherein the
 * end points to the head, which is purposed to cycle through all of the elements multiple times.
 *
 * @author Michael Muzzarelli
 */
public class LinkedList {

    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public int length() {
        Node temp = head;
        int count = 0;

        if (head != null) {
            do {
                count++;
                temp = temp.getNext();
            } while (temp != null);
        }

        return count;
    }

    public void print() {
        Node temp = head;
        System.out.print("{");
        if(head != null)
            do {
                System.out.print(temp.getData() + " ");
                temp = temp.getNext();
            } while(temp != null);
        System.out.println("\b}");
    }

    public void add(int k) {
        Node toAdd = new Node(k);

        // check if the list is empty
        if (head == null) {
            head = toAdd;

        // check if needs to be added to the head of the list
        } else if (head.getData() >= k) {
            toAdd.setNext(head);
            head = toAdd;

        // find where in the list the node should be inserted
        } else {
            Node temp = head;

            while (temp.getNext() != null && temp.getNext().getData() < k) {
                temp = temp.getNext();
            }

            if (temp.getNext() != null) {
                toAdd.setNext(temp.getNext());
            }

            temp.setNext(toAdd);
        }
    }

    public int get(int index) throws IllegalArgumentException {
        if (index < 0) {
            throw new IllegalArgumentException("Index must be positive.");
        }

        Node temp = head;
        int count = 0;

        if (head != null) {
            while (temp != null && count != index) {
                count++;
                temp = temp.getNext();
            }
        }

        if (temp != null) {
            return temp.getData();

        } else {
            throw new IllegalArgumentException("Index exceeds list length.");
        }
    }

    public int find(int data) {
        int index = 0;
        Node temp = head;
        while(temp != null) {
            if(temp.getData() == data)
                return index;
            else {
                index++;
                temp = temp.next;
            }
        }
        return -1;
    }

    public int findMin() throws NullPointerException {
        if(head == null)
            throw new NullPointerException("List is empty.");
        return head.getData();
    }

    public int findMax() throws NullPointerException {
        if(head == null)
            throw new NullPointerException("List is empty.");
        Node temp = head;
        while(temp.next != null)
            temp = temp.next;
        return temp.getData();
    }

    public void remove(int data) {
        while(find(data) > -1) {
            removeIndex(find(data));
        }
    }

    public void removeIndex(int i) {
        Node temp = head, toDelete = null;
        if(i >= 0 && i < length()) {
            for(int j=0; j<i-1; j++)
                temp = temp.next;
            toDelete = temp.next;
            temp.next = toDelete.next;
            toDelete.next = null;
        }
    }

    private class Node {

        private int data;

        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public int getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
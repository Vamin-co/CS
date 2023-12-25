/*
 * Vandan Amin
 * Oct 18 2023
 * Data Structures Lab4
 * DoublyLinkedList.java
 */

class Node<T> {
    T data;
    Node<T> prev;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int length;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    // Insert a new node at the front of the list
    public void insertAtFront(T data) {
        Node<T> newNode = new Node<>(data);
        length++; 
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Insert a new node at the end of the list
    public void insertAtEnd(T data) {
        Node<T> newNode = new Node<>(data);
        length++;
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }

    }

    // Insert a new node at the specified index
    public void insertAtIndex(int index, T data) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index == 0) {
            insertAtFront(data);
        } else if (index == length) {
            insertAtEnd(data);
        } else {
            Node<T> newNode = new Node<>(data);
            Node<T> current = getNodeAtIndex(index - 1);

            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;

            length++;
        }
    }

    // Remove a node at the specified index
    public void removeByIndex(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        } else if (index == length - 1) {
            tail = tail.prev;
            tail.next = null;
        } else {
            Node<T> current = getNodeAtIndex(index);
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        length--;
    }

    // Remove the first occurrence of a node with the given key
    public void removeByKey(T key) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(key)) {
                if (current.prev == null) {
                    head = current.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else {
                    current.prev.next = current.next;
                    if (current.next != null) {
                        current.next.prev = current.prev;
                    }
                }

                length--;
                return;
            }
            current = current.next;
        }
    }

    // Check if the list contains a node with the given key
    public int contains(T key) {
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(key)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    // Update the data at the specified index
    public void set(int index, T data) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node<T> current = getNodeAtIndex(index);
        current.data = data;
    }

    // Get the data at the specified index
    public T get(int index) {
        if (index < 0 || index >= length) {
            return null;
        }

        Node<T> current = getNodeAtIndex(index);
        return current.data;
    }

    // Get the length of the list
    public int size() {
        return length;
    }

    // Print the data in the list
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            result.append(current.data);
            if (current.next != null) {
                result.append(", ");
            }
            current = current.next;
        }
        result.append("]");
        return result.toString();
    }

    private Node<T> getNodeAtIndex(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
}


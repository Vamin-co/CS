/*
 * Vandan Amin
 * Oct 18 2023
 * Data Structures Lab4
 * Driver.java
 */

public class Driver {
    public static void main(String[] args) {
        // Test the DoublyLinkedList with Integer values
        DoublyLinkedList<Integer> intList = new DoublyLinkedList<>();
        intList.insertAtFront(1);
        intList.insertAtEnd(3);
        intList.insertAtIndex(1, 2);
        System.out.println("Integer List: " + intList.toString());

        intList.set(1, 4);
        intList.removeByIndex(2);
        intList.removeByKey(1);
        System.out.println("Size: " + intList.size());
        System.out.println("Contains 4: " + intList.contains(4));
        System.out.println("Element at index 0: " + intList.get(0));
        System.out.println("Integer List after operations: " + intList.toString());

        // Test the DoublyLinkedList with String objects
        DoublyLinkedList<String> strList = new DoublyLinkedList<>();
        strList.insertAtFront("apple");
        strList.insertAtEnd("banana");
        strList.insertAtIndex(1, "orange");
        System.out.println("String List: " + strList.toString());

        strList.set(1, "grape");
        strList.removeByIndex(2);
        strList.removeByKey("apple");
        System.out.println("Size: " + strList.size());
        System.out.println("Contains grape: " + strList.contains("grape"));
        System.out.println("Element at index 0: " + strList.get(0));
        System.out.println("String List after operations: " + strList.toString());
    }
}

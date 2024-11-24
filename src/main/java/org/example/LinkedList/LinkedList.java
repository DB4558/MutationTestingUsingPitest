package org.example.LinkedList;

public class LinkedList {

    // Node class to represent the elements of the linked list
    public static class Node {
        public int data;   // Data stored in the node
        public Node next;  // Pointer to the next node in the list

        // Constructor to initialize the node
        public Node(int new_data) {
            data = new_data;
            next = null;
        }
    }

    // Function to insert a new node at the beginning of the list
    public static Node insertAtFront(Node head, int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        return new_node;
    }

    // Function to append a new node at the end of the list
    public static Node append(Node head, int newData) {
        Node newNode = new Node(newData);

        if (head == null) {
            return newNode;
        }

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        last.next = newNode;
        return head;
    }

    // Function to delete the head node and return the new head
    public static Node deleteHead(Node head) {
        if (head == null)
            return null;

        Node temp = head;
        head = head.next;
        temp = null;

        return head;
    }

    // Function to remove the last node
    public static Node removeLastNode(Node head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return null;
        }

        Node secondLast = head;
        while (secondLast.next.next != null) {
            secondLast = secondLast.next;
        }

        secondLast.next = null;
        return head;
    }

    // Function to insert a Node at a specific position
    public static Node insertPos(Node head, int pos, int data) {
        if (pos < 1) return head;

        if (pos == 1) {
            Node newNode = new Node(data);
            newNode.next = head;
            return newNode;
        }

        Node curr = head;
        for (int i = 1; i < pos - 1 && curr != null; i++) {
            curr = curr.next;
        }

        if (curr == null) return head;

        Node newNode = new Node(data);
        newNode.next = curr.next;
        curr.next = newNode;

        return head;
    }

    // Function to delete a node at a given position
    public static Node deleteNode(Node head, int position) {
        Node temp = head;
        Node prev = null;

        if (temp == null)
            return head;

        if (position == 1) {
            head = temp.next;
            return head;
        }

        for (int i = 1; temp != null && i < position; i++) {
            prev = temp;
            temp = temp.next;
        }

        if (temp != null) {
            prev.next = temp.next;
        } else {
            System.out.println("Data not present");
        }

        return head;
    }

    // Function to reverse the linked list
    public static Node reverseList(Node head) {
        Node curr = head, prev = null, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Function to count the number of nodes in the linked list
    public static int countNodes(Node head) {
        int count = 0;
        Node curr = head;

        while (curr != null) {
            count++;
            curr = curr.next;
        }

        return count;
    }

    // Function to rotate the linked list left by k nodes
    public static Node rotate(Node head, int k) {
        if (k == 0 || head == null) return head;

        for (int i = 0; i < k; i++) {
            Node curr = head;
            while (curr.next != null)
                curr = curr.next;

            curr.next = head;
            curr = curr.next;
            head = head.next;
            curr.next = null;
        }
        return head;
    }

    // Function to segregate even and odd nodes and return the new head
    public static Node segregateEvenOdd(Node head) {
        Node resStart = null, resEnd = null;
        Node curr = head, prev = null;

        while (curr != null) {
            if (curr.data % 2 == 0) {
                if (prev != null) {
                    prev.next = curr.next;
                } else {
                    head = curr.next;
                }

                if (resStart == null) {
                    resStart = curr;
                    resEnd = resStart;
                } else {
                    resEnd.next = curr;
                    resEnd = resEnd.next;
                }

                curr = curr.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        if (resStart == null) return head;

        resEnd.next = head;
        return resStart;
    }
}

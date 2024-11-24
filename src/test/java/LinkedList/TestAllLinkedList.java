package LinkedList;
import org.example.LinkedList.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestAllLinkedList {

    @Test
    void testInsertAtFront1() {
        // Test: Insert into an empty list
        LinkedList.Node head = null;
        head = LinkedList.insertAtFront(head, 10);
        assertArrayEquals(new int[]{10}, toArray(head));
    }

    @Test
    void testInsertAtFront2() {
        // Test: Insert into a single-node list
        LinkedList.Node head = null;
        head = LinkedList.insertAtFront(head, 10);
        head = LinkedList.insertAtFront(head, 20);
        assertArrayEquals(new int[]{20, 10}, toArray(head));
    }

    @Test
    void testInsertAtFront3() {
        // Test: Insert multiple nodes
        LinkedList.Node head = null;
        head = LinkedList.insertAtFront(head, 10);
        head = LinkedList.insertAtFront(head, 20);
        head = LinkedList.insertAtFront(head, 30);
        assertArrayEquals(new int[]{30, 20, 10}, toArray(head));
    }

    @Test
    void testInsertAtFront4() {
        // Test: Insert negative numbers
        LinkedList.Node head = null;
        head = LinkedList.insertAtFront(head, -5);
        head = LinkedList.insertAtFront(head, 10);
        assertArrayEquals(new int[]{10, -5}, toArray(head));
    }

    @Test
    void testInsertAtFront5() {
        // Test: Insert zero
        LinkedList.Node head = null;
        head = LinkedList.insertAtFront(head, 0);
        assertArrayEquals(new int[]{0}, toArray(head));
    }

    private int[] toArray(LinkedList.Node head) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        while (head != null) {
            result.add(head.data);
            head = head.next;
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    @Test
    void testAppend1() {
        // Test: Append to an empty list
        LinkedList.Node head = null;
        head = LinkedList.append(head, 10);
        assertArrayEquals(new int[]{10}, toArray(head));
    }

    @Test
    void testAppend2() {
        // Test: Append to a single-node list
        LinkedList.Node head = LinkedList.append(null, 10);
        head = LinkedList.append(head, 20);
        assertArrayEquals(new int[]{10, 20}, toArray(head));
    }

    @Test
    void testAppend3() {
        // Test: Append multiple nodes
        LinkedList.Node head = null;
        head = LinkedList.append(head, 10);
        head = LinkedList.append(head, 20);
        head = LinkedList.append(head, 30);
        assertArrayEquals(new int[]{10, 20, 30}, toArray(head));
    }

    @Test
    void testAppend4() {
        // Test: Append a negative number
        LinkedList.Node head = LinkedList.append(null, 10);
        head = LinkedList.append(head, -5);
        assertArrayEquals(new int[]{10, -5}, toArray(head));
    }

    @Test
    void testAppend5() {
        // Test: Append zero
        LinkedList.Node head = LinkedList.append(null, 0);
        assertArrayEquals(new int[]{0}, toArray(head));
    }

    @Test
    void testDeleteHead1() {
        // Test: Delete head from a multi-node list
        LinkedList.Node head = createList(new int[]{10, 20, 30});
        head = LinkedList.deleteHead(head);
        assertArrayEquals(new int[]{20, 30}, toArray(head));
    }

    @Test
    void testDeleteHead2() {
        // Test: Delete head from a single-node list
        LinkedList.Node head = createList(new int[]{10});
        head = LinkedList.deleteHead(head);
        assertArrayEquals(new int[]{}, toArray(head));
    }

    @Test
    void testDeleteHead3() {
        // Test: Delete head from an empty list
        LinkedList.Node head = null;
        head = LinkedList.deleteHead(head);
        assertArrayEquals(new int[]{}, toArray(head));
    }

    @Test
    void testDeleteHead4() {
        // Test: Delete head repeatedly
        LinkedList.Node head = createList(new int[]{10, 20, 30});
        head = LinkedList.deleteHead(head); // 20 -> 30
        head = LinkedList.deleteHead(head); // 30
        head = LinkedList.deleteHead(head); // null
        assertArrayEquals(new int[]{}, toArray(head));
    }

    @Test
    void testDeleteHead5() {
        // Test: Delete head after appending
        LinkedList.Node head = createList(new int[]{10, 20});
        head = LinkedList.append(head, 30);
        head = LinkedList.deleteHead(head); // 20 -> 30
        assertArrayEquals(new int[]{20, 30}, toArray(head));
    }

    private LinkedList.Node createList(int[] data) {
        LinkedList.Node head = null;
        for (int i = data.length - 1; i >= 0; i--) {
            head = LinkedList.insertAtFront(head, data[i]);
        }
        return head;
    }
    @Test
    void testRemoveLastNode1() {
        // Test: Remove last node from a multi-node list
        LinkedList.Node head = createList(new int[]{10, 20, 30});
        head = LinkedList.removeLastNode(head);
        assertArrayEquals(new int[]{10, 20}, toArray(head));
    }

    @Test
    void testRemoveLastNode2() {
        // Test: Remove last node from a single-node list
        LinkedList.Node head = createList(new int[]{10});
        head = LinkedList.removeLastNode(head);
        assertArrayEquals(new int[]{}, toArray(head));
    }

    @Test
    void testRemoveLastNode3() {
        // Test: Remove last node from an empty list
        LinkedList.Node head = null;
        head = LinkedList.removeLastNode(head);
        assertArrayEquals(new int[]{}, toArray(head));
    }

    @Test
    void testRemoveLastNode4() {
        // Test: Remove last node repeatedly
        LinkedList.Node head = createList(new int[]{10, 20, 30});
        head = LinkedList.removeLastNode(head); // 10 -> 20
        head = LinkedList.removeLastNode(head); // 10
        head = LinkedList.removeLastNode(head); // null
        assertArrayEquals(new int[]{}, toArray(head));
    }

    @Test
    void testRemoveLastNode5() {
        // Test: Remove last node from a list with negative values
        LinkedList.Node head = createList(new int[]{-5, -10, -15});
        head = LinkedList.removeLastNode(head);
        assertArrayEquals(new int[]{-5, -10}, toArray(head));
    }

    @Test
    void testReverseList1() {
        // Test: Reverse a multi-node list
        LinkedList.Node head = createList(new int[]{10, 20, 30});
        head = LinkedList.reverseList(head);
        assertArrayEquals(new int[]{30, 20, 10}, toArray(head));
    }

    @Test
    void testReverseList2() {
        // Test: Reverse a single-node list
        LinkedList.Node head = createList(new int[]{10});
        head = LinkedList.reverseList(head);
        assertArrayEquals(new int[]{10}, toArray(head));
    }

    @Test
    void testReverseList3() {
        // Test: Reverse an empty list
        LinkedList.Node head = null;
        head = LinkedList.reverseList(head);
        assertArrayEquals(new int[]{}, toArray(head));
    }

    @Test
    void testReverseList4() {
        // Test: Reverse a list with negative numbers
        LinkedList.Node head = createList(new int[]{-10, -20, -30});
        head = LinkedList.reverseList(head);
        assertArrayEquals(new int[]{-30, -20, -10}, toArray(head));
    }

    @Test
    void testReverseList5() {
        // Test: Reverse a list with duplicate values
        LinkedList.Node head = createList(new int[]{10, 20, 20, 30});
        head = LinkedList.reverseList(head);
        assertArrayEquals(new int[]{30, 20, 20, 10}, toArray(head));
    }

    @Test
    void testCountNodes1() {
        // Test: Count nodes in a multi-node list
        LinkedList.Node head = createList(new int[]{10, 20, 30});
        int count = LinkedList.countNodes(head);
        assertEquals(3, count);
    }

    @Test
    void testCountNodes2() {
        // Test: Count nodes in a single-node list
        LinkedList.Node head = createList(new int[]{10});
        int count = LinkedList.countNodes(head);
        assertEquals(1, count);
    }

    @Test
    void testCountNodes3() {
        // Test: Count nodes in an empty list
        LinkedList.Node head = null;
        int count = LinkedList.countNodes(head);
        assertEquals(0, count);
    }

    @Test
    void testCountNodes4() {
        // Test: Count nodes in a list with negative numbers
        LinkedList.Node head = createList(new int[]{-10, -20, -30});
        int count = LinkedList.countNodes(head);
        assertEquals(3, count);
    }

    @Test
    void testCountNodes5() {
        // Test: Count nodes in a list with duplicate values
        LinkedList.Node head = createList(new int[]{10, 10, 20, 30});
        int count = LinkedList.countNodes(head);
        assertEquals(4, count);
    }

    @Test
    void testSegregateEvenOdd1() {
        // Test: List with mixed even and odd numbers
        LinkedList.Node head = createList(new int[]{10, 15, 20, 25});
        head = LinkedList.segregateEvenOdd(head);
        assertArrayEquals(new int[]{10, 20, 15, 25}, toArray(head));
    }

    @Test
    void testSegregateEvenOdd2() {
        // Test: List with only even numbers
        LinkedList.Node head = createList(new int[]{2, 4, 6, 8});
        head = LinkedList.segregateEvenOdd(head);
        assertArrayEquals(new int[]{2, 4, 6, 8}, toArray(head));
    }

    @Test
    void testSegregateEvenOdd3() {
        // Test: List with only odd numbers
        LinkedList.Node head = createList(new int[]{1, 3, 5, 7});
        head = LinkedList.segregateEvenOdd(head);
        assertArrayEquals(new int[]{1, 3, 5, 7}, toArray(head));
    }

    @Test
    void testSegregateEvenOdd4() {
        // Test: List with alternating even and odd numbers
        LinkedList.Node head = createList(new int[]{1, 2, 3, 4, 5, 6});
        head = LinkedList.segregateEvenOdd(head);
        assertArrayEquals(new int[]{2, 4, 6, 1, 3, 5}, toArray(head));
    }

    @Test
    void testSegregateEvenOdd5() {
        // Test: Empty list
        LinkedList.Node head = null;
        head = LinkedList.segregateEvenOdd(head);
        assertArrayEquals(new int[]{}, toArray(head));
    }


    @Test
    void testInsertPos1() {
        // Test: Insert at position 1 in an empty list
        LinkedList.Node head = null;
        head = LinkedList.insertPos(head, 1, 10);
        assertArrayEquals(new int[]{10}, toArray(head));
    }

    @Test
    void testInsertPos2() {
        // Test: Insert at position 2 in a multi-node list
        LinkedList.Node head = createList(new int[]{10, 30});
        head = LinkedList.insertPos(head, 2, 20);
        assertArrayEquals(new int[]{10, 20, 30}, toArray(head));
    }

    @Test
    void testInsertPos3() {
        // Test: Insert at position greater than the list size
        LinkedList.Node head = createList(new int[]{10, 20});
        head = LinkedList.insertPos(head, 5, 30);
        assertArrayEquals(new int[]{10, 20}, toArray(head)); // No insertion
    }

    @Test
    void testInsertPos4() {
        // Test: Insert at the beginning of the list
        LinkedList.Node head = createList(new int[]{20, 30});
        head = LinkedList.insertPos(head, 1, 10);
        assertArrayEquals(new int[]{10, 20, 30}, toArray(head));
    }

    @Test
    void testInsertPos5() {
        // Test: Insert at the last position in the list
        LinkedList.Node head = createList(new int[]{10, 20});
        head = LinkedList.insertPos(head, 3, 30);
        assertArrayEquals(new int[]{10, 20, 30}, toArray(head));
    }
    @Test
    void testRotate1() {
        // Test: Rotate a list of size 3 by 1 position
        LinkedList.Node head = createList(new int[]{10, 20, 30});
        head = LinkedList.rotate(head, 1);
        assertArrayEquals(new int[]{20, 30, 10}, toArray(head));
    }

    @Test
    void testRotate2() {
        // Test: Rotate a single-node list
        LinkedList.Node head = createList(new int[]{10});
        head = LinkedList.rotate(head, 1);
        assertArrayEquals(new int[]{10}, toArray(head));
    }

    @Test
    void testRotate3() {
        // Test: Rotate an empty list
        LinkedList.Node head = null;
        head = LinkedList.rotate(head, 3);
        assertArrayEquals(new int[]{}, toArray(head));
    }


    @Test
    void testRotate4() {
        // Test: Rotate a list by 0 (no change)
        LinkedList.Node head = createList(new int[]{10, 20, 30});
        head = LinkedList.rotate(head, 0);
        assertArrayEquals(new int[]{10, 20, 30}, toArray(head));
    }

    @Test
    void deleteNodeFromEmptyList() {
        // Deleting a node from an empty list
        LinkedList.Node head = null;

        head = LinkedList.deleteNode(head, 1);

        // Assert the list remains empty
        assertNull(head, "Deleting from an empty list should result in null");
    }

    @Test
    void deleteHeadNode() {
        // Create a list with one node
        LinkedList.Node head = new LinkedList.Node(10);

        // Delete the head node
        head = LinkedList.deleteNode(head, 1);

        // Assert the list becomes empty
        assertNull(head, "Deleting the head node from a single-node list should result in an empty list");
    }

    // Test case 1: Deleting a node from an empty list
    @Test
    void testDeleteNode1() {
        LinkedList.Node head = null;

        head = LinkedList.deleteNode(head, 1);

        // Assert the list remains null
        assertNull(head, "Deleting from an empty list should return null");
    }

    // Test case 2: Deleting the head node in a single-node list
    @Test
    void testDeleteNode2() {
        LinkedList.Node head = new LinkedList.Node(10);

        head = LinkedList.deleteNode(head, 1);

        // Assert the list becomes empty
        assertNull(head, "Deleting the head node from a single-node list should result in an empty list");
    }

    // Test case 3: Deleting the first node in a multi-node list
    @Test
    void testDeleteNode3() {
        LinkedList.Node head = new LinkedList.Node(10);
        head = LinkedList.append(head, 20);
        head = LinkedList.append(head, 30);

        head = LinkedList.deleteNode(head, 1);

        // Assert the new head is correct
        assertNotNull(head, "The list should not be null after deleting the first node");
        assertEquals(20, head.data, "The new head should be the second node");
        assertEquals(30, head.next.data, "The second node should remain unchanged");
        assertNull(head.next.next, "The list should end after the second node");
    }

    // Test case 4: Deleting a middle node in a multi-node list
    @Test
    void testDeleteNode4() {
        LinkedList.Node head = new LinkedList.Node(10);
        head = LinkedList.append(head, 20);
        head = LinkedList.append(head, 30);
        head = LinkedList.append(head, 40);

        head = LinkedList.deleteNode(head, 3);

        // Assert the list structure is correct
        assertEquals(10, head.data, "The first node should remain unchanged");
        assertEquals(20, head.next.data, "The second node should remain unchanged");
        assertEquals(40, head.next.next.data, "The third node should be updated to the next node");
        assertNull(head.next.next.next, "The list should end after the updated node");
    }

    // Test case 5: Deleting the last node in a multi-node list
    @Test
    void testDeleteNode5() {
        LinkedList.Node head = new LinkedList.Node(10);
        head = LinkedList.append(head, 20);
        head = LinkedList.append(head, 30);

        head = LinkedList.deleteNode(head, 3);

        // Assert the list structure is correct
        assertEquals(10, head.data, "The first node should remain unchanged");
        assertEquals(20, head.next.data, "The second node should remain unchanged");
        assertNull(head.next.next, "The list should end after the second node");
    }

    // Test case 6: Deleting a node at an out-of-bounds position
    @Test
    void testDeleteNode6() {
        LinkedList.Node head = new LinkedList.Node(10);
        head = LinkedList.append(head, 20);
        head = LinkedList.append(head, 30);

        head = LinkedList.deleteNode(head, 5);

        // Assert the list remains unchanged
        assertEquals(10, head.data, "The first node should remain unchanged");
        assertEquals(20, head.next.data, "The second node should remain unchanged");
        assertEquals(30, head.next.next.data, "The third node should remain unchanged");
        assertNull(head.next.next.next, "The list should end after the third node");
    }

    // Test case 7: Deleting a node with invalid position in a single-node list
    @Test
    void testDeleteNode7() {
        LinkedList.Node head = new LinkedList.Node(10);

        head = LinkedList.deleteNode(head, 2);

        // Assert the list remains unchanged
        assertNotNull(head, "The head should not be null after attempting to delete an invalid position");
        assertEquals(10, head.data, "The only node should remain unchanged");
        assertNull(head.next, "The list should still have only one node");
    }




    // Test case 8: Verifying print message for an invalid position
    @Test
    void testDeleteNode8() {
        LinkedList.Node head = new LinkedList.Node(10);
        head = LinkedList.append(head, 20);

        // Redirect system output to capture the print statement
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        head = LinkedList.deleteNode(head, 5);

        // Assert the print message
        assertTrue(outContent.toString().contains("Data not present"), "Expected message 'Data not present' for invalid position");

        // Restore System.out
        System.setOut(System.out);
    }

    // Test case 9: Deleting a node when the list becomes null after deletion
    @Test
    void testDeleteNode9() {
        LinkedList.Node head = new LinkedList.Node(10);

        head = LinkedList.deleteNode(head, 1);

        // Assert the list is null after deletion
        assertNull(head, "Deleting the only node should result in null");
    }

}
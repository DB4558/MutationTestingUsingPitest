package Queue;

import org.example.Queue.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestAllQueue {
    /**
     * Test case to check enqueue operation and front and rear values.
     */
    @Test
    void queueTest1() {
        QueueClass queue = new QueueClass(3);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // Assert the front and rear values
        assertEquals(10, queue.front());
        assertEquals(30, queue.rear());
    }

    /**
     * Test case to check queue is full when size equals capacity.
     */
    @Test
    void queueTest2() {
        QueueClass queue = new QueueClass(2);

        queue.enqueue(10);
        queue.enqueue(20);

        // Assert that the queue is full
        assertTrue(queue.isFull(queue));
    }

    /**
     * Test case to check enqueue operation beyond capacity (should not be allowed).
     */
    @Test
    void queueTest3() {
        QueueClass queue = new QueueClass(2);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30); // This should not be allowed (queue is full)

        // Assert the size of the queue
        assertEquals(2, queue.size);
    }

    /**
     * Test case to check dequeue operation and updating front value.
     */
    @Test
    void queueTest4() {
        QueueClass queue = new QueueClass(3);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        int dequeuedItem = queue.dequeue();  // Dequeue the front item
        assertEquals(10, dequeuedItem);  // Assert the dequeued item
        assertEquals(20, queue.front());  // Assert that 20 is now the front
    }

    /**
     * Test case to check dequeue on an empty queue.
     */
    @Test
    void queueTest5() {
        QueueClass queue = new QueueClass(3);

        int dequeuedItem = queue.dequeue();  // Try to dequeue from an empty queue

        // Assert that dequeue returns Integer.MIN_VALUE indicating an empty queue
        assertEquals(Integer.MIN_VALUE, dequeuedItem);
    }

    /**
     * Test case to check the front method when the queue is not empty.
     */
    @Test
    void queueTest6() {
        QueueClass queue = new QueueClass(3);

        queue.enqueue(10);
        queue.enqueue(20);

        // Assert that the front element is 10
        assertEquals(10, queue.front());
    }

    /**
     * Test case to check the rear method when the queue is not empty.
     */
    @Test
    void queueTest7() {
        QueueClass queue = new QueueClass(3);

        queue.enqueue(10);
        queue.enqueue(20);

        // Assert that the rear element is 20
        assertEquals(20, queue.rear());
    }

    /**
     * Test case to check the isEmpty method on an empty queue.
     */
    @Test
    void queueTest8() {
        QueueClass queue = new QueueClass(3);

        // Assert that the queue is empty
        assertTrue(queue.isEmpty(queue));
    }

    /**
     * Test case to check the isEmpty method on a non-empty queue.
     */
    @Test
    void queueTest9() {
        QueueClass queue = new QueueClass(3);

        queue.enqueue(10);

        // Assert that the queue is not empty
        assertFalse(queue.isEmpty(queue));
    }

    /**
     * Test case to check after multiple enqueue and dequeue operations.
     */
    @Test
    void queueTest10() {
        QueueClass queue = new QueueClass(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // Dequeue one item
        queue.dequeue();

        // Assert the front and rear after one dequeue
        assertEquals(20, queue.front());
        assertEquals(30, queue.rear());
    }

    /**
     * Test case to check queue behavior after filling and emptying.
     */
    @Test
    void queueTest11() {
        QueueClass queue = new QueueClass(3);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // Dequeue all items
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        // Assert that the queue is empty
        assertTrue(queue.isEmpty(queue));
    }

    /**
     * Test case for checking circular nature of the queue.
     */
    @Test
    void queueTest12() {
        QueueClass queue = new QueueClass(3);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.dequeue();  // Removes 10
        queue.enqueue(30); // Adds 30

        // Assert that front and rear are updated correctly after circular behavior
        assertEquals(20, queue.front());
        assertEquals(30, queue.rear());
    }

    /**
     * Test case to check the queue behavior with negative values.
     */
    @Test
    void queueTest13() {
        QueueClass queue = new QueueClass(3);

        queue.enqueue(-10);
        queue.enqueue(-20);

        // Assert the front and rear values
        assertEquals(-10, queue.front());
        assertEquals(-20, queue.rear());
    }

    /**
     * Test case to check queue behavior with a single element.
     */
    @Test
    void queueTest14() {
        QueueClass queue = new QueueClass(3);

        queue.enqueue(10);

        // Assert that the front and rear are the same in a single-element queue
        assertEquals(10, queue.front());
        assertEquals(10, queue.rear());
    }

    @Test
    void queueTest15() {
        QueueClass queue = new QueueClass(3);

        // Call front on an empty queue
        int frontValue = queue.front();

        // Assert that it returns Integer.MIN_VALUE
        assertEquals(Integer.MIN_VALUE, frontValue, "Expected Integer.MIN_VALUE when calling front() on an empty queue");
    }

    /**
     * Test case to cover the `rear()` method when the queue is empty.
     */
    @Test
    void queueTest16() {
        QueueClass queue = new QueueClass(3);

        // Call rear on an empty queue
        int rearValue = queue.rear();

        // Assert that it returns Integer.MIN_VALUE
        assertEquals(Integer.MIN_VALUE, rearValue, "Expected Integer.MIN_VALUE when calling rear() on an empty queue");
    }
}
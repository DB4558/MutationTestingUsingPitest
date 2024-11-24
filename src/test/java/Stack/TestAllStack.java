package Stack;

import org.example.Stack.StackClass;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TestAllStack {

    @Test
    void testPushAndPop() {
        StackClass stack = new StackClass(3);
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Verify stack overflow
        stack.push(40); // Should not be added

        assertEquals(30, stack.pop());
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());

        // Verify stack underflow
        assertEquals(-1, stack.pop()); // Stack is empty
    }

    @Test
    void testTop() {
        StackClass stack = new StackClass(3);

        // Test top on an empty stack
        assertEquals(-1, stack.top());

        // Push elements and verify top
        stack.push(10);
        assertEquals(10, stack.top());
        stack.push(20);
        assertEquals(20, stack.top());
        stack.push(30);
        assertEquals(30, stack.top());

        // Pop elements and verify top
        stack.pop();
        assertEquals(20, stack.top());
        stack.pop();
        assertEquals(10, stack.top());

        // Test top on an empty stack again
        stack.pop(); // Stack is empty
        assertEquals(-1, stack.top());
    }

    @Test
    void testIsEmpty() {
        StackClass stack = new StackClass(3);

        // Verify stack is empty initially
        assertTrue(stack.isEmpty());

        // Push an element and verify stack is not empty
        stack.push(10);
        assertFalse(stack.isEmpty());

        // Pop all elements and verify stack is empty
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    void testPushPopSequence() {
        StackClass stack = new StackClass(5);

        // Perform mixed push and pop operations
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());

        // Verify stack underflow
        assertEquals(-1, stack.pop());
    }

    @Test
    void testBoundaryConditions() {
        StackClass stack = new StackClass(2);

        // Push up to capacity
        stack.push(100);
        stack.push(200);
        assertEquals(200, stack.top());

        // Overflow test
        stack.push(300); // Should print "Stack overflow"

        // Verify elements
        assertEquals(200, stack.pop());
        assertEquals(100, stack.pop());

        // Underflow test
        assertEquals(-1, stack.pop()); // Should print "Stack underflow"
    }
    /**
     * stackTest1: Test basic push and pop operations, including stack overflow and underflow scenarios.
     */
    @Test
    void stackTest1() {
        StackClass stack = new StackClass(3);

        // Push elements
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Attempt to overflow
        stack.push(40); // Should not be added

        // Pop elements and verify
        assertEquals(30, stack.pop());
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());

        // Test underflow
        assertEquals(-1, stack.pop());
    }

    /**
     * stackTest2: Test the top() method with empty, partially filled, and fully filled stack.
     */
    @Test
    void stackTest2() {
        StackClass stack = new StackClass(3);

        // Test top on an empty stack
        assertEquals(-1, stack.top());

        // Push elements and verify top
        stack.push(10);
        assertEquals(10, stack.top());
        stack.push(20);
        assertEquals(20, stack.top());
        stack.push(30);
        assertEquals(30, stack.top());

        // Pop elements and verify top
        stack.pop();
        assertEquals(20, stack.top());
        stack.pop();
        assertEquals(10, stack.top());

        // Test top on an empty stack again
        stack.pop();
        assertEquals(-1, stack.top());
    }

    /**
     * stackTest3: Test the isEmpty() method in various scenarios including transitions between empty and non-empty states.
     */
    @Test
    void stackTest3() {
        StackClass stack = new StackClass(3);

        // Verify stack is initially empty
        assertTrue(stack.isEmpty());

        // Push elements and verify stack is not empty
        stack.push(10);
        assertFalse(stack.isEmpty());

        // Pop all elements and verify stack is empty again
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    /**
     * stackTest4: Test alternating push and pop operations to ensure proper stack behavior.
     */
    @Test
    void stackTest4() {
        StackClass stack = new StackClass(3);

        // Push and pop alternately
        stack.push(1);
        assertEquals(1, stack.pop());
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop());
        stack.push(4);
        assertEquals(4, stack.pop());
        assertEquals(2, stack.pop());

        // Verify stack is empty
        assertTrue(stack.isEmpty());
    }

    /**
     * stackTest5: Test pushing and popping elements up to the exact stack capacity.
     */
    @Test
    void stackTest5() {
        StackClass stack = new StackClass(2);

        // Push exactly to capacity
        stack.push(10);
        stack.push(20);

        // Pop all elements and verify
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());

        // Test underflow
        assertEquals(-1, stack.pop());
    }

    /**
     * stackTest6: Test the stack behavior under stress with a large number of push and pop operations.
     */
    @Test
    void stackTest6() {
        StackClass stack = new StackClass(1000);

        // Push a large number of elements
        for (int i = 1; i <= 1000; i++) {
            stack.push(i);
        }

        // Pop all elements and verify correctness
        for (int i = 1000; i >= 1; i--) {
            assertEquals(i, stack.pop());
        }

        // Verify stack is empty
        assertTrue(stack.isEmpty());
    }

    /**
     * stackTest7: Test boundary conditions with minimum stack size and verify behavior with single element.
     */
    @Test
    void stackTest7() {
        StackClass stack = new StackClass(1);

        // Push one element
        stack.push(42);

        // Verify top and pop
        assertEquals(42, stack.top());
        assertEquals(42, stack.pop());
        assertTrue(stack.isEmpty());

        // Underflow test
        assertEquals(-1, stack.pop());
    }

    /**
     * stackTest8: Test stack with negative numbers as input.
     */
    @Test
    void stackTest8() {
        StackClass stack = new StackClass(3);

        // Push negative numbers
        stack.push(-1);
        stack.push(-2);
        stack.push(-3);

        // Attempt to overflow
        stack.push(-4); // Should not be added

        // Pop and verify
        assertEquals(-3, stack.pop());
        assertEquals(-2, stack.pop());
        assertEquals(-1, stack.pop());

        // Test underflow
        assertEquals(-1, stack.pop());
    }

    /**
     * stackTest9: Test the stack's behavior when alternating top() and push() calls.
     */
    @Test
    void stackTest9() {
        StackClass stack = new StackClass(3);

        // Top on an empty stack
        assertEquals(-1, stack.top());

        // Push and verify top
        stack.push(10);
        assertEquals(10, stack.top());
        stack.push(20);
        assertEquals(20, stack.top());

        // Multiple calls to top
        assertEquals(20, stack.top());
        assertEquals(20, stack.top());

        // Pop and verify top
        stack.pop();
        assertEquals(10, stack.top());
        stack.pop();
        assertEquals(-1, stack.top()); // Stack is empty
    }

    /**
     * stackTest10: Test pushing and popping with exact boundary conditions to verify limits.
     */
    @Test
    void stackTest10() {
        StackClass stack = new StackClass(2);

        // Push elements within capacity
        stack.push(100);
        stack.push(200);

        // Overflow test
        stack.push(300); // Should not be added

        // Verify popping works correctly
        assertEquals(200, stack.pop());
        assertEquals(100, stack.pop());

        // Underflow test
        assertEquals(-1, stack.pop());
    }


    /**
     * stackTest1: Test basic push and pop operations, including stack overflow and underflow scenarios.
     */
    @Test
    void stackTest11() {
        StackClass stack = new StackClass(3);

        // Push elements
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Attempt to overflow
        stack.push(40); // Should not be added

        // Pop elements and verify
        assertEquals(30, stack.pop());
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());

        // Test underflow
        assertEquals(-1, stack.pop());
    }

    /**
     * stackTest2: Test the top() method with empty, partially filled, and fully filled stack.
     */
    @Test
    void stackTest12() {
        StackClass stack = new StackClass(3);

        // Test top on an empty stack
        assertEquals(-1, stack.top());

        // Push elements and verify top
        stack.push(10);
        assertEquals(10, stack.top());
        stack.push(20);
        assertEquals(20, stack.top());
        stack.push(30);
        assertEquals(30, stack.top());

        // Pop elements and verify top
        stack.pop();
        assertEquals(20, stack.top());
        stack.pop();
        assertEquals(10, stack.top());

        // Test top on an empty stack again
        stack.pop();
        assertEquals(-1, stack.top());
    }

    /**
     * stackTest3: Test the isEmpty() method in various scenarios including transitions between empty and non-empty states.
     */
    @Test
    void stackTest13() {
        StackClass stack = new StackClass(3);

        // Verify stack is initially empty
        assertTrue(stack.isEmpty());

        // Push elements and verify stack is not empty
        stack.push(10);
        assertFalse(stack.isEmpty());

        // Pop all elements and verify stack is empty again
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    /**
     * stackTest4: Test stack behavior with large inputs to stress-test performance and correctness.
     */
    @Test
    void stackTest14() {
        StackClass stack = new StackClass(1000);

        // Push a large number of elements
        for (int i = 1; i <= 1000; i++) {
            stack.push(i);
        }

        // Pop all elements and verify correctness
        for (int i = 1000; i >= 1; i--) {
            assertEquals(i, stack.pop());
        }

        // Verify stack is empty
        assertTrue(stack.isEmpty());
    }

    /**
     * stackTest5: Test pushing and popping a mix of positive, negative, and zero values.
     */
    @Test
    void stackTest15() {
        StackClass stack = new StackClass(5);

        // Push mixed values
        stack.push(0);
        stack.push(-1);
        stack.push(1);
        stack.push(Integer.MAX_VALUE);
        stack.push(Integer.MIN_VALUE);

        // Pop and verify
        assertEquals(Integer.MIN_VALUE, stack.pop());
        assertEquals(Integer.MAX_VALUE, stack.pop());
        assertEquals(1, stack.pop());
        assertEquals(-1, stack.pop());
        assertEquals(0, stack.pop());

        // Underflow test
        assertEquals(-1, stack.pop());
    }

    /**
     * stackTest6: Test behavior when calling pop() or top() repeatedly on an empty stack.
     */
    @Test
    void stackTest16() {
        StackClass stack = new StackClass(3);

        // Repeated calls to pop on empty stack
        for (int i = 0; i < 5; i++) {
            assertEquals(-1, stack.pop());
        }

        // Repeated calls to top on empty stack
        for (int i = 0; i < 5; i++) {
            assertEquals(-1, stack.top());
        }

        // Verify stack is still empty
        assertTrue(stack.isEmpty());
    }

    /**
     * stackTest7: Test alternating push and pop operations to ensure correct internal state handling.
     */
    @Test
    void stackTest17() {
        StackClass stack = new StackClass(4);

        // Alternating operations
        stack.push(5);
        assertEquals(5, stack.pop());
        stack.push(10);
        stack.push(15);
        assertEquals(15, stack.pop());
        stack.push(20);
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());

        // Verify stack is empty
        assertTrue(stack.isEmpty());
    }

    /**
     * stackTest8: Test stack behavior under extreme edge cases such as zero capacity.
     */
    @Test
    void stackTest18() {
        StackClass stack = new StackClass(0);

        // Attempt to push into a zero-capacity stack
        stack.push(1);
        assertEquals(-1, stack.top()); // Should always be empty
        assertTrue(stack.isEmpty());
        assertEquals(-1, stack.pop()); // Should return underflow
    }

    /**
     * stackTest9: Test pushing and popping when capacity is reached multiple times.
     */
    @Test
    void stackTest19() {
        StackClass stack = new StackClass(2);

        // First cycle of push and pop
        stack.push(100);
        stack.push(200);
        assertEquals(200, stack.pop());
        assertEquals(100, stack.pop());

        // Second cycle of push and pop
        stack.push(300);
        stack.push(400);
        assertEquals(400, stack.pop());
        assertEquals(300, stack.pop());

        // Verify stack is empty
        assertTrue(stack.isEmpty());
    }

    /**
     * stackTest10: Test boundary conditions with the smallest stack size of 1.
     */
    @Test
    void stackTest20() {
        StackClass stack = new StackClass(1);

        // Push and verify top
        stack.push(42);
        assertEquals(42, stack.top());

        // Pop and verify stack is empty
        assertEquals(42, stack.pop());
        assertTrue(stack.isEmpty());

        // Underflow test
        assertEquals(-1, stack.pop());
    }

}

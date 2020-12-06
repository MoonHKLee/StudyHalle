package issue4.chapter3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTest {

    Stack stack;

    @BeforeEach
    void init() {
        stack = new Stack();
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(9);
        stack.push(7);
    }

    @Test
    void push() {
        assertEquals(5, stack.getSize());
        assertEquals(7, stack.peek());

        stack.push(10);

        assertEquals(6, stack.getSize());
        assertEquals(10, stack.peek());
    }

    @Test
    void pop() {
        assertEquals(5, stack.getSize());
        assertEquals(7, stack.peek());

        int pop = stack.pop();

        assertEquals(4, stack.getSize());
        assertEquals(7, pop);
    }

}

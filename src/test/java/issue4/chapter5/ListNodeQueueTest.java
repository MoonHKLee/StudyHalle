package issue4.chapter5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListNodeQueueTest {

    ListNodeQueue queue;

    @BeforeEach
    void init() {
        queue = new ListNodeQueue();
        queue.offer(1);
        queue.offer(3);
        queue.offer(2);
        queue.offer(9);
        queue.offer(7);
    }

    @Test
    void offer() {
        assertEquals(5, queue.getSize());
        assertEquals(1, queue.peek());

        queue.offer(10);

        assertEquals(6, queue.getSize());
        assertEquals(1, queue.peek());
    }

    @Test
    void poll() {
        assertEquals(5, queue.getSize());
        assertEquals(1, queue.peek());

        int poll = queue.poll();

        assertEquals(4, queue.getSize());
        assertEquals(1, poll);
        assertEquals(3, queue.peek());
    }

}

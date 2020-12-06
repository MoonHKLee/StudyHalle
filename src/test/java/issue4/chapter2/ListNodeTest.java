package issue4.chapter2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("LIST NODE 테스트")
class ListNodeTest {

    @Nested
    @DisplayName("ADD 테스트")
    class ListNodeAddTest {

        ListNode list;

        @BeforeEach
        void setList() {
            list = getListNode();
        }

        @Test
        @DisplayName("ADD_FIRST")
        void addFirst() {
            list.add(list,new ListNode(10),0);

            assertEquals(10,list.getPositionNumber(list,0));
            assertEquals(1,list.getPositionNumber(list,1));
            assertEquals(2,list.getPositionNumber(list,2));
            assertEquals(3,list.getPositionNumber(list,3));

            assertEquals(4,list.size());
        }

        @Test
        @DisplayName("ADD_MIDDLE")
        void addMiddle() {
            list.add(list,new ListNode(10),1);

            assertEquals(1,list.getPositionNumber(list,0));
            assertEquals(10,list.getPositionNumber(list,1));
            assertEquals(2,list.getPositionNumber(list,2));
            assertEquals(3,list.getPositionNumber(list,3));

            assertEquals(4,list.size());
        }

        @Test
        @DisplayName("ADD_LAST")
        void addLast() {
            list.add(list,new ListNode(10),3);

            assertEquals(1,list.getPositionNumber(list,0));
            assertEquals(2,list.getPositionNumber(list,1));
            assertEquals(3,list.getPositionNumber(list,2));
            assertEquals(10,list.getPositionNumber(list,3));

            assertEquals(4,list.size());
        }
    }

    @Nested
    @DisplayName("REMOVE 테스트")
    class ListNodeRemoveTest {

        ListNode list;

        @BeforeEach
        void setList() {
            list = getListNode();
        }

        @Test
        @DisplayName("REMOVE_FIRST")
        void test_add_first() {
            list.remove(list,0);

            assertEquals(2,list.getPositionNumber(list,0));
            assertEquals(3,list.getPositionNumber(list,1));

            assertEquals(2,list.size());
        }

        @Test
        @DisplayName("REMOVE_MIDDLE")
        void test_add_middle() {
            list.remove(list,1);

            assertEquals(1,list.getPositionNumber(list,0));
            assertEquals(3,list.getPositionNumber(list,1));

            assertEquals(2,list.size());
        }

        @Test
        @DisplayName("REMOVE_LAST")
        void test_add_last() {
            list.remove(list,2);

            assertEquals(1,list.getPositionNumber(list,0));
            assertEquals(2,list.getPositionNumber(list,1));

            assertEquals(2,list.size());
        }
    }

    @Nested
    @DisplayName("CONTAINS 테스트")
    class ListNodeContainsTest {

        ListNode list;

        @BeforeEach
        void setList() {
            list = getListNode();
        }

        @Test
        @DisplayName("CONTAINS_FIRST")
        void test_add_first() {
            assertTrue(list.contains(list, new ListNode(1)));
        }

        @Test
        @DisplayName("CONTAINS_MIDDLE")
        void test_add_middle() {
            assertTrue(list.contains(list, new ListNode(2)));
        }

        @Test
        @DisplayName("CONTAINS_LAST")
        void test_add_last() {
            assertTrue(list.contains(list, new ListNode(3)));
        }
    }

    private ListNode getListNode() {
        ListNode list = new ListNode();
        list.add(list, new ListNode(1), 0);
        list.add(list, new ListNode(2), 1);
        list.add(list, new ListNode(3), 2);
        return list;
    }

}

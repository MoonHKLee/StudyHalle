package src;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class AppTest {

    @BeforeAll
    static void testBeforeAll() {
        System.out.println("before all");
    }


    @AfterAll
    static void testAfterAll() {
        System.out.println("after all");
    }


    @BeforeEach
    void testBeforeEach() {
        System.out.println("before each");
    }


    @AfterEach
    void testAfterEach() {
        System.out.println("after each");
    }

    @Test
    @DisplayName("테스트1")
    void testName1() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5});
    }

    @Test
    @DisplayName("테스트2")
    void testName2() {
        System.out.println("22222222");
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        assertIterableEquals(list1, list2);
    }

    @Test
    void testName3() {
        assertAll(
            () -> assertEquals(3, 3),
            () -> assertEquals("3", "3"),
            () -> assertTrue(true)
        );
        System.out.println("33333333");
    }

    void hello() {
        System.out.println("hello");
    }

    String getErrorMessage() {
        return "에러가 발생했습니다.";
    }
    @Test
    void testName4() {
        int[] arr = new int[10];
        assertThrows(
            IndexOutOfBoundsException.class,
            this::hello,
            this::getErrorMessage
            );
        System.out.println("44444444");
    }
}

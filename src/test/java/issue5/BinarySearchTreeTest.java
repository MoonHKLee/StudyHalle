package issue5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {

    BinarySearchTree tree;

    @BeforeEach
    void init() {
        tree = new BinarySearchTree();
        tree.add(50);
        tree.add(30);
        tree.add(70);
        tree.add(20);
        tree.add(40);
        tree.add(60);
        tree.add(80);
    }

    @Test
    void test_binary_search_tree_bfs() {
        List<Integer> expects = new ArrayList<>();
        expects.add(50);
        expects.add(30);
        expects.add(70);
        expects.add(20);
        expects.add(40);
        expects.add(60);
        expects.add(80);

        List<Integer> bfsResult = tree.getBFSResult();
        for (int i = 0; i < expects.size(); i++) {
            assertEquals(expects.get(i),bfsResult.get(i));
        }
    }

    @Test
    void test_binary_search_tree_dfs() {
        List<Integer> expects = new ArrayList<>();
        expects.add(20);
        expects.add(30);
        expects.add(40);
        expects.add(50);
        expects.add(60);
        expects.add(70);
        expects.add(80);

        List<Integer> dfsResult = tree.getDFSResult();
        for (int i = 0; i < expects.size(); i++) {
            assertEquals(expects.get(i),dfsResult.get(i));
        }
    }

    @Test
    void test_binary_search_tree_contains() {
        assertTrue(tree.contains(20));
        assertTrue(tree.contains(30));
        assertTrue(tree.contains(40));
        assertTrue(tree.contains(50));
        assertTrue(tree.contains(60));
        assertTrue(tree.contains(70));
        assertTrue(tree.contains(80));
        assertFalse(tree.contains(15));
        assertFalse(tree.contains(25));
        assertFalse(tree.contains(0));

        PriorityQueue<Integer> queue = new PriorityQueue<>();
    }

    @Test
    void test_binary_search_tree_remove() {
        tree.remove(20);
        tree.remove(40);
        tree.remove(50);
        tree.remove(60);
        tree.remove(80);

        assertFalse(tree.contains(20));
        assertTrue(tree.contains(30));
        assertFalse(tree.contains(40));
        assertFalse(tree.contains(50));
        assertFalse(tree.contains(60));
        assertTrue(tree.contains(70));
        assertFalse(tree.contains(80));
    }
}

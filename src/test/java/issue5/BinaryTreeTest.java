package issue5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinaryTreeTest {

    BinaryTree tree;

    @BeforeEach
    void init() {
        tree = new BinaryTree();
        tree.init(50);
        tree.root.addLeft(60);
        tree.root.addRight(70);
        tree.root.left.addLeft(80);
        tree.root.left.addRight(90);
        tree.root.right.addLeft(100);
        tree.root.right.addRight(110);
    }

    @Test
    void test_binary_tree_dfs() {
        List<Integer> list = new ArrayList<>();
        list.add(80);
        list.add(60);
        list.add(90);
        list.add(50);
        list.add(100);
        list.add(70);
        list.add(110);
        List<Integer> result = tree.getDFSResult();

        for (int i = 0; i < list.size(); i++) {
            assertEquals(list.get(i),result.get(i));
        }
    }

    @Test
    void test_binary_tree_bfs() {
        List<Integer> list = new ArrayList<>();
        list.add(50);
        list.add(60);
        list.add(70);
        list.add(80);
        list.add(90);
        list.add(100);
        list.add(110);
        List<Integer> result = tree.getBFSResult();

        for (int i = 0; i < list.size(); i++) {
            assertEquals(list.get(i),result.get(i));
        }
    }

}

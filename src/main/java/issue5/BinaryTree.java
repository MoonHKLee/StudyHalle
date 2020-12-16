package issue5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTree {

    Node root;

    private final List<Integer> dfsResult = new ArrayList<>();

    private final List<Integer> bfsResult = new ArrayList<>();

    public BinaryTree() {

    }

    public void init(int value) {
        root = new Node(value, null);
    }

    public List<Integer> getDFSResult() {
        dfsResult.clear();
        dfs(root);
        return dfsResult;
    }

    public List<Integer> getBFSResult() {
        bfsResult.clear();
        bfs(root);
        return bfsResult;
    }

    private void dfs(Node node) {
        if (node.left == null) {
            dfsResult.add(node.value);
            return;
        }
        dfs(node.left);
        dfsResult.add(node.value);
        if (node.right == null) {
            dfsResult.add(node.value);
            System.out.println(node.value);
        }
        dfs(node.right);
    }

    private void bfs(Node node) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            bfsResult.add(poll.value);

            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
    }
}

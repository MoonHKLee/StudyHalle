package issue5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree {

    private Node node;

    private final List<Integer> dfsResult = new ArrayList<>();

    private final List<Integer> bfsResult = new ArrayList<>();

    public BinarySearchTree() {

    }

    //recursive
    public void add(int value) {
        if (node == null) {
            node = new Node(value, null);
            return;
        }
        Node result = find(node, value);
        if (result.value == value) {
            System.out.println("tree has this value already.");
        } else {
            if (result.value > value) {
                result.addLeft(value);
            } else {
                result.addRight(value);
            }
        }
    }

    //iter
//    public void add(int value) {
//        Node tmp = node;
//        if (node == null) {
//            node = new Node(value, null);
//            return;
//        }
//        while (true) {
//            if (tmp.value > value) {
//                if (tmp.left == null) {
//                    tmp.addLeft(value);
//                    break;
//                }
//                tmp = tmp.left;
//            } else if (tmp.value < value) {
//                if (tmp.right == null) {
//                    tmp.addRight(value);
//                    break;
//                }
//                tmp = tmp.right;
//            } else {
//                System.out.println("tree has this value already.");
//            }
//        }
//    }

    public void remove(int value) {
        if (node == null) {
            System.out.println("tree hasn't any value");
            return;
        }
        Node result = find(node, value);
        if (result.parent==null) {
            Node near = getNear(result);
            if (near.parent == null) {
                node = null;
                return;
            }
            result.value = near.value;
            if (near.left!=null && near.right==null) {
                Node parent = near.parent;
                if (parent.value > value) {
                    parent.left = near.left;
                } else {
                    parent.right = near.left;
                }
            }
            if (near.left==null && near.right!=null) {
                Node parent = near.parent;
                if (parent.value > value) {
                    parent.left = near.right;
                } else {
                    parent.right = near.right;
                }
            }
            near.parent = null;
            return;
        }
        if (result.value == value) {
            if (result.left == null && result.right == null) {
                Node parent = result.parent;
                if (parent.value > value) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                result.parent = null;
            }
            if (result.left != null && result.right == null) {
                Node parent = result.parent;
                if (parent.value > value) {
                    parent.left = result.left;
                } else {
                    parent.right = result.left;
                }
                result.parent = null;
            }
            if (result.left == null && result.right != null) {
                Node parent = result.parent;
                if (parent.value > value) {
                    parent.left = result.right;
                } else {
                    parent.right = result.right;
                }
                result.parent = null;
            }
            if (result.left != null && result.right != null) {
                Node near = getNear(result);
                result.value = near.value;
                Node parent = near.parent;
                if (parent.value > value) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                near.parent = null;
            }
        } else {
            System.out.println("tree hasn't this value");
        }
    }

    //recursive
    public boolean contains(int value) {
        if (node == null) {
            return false;
        }
        Node result = find(this.node, value);
        return result.value == value;
    }

    //iter
//    public boolean contains(int value) {
//        if (node == null) {
//            return false;
//        }
//        Node tmp = node;
//        while (true) {
//            if (tmp.value > value) {
//                if (tmp.left == null) {
//                    return false;
//                }
//                tmp = tmp.left;
//            } else if (tmp.value < value) {
//                if (tmp.right == null) {
//                    return false;
//                }
//                tmp = tmp.right;
//            } else {
//                return true;
//            }
//        }
//    }

    private Node find(Node node, int value) {
        if (node.value > value) {
            if (node.left == null) {
                return node;
            }
            return find(node.left, value);
        } else if (node.value < value) {
            if (node.right == null) {
                return node;
            }
            return find(node.right, value);
        } else {
            return node;
        }
    }

    private Node getNear(Node node) {
        if (node.left!=null) {
            node = node.left;
            while(node.right!=null) {
                node = node.right;
            }
        }else if (node.right!=null) {
            node = node.right;
            while(node.left!=null) {
                node = node.left;
            }
        }
        return node;
    }

    public List<Integer> getDFSResult() {
        dfsResult.clear();
        dfs(node);
        return dfsResult;
    }

    public List<Integer> getBFSResult() {
        bfsResult.clear();
        bfs(node);
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

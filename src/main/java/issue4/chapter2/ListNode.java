package issue4.chapter2;

public class ListNode {

    int number;

    ListNode node;

    ListNode top;

    public ListNode() {

    }

    public ListNode(int number) {
        this.number = number;
    }

    public ListNode add(ListNode head, ListNode nodeToAdd, int position) {
        top = head;
        for (int i = 0; i < position; i++) {
            top = top.node;
        }
        if (top.node != null) {
            nodeToAdd.node = top.node;
        }
        top.node = nodeToAdd;
        return head;
    }

    public int getPositionNumber(ListNode head, int position) {
        top = head;
        top = top.node;
        for (int i = 0; i < position; i++) {
            top = top.node;
        }
        return top.number;
    }

    public ListNode remove(ListNode head, int positionToRemove) {
        top = head;
        ListNode remove;
        for (int i = 0; i < positionToRemove; i++) {
            top = top.node;
        }
        if (top.node.node == null) {
            remove = top.node;
            top.node = null;
        } else {
            remove = top.node;
            top.node = top.node.node;
        }
        return remove;
    }

    public boolean contains(ListNode head, ListNode nodeToCheck) {
        top = head;
        top = top.node;
        while (top != null) {
            if (top.number == nodeToCheck.number) {
                return true;
            }
            top = top.node;
        }
        return false;
    }

    public int size() {
        int count = 0;
        ListNode top = this;
        top = top.node;
        while (top != null) {
            top = top.node;
            count++;
        }
        return count;
    }

    public void setNode(ListNode node) {
        this.node = node;
    }

    public ListNode getNode() {
        return node;
    }

    public int getNumber() {
        return number;
    }
}

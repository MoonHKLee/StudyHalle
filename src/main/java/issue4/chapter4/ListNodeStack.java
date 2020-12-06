package issue4.chapter4;

import issue4.chapter2.ListNode;

public class ListNodeStack {

    ListNode head;

    public ListNodeStack() {
        head = new ListNode();
    }

    public void push(int data) {
        head.add(head, new ListNode(data), 0);
    }

    public int pop() {
        return head.remove(head, 0).getNumber();
    }

    public int peek() {
        head.setNode(head.getNode());
        return head.getNode().getNumber();
    }

    public int getSize() {
        return head.size();
    }
}

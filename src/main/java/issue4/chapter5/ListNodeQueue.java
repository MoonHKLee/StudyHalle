package issue4.chapter5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ListNodeQueue {

    public static void main(String[] args) throws IOException {
        ListNodeQueue queue = new ListNodeQueue();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            if (split.length==2) {
                queue.offer(Integer.parseInt(split[1]));
            } else {
                if(split[0].equals("front")) {
                    if (queue.getSize()==0) {
                        bw.write("-1\n");
                    } else {
                        bw.write(queue.peek()+"\n");
                    }
                }
                if(split[0].equals("back")) {
                    if (queue.getSize()==0) {
                        bw.write("-1\n");
                    } else {
                        bw.write(queue.back()+"\n");
                    }
                }
                if(split[0].equals("size")) {
                    bw.write(queue.getSize()+"\n");
                }
                if(split[0].equals("empty")) {
                    if (queue.getSize()==0) {
                        bw.write("1");
                    } else {
                        bw.write("0");
                    }
                }
                if(split[0].equals("pop")) {
                    if (queue.getSize()==0) {
                        bw.write("-1\n");
                    }else {
                        bw.write(queue.poll()+"\n");
                    }
                }
            }
        }

    }

    ListNode head;

    public ListNodeQueue() {
        head = new ListNode();
    }

    public void offer(int data) {
        head.add(head, new ListNode(data), head.size());
    }

    public int poll() {
        return head.remove(head, 0).getNumber();
    }

    public int peek() {
        return head.getPositionNumber(head, 0);
    }

    public int getSize() {
        return head.size();
    }

    public int back() {
        return head.getPositionNumber(head, getSize());
    }

}

class ListNode {

    int number;

    ListNode node;

    ListNode top;

    public ListNode() {

    }

    public ListNode(int number) {
        this.number = number;
    }

    public ListNode add(
        ListNode head, ListNode nodeToAdd, int position) {
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
         top = this;
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

import java.util.List;

public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(){}

        ListNode(int val){
            this.val = val;
        }

        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode forwards = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode backwards = reverseList(forwards);
        while(backwards != null){
            System.out.print(backwards.val + " ");
            backwards = backwards.next;
        }
    }
}

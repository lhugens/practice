import java.util.List;

public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(){
        }

        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        // Move first so that the gap between first and second is n nodes apart
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Remove the nth node from the end
        second.next = second.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head;
        ListNode result;
        ListNode iterator;

        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        result = removeNthFromEnd(head, 2);
        iterator = result;
        while(iterator != null){
            System.out.print(iterator.val);
            iterator = iterator.next;
        }

        System.out.println("");

        head = new ListNode(1);
        result = removeNthFromEnd(head, 1);
        iterator = result;
        while(iterator != null){
            System.out.print(iterator.val);
            iterator = iterator.next;
        }

        System.out.println("");

        head = new ListNode(1, new ListNode(2));
        result = removeNthFromEnd(head, 1);
        iterator = result;
        while(iterator != null){
            System.out.print(iterator.val);
            iterator = iterator.next;
        }
    }
}

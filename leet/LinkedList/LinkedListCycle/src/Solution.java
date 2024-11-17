import org.w3c.dom.ls.LSException;

import java.util.List;

public class Solution {
    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

    }

    public static boolean hasCycle(ListNode head) {

        if(head == null || head.next == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(3);
        ListNode first = new ListNode(2);
        ListNode second = new ListNode(0);
        ListNode third = new ListNode(-4);

        head.next = first;
        first.next = second;
        second.next = third;
        third.next = first;

        System.out.println(hasCycle(head));

        ListNode head1 = new ListNode(1);
        ListNode first1 = new ListNode(2);

        head1.next = first1;
        first1.next = head1;

        System.out.println(hasCycle(head1));

        ListNode head2 = new ListNode(1);

        System.out.println(hasCycle(head2));

    }
}

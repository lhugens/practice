public class Main {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public class Solution {
        public static void deleteNode(ListNode node){
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);

        ListNode el1 = new ListNode(5);
        head.next = el1;

        ListNode el2 = new ListNode(1);
        el1.next = el2;

        ListNode el3 = new ListNode(9);
        el2.next = el3;


        // Print LinkedList
        ListNode it = head;
        while (it != null) {
            System.out.print(it.val);
            it = it.next;
        }
        System.out.println("");

        Solution.deleteNode(el2);

        it = head;
        while (it != null) {
            System.out.print(it.val);
            it = it.next;
        }
    }
}

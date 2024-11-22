import java.math.BigInteger;
import java.util.List;

public class Solution {

    public static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        String n1 = "";
        String n2 = "";

        while (l1 != null) {
            n1 = Integer.toString(l1.val) + n1;
            l1 = l1.next;
        }

        while (l2 != null) {
            n2 = Integer.toString(l2.val) + n2;
            l2 = l2.next;
        }

        BigInteger num1 = new BigInteger(n1);
        BigInteger num2 = new BigInteger(n2);
        BigInteger sum = num1.add(num2);

        String result = sum.toString();

        ListNode l3 = new ListNode(Character.getNumericValue(result.charAt(0)));

        for (int i = 1; i < result.length(); i++) {
            int v = Character.getNumericValue(result.charAt(i));
            l3 = new ListNode(v, l3);
        }

        return l3;
    }

    public static void main(String[] args) {

        ListNode l1;
        ListNode l2;

        l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode l3 = addTwoNumbers(l1, l2);

        while(l3 != null){
            System.out.print(l3.val + "");
            l3 = l3.next;
        }

    }


}

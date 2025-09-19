package grind169;

public class LC2_AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode dummy = new ListNode(0);
        ListNode root = dummy;
        int value = 0;
        int carry = 0;
        while (l1 != null || l2 != null || value > 0) {
            if (l1 != null) {
                value += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                value += l2.val;
                l2 = l2.next;
            }
            if (value >= 10) {
                carry = value / 10;
                value = value % 10;
            }
            root.next = new ListNode(value);
            value = carry;
            carry = 0;
            root = root.next;
        }
        return dummy;
    }

    public static void main(String[] args) {
        LC2_AddTwoNumbers test = new LC2_AddTwoNumbers();
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        ListNode dummy = test.addTwoNumbers(l1, l2); // target: [8,9,9,1]
        while (dummy != null && dummy.next != null) {
            System.out.println(dummy.next.val);
            dummy = dummy.next;
        }
    }
}

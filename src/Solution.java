class Solution {
    public static boolean isPalindrome(ListNode head) {
        if (head==null) {
            return true;
        }

        // get list length, O(n)
        int length = 0;
        ListNode ptr = head;
        while (ptr!=null) {
            length++;
            ptr = ptr.next;
        }
        int lengthToCompare = length/2;

        // reverse the 2nd half of the list, O(n)
        ListNode midNode = middleOfList(head);
        ListNode midPtr = reverse(midNode);

        // compare the 1st half and 2nd half node by node, O(n)
        ListNode headPtr = head;
        for (int i = 0; i < lengthToCompare; i++) {
            if (headPtr.val!=midPtr.val) {
                return false;
            }
            headPtr = headPtr.next;
            midPtr = midPtr.next;
        }
        return true;
    }

    public static ListNode middleOfList(ListNode head) {
        if (head==null) {
            return null;
        }
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while (fastPtr!=null) {
            fastPtr = fastPtr.next;
            if (fastPtr==null) {
                break;
            }
            fastPtr = fastPtr.next;
            slowPtr = slowPtr.next;
        }
        return slowPtr;
    }

    public static ListNode reverse(ListNode head) {
        if (head==null) {
            return null;
        }

        ListNode p0 = head;
        ListNode p1 = head.next;
        while (p1 != null) {
            p0.next = p1.next;
            p1.next = head;
            head = p1;
            p1 = p0.next;
        }

        return head;
    }

    private static ListNode helper(ListNode node) {
        return null;
    }
}


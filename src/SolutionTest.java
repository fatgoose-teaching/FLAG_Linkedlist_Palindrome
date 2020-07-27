import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void testIsPalindrome() {
        // place holder. remove this when done
    }

    @Test
    public void testMiddleOfList() {
        // place holder. remove this when done
    }

    @Test
    public void testReverse() {
        // place holder. remove this when done
    }

    private List<TestCase> getTestCases(int[][] inputs, boolean[] expects) {
        List<TestCase> testCases = new ArrayList<>();
        for (int i = 0; i < inputs.length; i++) {
            TestCase testCase = new TestCase(arrayToList(inputs[i]), expects[i]);
            testCases.add(testCase);
        }
        return testCases;
    }

    private ListNode arrayToList(int[] input) {
        ListNode head = null;
        ListNode ptr = null;
        for (int val : input) {
            ListNode newNode = new ListNode(val);
            if (head == null) {
                head = newNode;
                ptr = head;
                continue;
            }
            ptr.next = newNode;
            ptr = newNode;
        }
        return head;
    }

    private int[] listToArray(ListNode list) {
        List<Integer> result = new ArrayList<>();
        while (list != null) {
            result.add(list.val);
            list = list.next;
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}

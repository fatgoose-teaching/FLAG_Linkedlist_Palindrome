import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void testDeleteNode() {
        int[][] inputs = {
                {},
                {1},
                {4, 5},
                {4, 4},
                {1,2,1},
                {1,2,3},
                {1,1,1},
                {1,2,3,1},
                {1,2,2,1},
        };
        boolean[] expects = {
                true,
                true,
                false,
                true,
                true,
                false,
                true,
                false,
                true,
        };

        List<TestCase> testCases = getTestCases(inputs, expects);

        for (int i = 0; i < testCases.size(); i++) {
            System.out.printf("case %d\n", i);

            TestCase testCase = testCases.get(i);

            assertEquals(testCase.expect, Solution.isPalindrome(testCase.head));
        }
    }

    @Test
    public void testMiddleOfList() {
        int[][] inputs = {
                {1},
                {4, 5},
                {1,2,1},
                {1,2,3,1},
        };
        int []expects = {1, 5, 2, 3};
        for (int i = 0; i < inputs.length; i++) {
            ListNode list = arrayToList(inputs[i]);
           assertEquals(expects[i], Solution.middleOfList(list).val);
        }
    }

    @Test
    public void testReverse() {
        int[][] inputs = {
                {1},
                {4, 5},
                {1,2,1},
                {1,2,3,4},
        };
        int[][] expects= {
                {1},
                {5, 4},
                {1,2,1},
                {4,3,2,1},
        };
        for (int i = 0; i < inputs.length; i++) {
            ListNode list = arrayToList(inputs[i]);
            list = Solution.reverse(list);
            assertArrayEquals(expects[i], listToArray(list));
        }
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

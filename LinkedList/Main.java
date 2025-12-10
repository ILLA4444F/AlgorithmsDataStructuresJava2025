import java.util.LinkedList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        Solution sol = new Solution();

        // === Example 1 ===
        ListNode e1_l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode e1_l2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode e1_result = sol.mergeTwoLists(e1_l1, e1_l2);
        System.out.print("Example 1 result: ");
        printList(e1_result);

        // === Example 2 ===
        ListNode e2_l1 = null;
        ListNode e2_l2 = null;

        ListNode e2_result = sol.mergeTwoLists(e2_l1, e2_l2);
        System.out.print("Example 2 result: ");
        printList(e2_result);

        // === Example 3 ===
        ListNode e3_l1 = null;
        ListNode e3_l2 = new ListNode(0);

        ListNode e3_result = sol.mergeTwoLists(e3_l1, e3_l2);
        System.out.print("Example 3 result: ");
        printList(e3_result);

        // === Повторити завдання через Java Collections ===
        LinkedList<Integer> listA = new LinkedList<>();
        Collections.addAll(listA, 1, 2, 4);

        LinkedList<Integer> listB = new LinkedList<>();
        Collections.addAll(listB, 1, 3, 4);

        LinkedList<Integer> mergedList = new LinkedList<>();
        mergedList.addAll(listA);
        mergedList.addAll(listB);

        Collections.sort(mergedList);

        System.out.println("Collections merged result: " + mergedList);
    }

    private static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}

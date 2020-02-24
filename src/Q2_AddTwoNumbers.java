import org.junit.Test;
/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q2_AddTwoNumbers {

    @Test
    public void solution() {
        int a[] = {2, 4, 3};
        int b[] = {5, 6, 4};
        ListNode listNode1 = new ListNode(0);
        ListNode listNode2 = new ListNode(0);

        ListNode currentNode = listNode1;
        ListNode temp = null;
        for (int j: a) {
            temp = new ListNode(j);
            currentNode.next = temp;
            currentNode = currentNode.next;
        }
        currentNode = listNode2;
        for (int j: b) {
            temp = new ListNode(j);
            currentNode.next = temp;
            currentNode = currentNode.next;
        }

        printNode(listNode1.next);
        printNode(listNode2.next);
        printNode(addTwoNumbers(listNode1.next, listNode2.next));
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode current = result;
        int c = 0;

        while (l1 != null || l2 != null) {
            int i = l1 != null ? l1.val : 0;
            int j = l2 != null ? l2.val : 0;
            int sum = i + j + c;
            int up = sum % 10;
            c = sum / 10;

            current.next = new ListNode(up);
            current = current.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (c != 0)
            current.next = new ListNode(c);
        return result.next;
    }

    public void printNode(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println();
    }
}

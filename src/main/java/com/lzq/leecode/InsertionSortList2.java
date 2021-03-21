package com.lzq.leecode;

/**
 * LeeCode
 *
 * 147. 对链表进行插入排序
 *
 * 解法二：插入元素时，根据记录的位置操作
 */
public class InsertionSortList2 {

    public InsertionSortList.ListNode insertionSortList(InsertionSortList.ListNode head) {
        if (head == null) {
            return null;
        }
        InsertionSortList.ListNode dummyHead = new InsertionSortList.ListNode(0);
        dummyHead.next = head;
        InsertionSortList.ListNode lastSorted = head, curr = head.next;
        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                InsertionSortList.ListNode prev = dummyHead;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }

}

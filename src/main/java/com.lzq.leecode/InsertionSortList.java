package com.lzq.leecode;

/**
 * LeeCode
 *
 * 147. 对链表进行插入排序
 */
public class InsertionSortList {


    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(19);
        ListNode node3 = new ListNode(14);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(-3);
        ListNode node6 = new ListNode(1);
        ListNode node7 = new ListNode(8);
        ListNode node8 = new ListNode(5);
        ListNode node9 = new ListNode(11);
        ListNode node10 = new ListNode(15);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;

        InsertionSortList test = new InsertionSortList();
        test.insertionSortList(node1);
        System.out.println(node1);

    }


    public ListNode insertionSortList(ListNode head) {

        if (head==null){ return null; }

        ListNode currentNode = head;
        ListNode nextNode;
        while ((nextNode = currentNode.next)!=null){
            if (currentNode.val>nextNode.val){
                //需要插入排序
                ListNode current = head;
                ListNode next = head.next;
                while (next!=null){
                    if (current.val<=nextNode.val && next.val>nextNode.val){
                        currentNode.next = nextNode.next;
                        ListNode temp = new ListNode(nextNode.val);
                        temp.next = current.next;
                        current.next = temp;
                        break;
                    }else if (current.val>nextNode.val){
                        currentNode.next = nextNode.next;
                        ListNode temp = new ListNode(nextNode.val);
                        temp.next = current;
                        head = temp;
                        break;
                    }
                    current = current.next;
                    next = current.next;
                }
            }else {
                currentNode = currentNode.next;
            }
        }
        return head;
    }



    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

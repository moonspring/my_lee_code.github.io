package com.lzq.leecode;

/**
 * LeeCode
 * <p>
 * 328. 奇偶链表
 */
public class OddEvenLinkedList {


    public static void main(String[] args) {

        ListNode first = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,null)))));

        OddEvenLinkedList odd = new OddEvenLinkedList();
        ListNode listNode = odd.oddEvenList(first);
        System.out.println(listNode);

    }


    public ListNode oddEvenList(ListNode head) {

        if (head==null){return null;}
        if (head!=null && head.next==null){return head;}

        ListNode resultNode = new ListNode(head.val,null);
        ListNode tempNode = new ListNode(head.next.val,null);

        ListNode currentNode = head.next;
        ListNode temp;
        int i = 2;
        while (currentNode != null){
            i++;
            currentNode = currentNode.next;

            if (i%2==0){
                temp = tempNode;
            }else {
                temp = resultNode;
            }
            while (temp.next!=null){
                temp = temp.next;
            }
            if (currentNode!=null){
                temp.next = new ListNode(currentNode.val,null);
            }
        }
        temp = resultNode;
        while (temp.next!=null){
            temp = temp.next;
        }
        temp.next = tempNode;
        return resultNode;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


}

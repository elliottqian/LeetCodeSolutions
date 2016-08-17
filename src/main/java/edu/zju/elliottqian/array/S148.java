package edu.zju.elliottqian.array;

/**
 * Created by QianWei on 2016/8/13.
 */
public class S148 {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(6);
        l1.next = l2;
        ListNode l3 = new ListNode(3);
        l2.next = l3;
        ListNode l4 = new ListNode(7);
        l3.next = l4;
        ListNode l5 = new ListNode(2);
        l4.next = l5;
        ListNode l6 = new ListNode(1);
        l5.next = l6;
        ListNode l7 = new ListNode(4);
        l6.next = l7;
        l7.next = null;

        ListNode x = l1;
        while(x.next.next != null) {
            //System.out.println(x.val);
            x = x.next;
        }
        ListNode end = x;
        System.out.println(end.val);
        ListNode start = l1.next;

        Solution_148 s = new Solution_148();
        x = s.sortList(l1);


        while(x != null) {
            System.out.println(x.val);
            x = x.next;
        }



    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {

 * }
 */
class Solution_148 {
    public ListNode sortList(ListNode head) {
        ListNode newHead = head;
        ListNode move_index = head.next;
        ListNode move_index_pre = head;
        ListNode temp;
        int time = 0;
        while (move_index != null) {

            System.out.println("-------------head.val 和 move_index.val----------------");
            System.out.println(head.val);
            System.out.println(move_index.val);

            if (head.val > move_index.val) {
                temp = move_index;
                move_index_pre.next = move_index.next;
                move_index.next = newHead;
                newHead = move_index;
                move_index = move_index_pre.next;
            }else {
                move_index = move_index.next;
                move_index_pre = move_index_pre.next;
            }

            System.out.println("-------------次数----------------");
            System.out.println(time++);
            System.out.println("----------------表内容-------------");

            ListNode x = newHead;
            while(x != null) {
                System.out.println(x.val);
                x = x.next;
            }

        }
        newHead = this.f(newHead, head);
        head.next = this.f(head.next, null);

        return newHead;
    }

    public ListNode f(ListNode head, ListNode end) {
        ListNode newHead = head;
        ListNode move_index = head.next;
        ListNode move_index_pre = head;


        int time = 0;

        while (move_index != null && move_index != end) {

            System.out.println("-------------head.val 和 move_index.val----------------");
            System.out.println(head.val);
            System.out.println(move_index.val);

            if (head.val > move_index.val) {
                move_index_pre.next = move_index.next;
                move_index.next = newHead;
                newHead = move_index;
                move_index = move_index_pre.next;
            }else {
                move_index = move_index.next;
                move_index_pre = move_index_pre.next;
            }
            System.out.println("-------------次数----------------");
            System.out.println(time++);
            System.out.println("-------------moveindex----------------");
            System.out.println(move_index.val);
            System.out.println(move_index.next);
            System.out.println("----------------表内容-------------");

            ListNode x = newHead;
            while(x != null) {
                System.out.println(x.val);
                x = x.next;
            }
        }

        return newHead;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}



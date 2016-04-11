package edu.zju.elliottqian.LinkedList;

/**
 * Created by ElliottQian on 2016.04.11.
 *
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class S024 {
    public static void main(String[] args){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;
        ListNode c = new ListNode(3);
        b.next = c;
        ListNode d = new ListNode(4);
        c.next = d;
        ListNode e = new ListNode(5);
        d.next = e;
        ListNode f = new ListNode(6);
        e.next = f;
        Solution_024 s = new Solution_024();
        s.show(a);

        ListNode r = s.swapPairs(a);
        s.show(r);
    }
}

class Solution_024 {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return head;
        if(head.next == null) return head;

        ListNode left = head;
        ListNode newHead = head.next;
        ListNode headNext = null;
        ListNode temp = null;

        while(left.next != null){

            headNext = left.next;
            temp = left.next.next;
            headNext.next = left;
            left.next = temp;

            if (left.next == null)
                break;

            if(left.next.next != null){
                temp = left.next;
                left.next = temp.next;
                left = temp;
            }else{
                left = left.next;
            }
        }

        return newHead;
    }

    public void show(ListNode head){
        ListNode h = head;
        while(h != null){
            System.out.println(h.val);
            h = h.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x;}
}
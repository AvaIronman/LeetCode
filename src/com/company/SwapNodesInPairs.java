package com.company;

import java.awt.*;

public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class SwapNodesInPairs {
    // 1
    public ListNode swapPairs(ListNode head) {
        ListNode p = new ListNode(0);
        if(head == null || head.next == null) return head;
        p.next = head;
        helper(p);
        return p.next;
    }
    public void helper(ListNode p){
        if(p!=null && p.next!=null && p.next.next !=null){
            ListNode first = p.next;
            ListNode second = p.next.next;
            p.next = second;
            first.next = second.next;
            second.next = first;
            helper(p.next.next);
        }
    }
    // 2
    public ListNode swapPairs2(ListNode head) {
        ListNode p = new ListNode(0);
        if(head == null || head.next == null) return head;
        p.next = head;
        ListNode dummy = p;
        while(p!=null && p.next!=null && p.next.next !=null){
            ListNode first = p.next;
            ListNode second = p.next.next;
            p.next = second;
            first.next = second.next;
            second.next = first;
            helper(p.next.next);
        }
        return dummy.next;
    }
}



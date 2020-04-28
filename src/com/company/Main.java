package com.company;

import java.util.*;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args){
         System.out.print("Hi\n");
         Solution solution = new Solution();
         List<List<Integer>> nums = asList(asList(1, 2, 3), asList(1, 2, 3),
                asList(1, 2, 3));
         int[] A = {1,0,0,1,0,0,1,0};
         int N = 1000000000;
         int res = (-12)%5;
         ListNode head = new ListNode(1);
         head.next = new ListNode(2);
         head.next.next = new ListNode(3);
         head.next.next.next = new ListNode(4);
         ListNode newHead = solution.swapPairs(head);
         while(newHead != null){
             System.out.print(newHead.val);
             newHead = newHead.next;
         }
//         int res = (int) Math.pow(3,2);
//        List<Integer> res = solution.powerfulIntegers(2,1,10);
         System.out.print(res);
//        System.out.print(Arrays.toString(res.toArray()));
    }

    public static class Solution {

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

    }

    public static class ListNode {
        int val;
        com.company.ListNode next;
        ListNode(int x) { val = x; }
    }
    public static class TrieNode {
        TrieNode[] next;
        Boolean isEnd;
        String word;

        TrieNode() {
            this.next = new TrieNode[26];
            this.isEnd = false;
        }
    }

    public static class Trie {
        TrieNode root;

        Trie() {
            this.root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode cur = this.root;
            for (char c : word.toCharArray()) {
                if (cur.next[c - 'a'] == null) {
                    cur.next[c - 'a'] = new TrieNode();
                }
                cur = cur.next[c - 'a'];
            }
            cur.isEnd = true;
            cur.word = word;
        }

        public String findPrefix(String word) {
            TrieNode cur = this.root;
            for (char c : word.toCharArray()) {
                if (cur.isEnd)
                    return cur.word;
                if (cur.next[c - 'a'] == null)
                    return "";
                cur = cur.next[c - 'a'];
            }
            return "";
        }
    }
}
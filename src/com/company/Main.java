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
         ListNode head = new ListNode(1);
         head.next = new ListNode(2);
         head.next.next = new ListNode(3);
         head.next.next.next = new ListNode(4);
         int res = solution.findComplement(13);

//         int res = (int) Math.pow(3,2);
//        List<Integer> res = solution.powerfulIntegers(2,1,10);
         System.out.print(res);
//        System.out.print(Arrays.toString(res.toArray()));
    }

    public static class Solution {

        public int findComplement(int num) {
            int res=0, i=0, r=0;
            while(num > 0){
                r = num%2;
                num = (int) (num/2);
                r = r*(-1)+1;
                res += r*Math.pow(2, i);
                i++;
            }
            return res;
        }


    }

    public static class ListNode {
        int val;
        ListNode next;
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
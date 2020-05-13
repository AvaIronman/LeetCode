package com.company;

import java.util.*;

import static java.util.Arrays.asList;

public class Main {

    public static void main(String[] args){
         System.out.print("Hi\n");
         Solution solution = new Solution();
//         List<List<Integer>> nums = asList(asList(1, 2, 3), asList(1, 2, 3),
//                asList(1, 2, 3));
         int[] A = {1,0,0,1,0,0,1,0};
         int N = 1000000000;
         ListNode head = new ListNode(1);
         head.next = new ListNode(2);
         head.next.next = new ListNode(3);
         head.next.next.next = new ListNode(4);
         int[] target = {1,2};
         int[] nums = {1,1,2,3,3,4,4,8,8};
//         List<String> res = solution.buildArray(target, 4);

         int res = solution.singleNonDuplicate(nums);
//        List<Integer> res = solution.powerfulIntegers(2,1,10);
         System.out.print(res);
//          System.out.print(Arrays.toString(res.toArray()));
    }

    public static class Solution {

        public int singleNonDuplicate(int[] nums) {
            int l = 0, r = nums.length-1;
            int idx = nums.length/2;
            if(idx == 0) return nums[0];
            while(true){
                if(idx-l == 1){
                    if(nums[idx]==nums[l])
                        return nums[r];
                    else return nums[l];
                }
                if((idx-l)%2 == 0){
                    if(nums[idx]==nums[idx-1]){
                        r = idx;
                    }else{
                        l = idx;
                    }
                }else{
                    if(nums[idx] != nums[idx-1]){
                        r = idx-1;
                    }else{
                        l = idx+1;
                    }
                }

                idx = (r+l)/2;
            }
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
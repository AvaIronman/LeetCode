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
//         int res = (int) Math.pow(3,2);
//        List<Integer> res = solution.powerfulIntegers(2,1,10);
         System.out.print(res);
//        System.out.print(Arrays.toString(res.toArray()));
    }

    public static class Solution {
         public List<Integer> powerfulIntegers(int x, int y, int bound) {
             HashSet<Integer> set = new HashSet<>();
             int X, Y;
             if(x == 0 || x == 1) X = 0;
             else X = (int)(Math.log(bound)/Math.log(x));
             if(y == 0 || y == 1) Y = 0;
             else Y = (int)(Math.log(bound)/Math.log(y));
             for(int i=0;i<=X;i++){
                 for(int j=0;j<=Y;j++){
                     int res = (int)(Math.pow(x,i)+Math.pow(y,j));
                     if(res<=bound) set.add(res);
                 }
             }
             List<Integer> res = new ArrayList<>(set);
             return res;
        }
        public boolean noDuplicate(List<int[]> myList){
             if(myList.size() <= 1) return true;
             int[] last = myList.get(myList.size()-1);
             for(int i=0;i<2;i++){
                 int[] tmp = myList.get(i);
                 int cnt = 0;
                 for(int j=0;j<8;j++){
                     if(tmp[j] != last[j])
                         break;
                     cnt++;
                 }
                 if(cnt == 8) return false;
             }
             return true;
        }


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
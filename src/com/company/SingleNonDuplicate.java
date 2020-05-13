package com.company;

public class SingleNonDuplicate {
    //
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

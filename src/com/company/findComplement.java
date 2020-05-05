package com.company;

public class findComplement {
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

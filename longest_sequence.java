package com.company;

import java.util.*;


public class Main {

    public static void main(String[] args) {
        int [] A = {7, 6, 100, 4, 200, 1, 3, 2, 5};

        longestConsecutive(A);
    }



    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int longestConsecutive(final int[] A) {

        HashSet < Integer > myhash = new HashSet< Integer >();
        int maxlen = 1; /* one number is always there */

        /* 1. Copy values into hash set, in order to perform O(1) lookups */
        for (int i=0; i<A.length; i++) {
            myhash.add(A[i]);
        }
        System.out.println("Hash = " +myhash);

        /* 2. Walk through all elements of the array and look left
        and right for consecutive values, then delete processed
         items in order to keep future lookups lower, to reach O(n) */
        for (int i=0; i<A.length; i++) {
            int num = A[i];
            int count = 1; // this number itself

            /* Look to the left */
            while(myhash.contains(--num)) {
                count++;
                myhash.remove(num);
            }
            num = A[i]; // reset search
            /* Look to the right */
            while(myhash.contains(++num)) {
                count++;
                myhash.remove(num);
            }
            myhash.remove(A[i]);

            /* Update max consecutive length */
            maxlen = (count > maxlen ? count : maxlen);
        }

        System.out.println("Max consecutive length is " + maxlen);


        return maxlen;
    }

}


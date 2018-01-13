package com.company;

public int kthsmallest(final int[] A, int B) {

        int min;
        int count = 0, totalCount = 0, lastMin = -1;

        do {
        min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {

        if (min > A[i] && A[i] > lastMin) {
        min = A[i];
        count = 1;
        } else if (min == A[i]) {
        count++;
        }

        //System.out.println("A[" + i + "]=" + A[i] + ", count =" + count);

        }
        totalCount += count;
        count = 0; //reset counter
        //System.out.println("totalCount="+totalCount);

        if (lastMin == min) {
        break; // Did not find new minimum
        }
        lastMin = min;

        if (B <= totalCount) {
        //System.out.println("LastMin="+lastMin);
        return lastMin;
        }

        //System.out.println("lastmin = " + lastMin);

        } while (true);

        return lastMin;
}

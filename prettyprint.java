package com.company;

public static ArrayList<ArrayList<Integer>> prettyPrint(int A) {

        ArrayList<ArrayList<Integer>> myArrayList = new ArrayList<ArrayList<Integer>>(A);

        int n = A * 2 - 1; //size of array


        int[][] myArrayInt = new int[n][n];

        int columnFirst = 0, columnLast = n - 1, rowFirst = 0, rowLast = n - 1;


        while (A >= 1) {

        for (int i = columnFirst; i <= columnLast; i++) {
        myArrayInt[rowFirst][i] = A;
        }
        for (int j = rowFirst + 1; j <= rowLast; j++) {
        myArrayInt[j][columnLast] = A;
        }
        for (int i = columnLast - 1; i >= columnFirst; i--) {
        myArrayInt[rowLast][i] = A;
        }
        for (int j = rowLast - 1; j >= rowFirst + 1; j--) {
        myArrayInt[j][columnFirst] = A;
        }
        columnFirst++;
        columnLast--;
        rowFirst++;
        rowLast--;

        A--;

        }

        for (int i = 0; i < myArrayInt.length; i++) {
        for (int j = 0; j < myArrayInt[i].length; j++) {
        System.out.print(myArrayInt[i][j] + " ");
        }
        System.out.println();
        }

        for (int i = 0; i < myArrayInt.length; i++) {
        myArrayList.add(new ArrayList<Integer>());
        for (int j = 0; j < myArrayInt[0].length; j++) {
        myArrayList.get(i).add(myArrayInt[i][j]);
        }
        }

        return myArrayList;
}

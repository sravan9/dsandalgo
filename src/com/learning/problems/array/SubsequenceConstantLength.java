package com.learning.problems.array;

import com.learning.datastructures.FenwickTree;
import com.learning.generic.NormalisedArray;

import java.util.Arrays;
import java.util.List;

//Problem: https://www.spoj.com/problems/INCDSEQ/
public class SubsequenceConstantLength {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3,2,1,5,6,4);
        NormalisedArray<Integer> normalisedArray = new NormalisedArray<>(list);
        Integer[] indexArray = normalisedArray.getNormalisedArray();

        int k = 3;

        //Fenwick Tree array initialisation
        FenwickTree[] fenwickTrees = new FenwickTree[k+1];
        for (int i = 1; i<k+1; i++) {
            fenwickTrees[i] = new FenwickTree(list.size());
        }


        int[][] dp = new int[list.size()][k+1];

        for (int i = 0; i<list.size(); i++) {
            dp[i][1] = 1;
            fenwickTrees[1].update(indexArray[i], 1);
            for (int j = 2; j<k+1; j++) {
                dp[i][j] = fenwickTrees[j-1].getSum(indexArray[i]-1);
                fenwickTrees[j].update(indexArray[i], dp[i][j]);
            }
        }

        for (int i = 0; i<list.size(); i++) {
            for (int j = 1; j<k+1;j++) {
                System.out.print(dp[i][j]+ " ");
            }
            System.out.println();
        }

        System.out.println("---------Total count-------");
        int max = Integer.MIN_VALUE;
        for (int i=0;i<list.size();i++) {
            max = Integer.max(dp[i][k], max);
        }

        System.out.println(max);
    }
}

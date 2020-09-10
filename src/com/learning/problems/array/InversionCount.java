package com.learning.problems.array;

import com.learning.datastructures.FenwickTree;
import com.learning.generic.NormalisedArray;

import java.util.Arrays;
import java.util.List;

//Problem: https://www.codechef.com/problems/DYNAINV
//Reference: https://iq.opengenus.org/count-inversions-in-an-array-using-fenwick-tree/
//Inversion count using fenwick/binaryIndex tree
public class InversionCount {

    public static void main(String[] args) {
        List<Integer> originalArray = Arrays.asList(1, -9, 5, 4, 3);

        //Index Array is nothing but bounding the original array values from 0...N
        NormalisedArray<Integer> normalisedArray = new NormalisedArray<>(originalArray);
        Integer[] indexArray = normalisedArray.getNormalisedArray();
        for (int i=0;i<indexArray.length;i++) {
            System.out.println(indexArray[i] + ", " + originalArray.get(i));
        }


        int output = 0;
        FenwickTree fenwickTree = new FenwickTree(originalArray.size());
        for (int i=indexArray.length-1; i>=0;i--) {
            output += fenwickTree.getSum(indexArray[i]);
            fenwickTree.update(indexArray[i], 1);
        }

        System.out.println(output);
    }
}

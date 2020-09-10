package com.learning.datastructures;

public class FenwickTree {
    private int[] treeArray;
    private final int size;

    public FenwickTree(int n) {
        this.size = n+1;
        treeArray = new int[this.size];
    }

    public int getSum(int index) {
        index++;
        int sum = 0;
        while (index > 0) {
            sum += treeArray[index];
            index -= lsb(index);
        }

        return sum;
    }

    public void update(int index, int value) {
        index++;
        while(index < this.size) {
            treeArray[index] += value;
            index += lsb(index);
        }
    }

    public int lsb(int index) {
        return index & -index;
    }
}

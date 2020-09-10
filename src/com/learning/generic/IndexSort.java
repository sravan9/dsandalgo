package com.learning.generic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class IndexSort<T extends Comparable<T>> implements Comparator<Integer> {
    private final List<T> originalList;
    private Integer[] indexArray;

    public IndexSort(List<T> originalList) {
        this.originalList = originalList;
        indexArray = new Integer[this.originalList.size()];
        for (int i=0; i<this.originalList.size();i++) {
            indexArray[i] = (Integer) this.originalList.get(i);
        }
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        return (o1).compareTo(o2);
    }

    public void sort() {
        Arrays.sort(indexArray, this);
    }

    public Integer[] getIndexArray() {
        return this.indexArray;
    }
}

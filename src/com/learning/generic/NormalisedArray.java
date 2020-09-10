package com.learning.generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//This normalisation only works for unique elements
public class NormalisedArray<T extends Comparable> {
    private final List<T> originalArray;
    private List<T> sortedArray = new ArrayList<>();

    public NormalisedArray(List<T> originalArray) {
        this.originalArray = originalArray;
        for (T t : originalArray) {
            sortedArray.add(t);
        }
    }

    public Integer[] getNormalisedArray() {
        Collections.sort(sortedArray);
        Map<T, Integer> map = new HashMap<>();
        int count = 0;
        for (T t : sortedArray) {
            map.put(t, count++);
        }

        Integer[] normalisedArray = new Integer[sortedArray.size()];
        for (int i=0; i<normalisedArray.length;i++) {
            normalisedArray[i] = map.get(originalArray.get(i));
        }

        return normalisedArray;
    }
}

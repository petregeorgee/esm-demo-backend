package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntegerSortService {

    public void quickSort(List<Integer> array, int low, int high) {
        if (array == null || array.isEmpty()) {
            throw new IllegalArgumentException("Input list cannot be null or empty");
        }

        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private int partition(List<Integer> array, int low, int high) {
        int pivot = array.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array.get(j) < pivot) {
                i++;
                swapElements(array, i, j);
            }
        }
        swapElements(array, i + 1, high);
        return i + 1;
    }

    private void swapElements(List<Integer> array, int i, int high) {
        int temp = array.get(i);
        array.set(i, array.get(high));
        array.set(high, temp);
    }
}

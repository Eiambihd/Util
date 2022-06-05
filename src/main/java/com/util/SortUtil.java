package com.util;

import java.util.Random;

public class SortUtil {

    public static void main(String[] args) {
        int arr[] = new int[20000000];
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            arr[i] = random.nextInt(100000)+random.nextInt(10000)+random.nextInt(1000)+random.nextInt(100)+random.nextInt(10);
        }
        int sortedArr[] = mergeSort(arr, arr.length);

    }
    // 归并排序
    public static int[] mergeSort(int[] arr, int size) {
        if (size == 1) {
            return arr;
        } else {
            int leftSize;
            int rightSize;
            if (size % 2 == 0) {
                leftSize = size / 2;
                rightSize = size / 2;
            } else {
                leftSize = size / 2;
                rightSize = size / 2 + 1;
            }
            int leftArr[] = new int[leftSize];
            int rightArr[] = new int[rightSize];
            for (int i = 0; i < size; i++) {
                if (i < leftSize) {
                    leftArr[i] = arr[i];
                } else {
                    rightArr[i - leftSize] = arr[i];
                }
            }
            int sortedLeftArr[] = mergeSort(leftArr, leftSize);
            int sortedRightArr[] = mergeSort(rightArr, rightSize);
            int li = 0;
            int ri = 0;
            int resultArr[] = new int[size];
            for (int i = 0; i < size; i++) {

                if (li < leftSize && ri < rightSize && sortedLeftArr[li] < sortedRightArr[ri]) {
                    resultArr[i] = sortedLeftArr[li];
                    li++;
                    continue;
                }
                if (li < leftSize && ri < rightSize && sortedLeftArr[li] >= sortedRightArr[ri]) {
                    resultArr[i] = sortedRightArr[ri];
                    ri++;
                    continue;
                }
                if (li == leftSize && ri < rightSize) {
                    resultArr[i] = sortedRightArr[ri];
                    ri++;
                    continue;
                }
                if (ri == rightSize && li < leftSize) {
                    resultArr[i] = sortedLeftArr[li];
                    li++;
                    continue;
                }
            }
            return resultArr;
        }
    }

}

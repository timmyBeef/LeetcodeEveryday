package sort;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int ary[], int left, int right) {
        if (right == left) return;
        int mid = (left + right) >> 1;
        mergeSort(ary, left, mid);
        mergeSort(ary, mid + 1, right);
        merge(ary, left, mid, right);
    }

    public static void merge(int ary[], int left, int mid, int right) {
        int temp[] = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            temp[k++] = ary[i] < ary[j] ? ary[i++] : ary[j++];
        }
        while (i <= mid) temp[k++] = ary[i++];
        while (j <= right) temp[k++] = ary[j++];

        for (int p = 0; p < temp.length; p++) {
            ary[left + p] = temp[p];
        }
    }

    public static void main(String[] args) {
        int ary[] = new int[]{5, 3, 7, 9, 2, 5};
        MergeSort.mergeSort(ary, 0, ary.length-1);
        System.out.println(Arrays.toString(ary));
    }
}

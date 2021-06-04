package leetcode.mergesort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    315
    https://app.gitbook.com/@timmybeeflin/s/cracking-leetcode/merge-sort-realated/315.-count-of-smaller-numbers-after-self
    use MergeSort idea + val idx object

    Time: O(nlogn)
    space: O(n)
 */
public class CountOfSmallerNumbersAfterSelf {
    private class Item {
        int val;
        int idx;

        public Item(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "val=" + val +
                    ", idx=" + idx +
                    '}';
        }
    }

    public List<Integer> countSmaller(int[] nums) {

        int n = nums.length;
        int[] count = new int[n];
        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            items[i] = new Item(nums[i], i);
        }

        mergeSort(items, 0, n - 1, count);

        List<Integer> result = new ArrayList<>();
        for (int cnt : count) {
            result.add(cnt);
        }

        return result;

    }

    private void mergeSort(Item[] items, int left, int right, int[] count) {

        if (left >= right) return;

        int mid = (right + left) >> 1;
        System.out.println("mid:" + mid);
        mergeSort(items, left, mid, count);
        mergeSort(items, mid + 1, right, count);
        merge(items, left, mid, right, count);

    }

    private void merge(Item[] items, int left, int mid, int right, int[] count) {
        System.out.println("left:" + left + ", mid:" + mid + ", right:" + right);

        Item[] temp = new Item[right - left + 1];
        int tempIdx = 0;

        int lowPtr = left;
        int hiPtr = mid + 1;
        int rightCount = 0;

        while (lowPtr <= mid && hiPtr <= right) {
            System.out.println("l:" + lowPtr + ", r:" + hiPtr);

            if (items[lowPtr].val > items[hiPtr].val) {
                rightCount++;
                temp[tempIdx++] = items[hiPtr++];
                printTemp(temp, tempIdx, rightCount);
                System.out.println("\n");
            } else {
                count[items[lowPtr].idx] += rightCount;
                System.out.println("items[l].idx" + items[lowPtr].idx);
                System.out.println("rightCount else: " + rightCount);
                temp[tempIdx++] = items[lowPtr++];
            }
            System.out.println("first while: ");
        }

        while (lowPtr <= mid) {
            count[items[lowPtr].idx] += rightCount;
            temp[tempIdx++] = items[lowPtr++];
            System.out.println("second while: ");
            printTemp(temp, tempIdx, rightCount);

        }

        while (hiPtr <= right) {
            temp[tempIdx++] = items[hiPtr++];
            System.out.println("third while: ");
            printTemp(temp, tempIdx, rightCount);
        }

        for (int i = 0; i < temp.length; i++) {
            items[left + i] = temp[i];
        }
        System.out.println("finished: left=" + left + ", mid=" + mid + "right=" + right);
        StringBuilder sb = new StringBuilder();
        StringBuilder countSb = new StringBuilder();

        for (int i = 0; i < items.length; i++) {
            sb.append(items[i].toString() + ", ");
            countSb.append(count[i] + ", ");
        }
        System.out.println("items: "+ sb.toString());
        System.out.println("count: "+ countSb.toString());
        System.out.println("\n");

    }

    private void printTemp(Item[] temp, int tempIdx, int rightCount) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tempIdx; i++) {
            sb.append(temp[i].toString() + ", ");
        }
        System.out.println("rightCount: " + rightCount);
        System.out.println("temp: " + sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(new CountOfSmallerNumbersAfterSelf().countSmaller(new int[]{5, 2, 1}));
    }
}


package leetcode.kth;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/k-closest-points-to-origin/
public class KClosestPointsToOrigin {

    // O(NlogN)
    // O(N)
    public int[][] kClosestBySort(int[][] points, int K) {
        Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
        return Arrays.copyOfRange(points, 0, K);
    }

    // O(NlogK)
    // O(N)
    public int[][] kClosestByMaxHeap(int[][] points, int K) {

        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] left, int[] right) { // 注意, 要右減左
                return getDistance(right) - getDistance(left);
            }
        });

        for (int[] point: points) {
            heap.add(point);
            if (heap.size() > K)
                heap.poll();
        }

        int[][] result = new int[K][2];
        for(int i =0; i < K; i++) {
            result[i] = heap.poll();
        }

        return result;

    }

    private int getDistance(int [] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    // Theoretically, the average time complexity is O(N) ,
    // but just like quick sort, in the worst case,
    // this solution would be degenerated to O(N^2), and pratically,
    // the real time it takes on leetcode is 15ms.
    // O(N)
    public int[][] kClosestByQuickSelect(int[][] points, int K) {
        int len =  points.length, l = 0, r = len - 1;
        while (l <= r) {
            int mid = helper(points, l, r); //取得pivot: middle
            if (mid == K) break;
            if (mid < K) { // 我們需要k個, 所以要調整pivot的位置
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    private int helper(int[][] A, int l, int r) {
        int[] pivot = A[l]; // 以l index 為 pivot
        while (l < r) {

            // right 比 pivot 大於等於0時, 繼續走訪 r-- (正確的), 小於時 停下, 對調
            while (l < r && compare(A[r], pivot) >= 0) r--;
            A[l] = A[r];

            // left 比 pivot 小於等於0時, 繼續走訪 l++ (正確的), 大於時 停下, 對調
            while (l < r && compare(A[l], pivot) <= 0) l++;
            A[r] = A[l];
        }
        // left 設為 pivot, 回傳 l (新的 pivot index)
        A[l] = pivot;
        return l;
    }

    private int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }

    public int[][] kClo(int[][] points, int K) {
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int p1[], int p2[]) {
                return getDist(p2) - getDist(p1);
            }
        });

        for(int p[] : points) {
            heap.add(p);
            if(heap.size() > K) {
                heap.poll();
            }
        }

        int result[][] = new int[K][2];
        for(int i = 0; i < K ;i++) {
            result[i] = heap.poll();
        }

        return result;
    }


    private int getDist(int [] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    public static void main(String[] args) {
        // points[0] = {3,3}, points[1] = {5,-1}, points[2]= {-2,4}
        int points[][] = {{3,3},{5,-1},{-2,4}};
        int k = 2;

        // System.out.println(Arrays.toString(points[0]));


        int rs[][] = new KClosestPointsToOrigin().kClosestByQuickSelect(points, k);

        for(int r[] : rs) {
            System.out.println(Arrays.toString(r));
        }

        System.out.println("=========max heap=========");

        int rs2[][] = new KClosestPointsToOrigin().kClo(points, k);

        for(int r[] : rs2) {
            System.out.println(Arrays.toString(r));
        }
    }
}

package leetcode.unionfind;

/*
    547
    https://app.gitbook.com/@timmybeeflin/s/cracking-leetcode/union-find/547.-number-of-provinces

    time: O(edges*nodes)
    space: O(n)
 */
public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        // use union find
        int n = isConnected.length;

        int res = n;
        int roots[] = new int[n];
        for (int i = 0; i < n; i++) { // init
            roots[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1) { // union part
                    int x = find(roots, i);
                    int y = find(roots, j);
                    if (x != y) {
                        roots[x] = y;
                        res--;
                    }
                }

            }
        }
        return res;
    }
    private int find(int[] roots, int i) { //find part
        while (roots[i] != -1) {
            i = roots[i];
        }
        return i;
    }
}


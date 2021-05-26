package leetcode.unionfind;

/*
    323
    https://app.gitbook.com/@timmybeeflin/s/cracking-leetcode/union-find/323.-number-of-connected-components-in-an-undirected-graph

    time: O(edges * n)
    space: O(n)
 */
public class NumberOfConnectedUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        if (edges == null || edges.length == 0) return n;
        int res = n;

        int roots[] = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = -1;
        }
        for (int[] edge : edges) {
            int x = unionFind(roots, edge[0]);
            int y = unionFind(roots, edge[1]);
            if (x != y) {
                roots[x] = y;
                res--;
            }
        }
        return res;
    }

    private int unionFind(int roots[], int i) {
        while (roots[i] != -1) {
            i = roots[i];
        }
        return i;
    }
}

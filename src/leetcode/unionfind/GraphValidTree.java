package leetcode.unionfind;

/*
    261

    edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]

           3
          /
         2
        /
       1
      /
    0



         2
        /  \
       1 - 3    => gen cycle,  the root are the same
      /  \
    0     4


    time: O(edges*nodes)
    space: O(n)
 */
public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {

        if (edges == null || edges.length != n - 1) return false;

        // union find
        int root[] = new int[n];
        for (int i = 0; i < n ; i++) {
            root[i] = -1;
        }

        for (int[] e : edges) {
            int x = unionFind(root, e[0]);
            int y = unionFind(root, e[1]);
            if (x == y) return false;
            root[x] = y; // 0 -> 1
        }
        return true;
    }
    private int unionFind(int root[], int i) {
        while (root[i] != -1) {
            i = root[i];
        }
        return i;
    }
}

package leetcode;


import java.util.*;

/*
https://leetcode.com/problems/accounts-merge/

draw edges between emails if they occur in the same account.
For easier interoperability between our DSU template,
we will map each email to some integer index by using "emailToID".
用 int index 去 map email : emailToID

Then, dsu.find(email) will tell us a unique id representing what component that email is in.
dsu.find(email) 找到老大


Time Complexity: O(AlogA), where
​
A = ai和
ai is the length of accounts[i]. If we used union-by-rank,
this complexity improves to O(A \alpha(A)) \approx O(A)O(Aα(A))≈O(A), where \alphaα is the Inverse-Ackermann function.


for (List<String> account: accounts) { // O(A)
  union // O(logA) , union-by-rank => O(α(N)) => O(1)
}

Outside the scope of this article, it can be shown why
dsu.union has O(α(N)) complexity, what the Inverse-Ackermann function is,
and why O(α(N)) is approximately O(1).

Space Complexity: O(A), the space used by our DSU structure.

use dsu
        DSU dsu = new DSU();
        build
        Map<String, String> emailToName = new HashMap();
        Map<String, Integer> emailToID = new HashMap();
dsu.union(first email, every email);

use emailToName and dsu.find to group result into
        Map<Integer, List<String>> ans = new HashMap();

sort email and set name
        for (List<String> component : ans.values()) {
            Collections.sort(component);
            component.add(0, emailToName.get(component.get(0)));
        }

return result

        return new ArrayList(ans.values());
*/


public class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DSU dsu = new DSU();
        Map<String, String> emailToName = new HashMap();
        Map<String, Integer> emailToID = new HashMap();

        int id = 0;
        // 建立樹
        for (List<String> account : accounts) {
            String name = "";
            for (String email : account) {
                if (name == "") { // first in, get name, others not, name 在第一個位置
                    name = email;
                    continue;
                }
                emailToName.put(email, name);

                if (!emailToID.containsKey(email)) { //!!
                    emailToID.put(email, id++);
                }

                // 連起來 (id, id), parent[find(id1)] = find(id2)

                /*
                    List<List<String>> input = Arrays.asList(
                        Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                        Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                        Arrays.asList("Mary", "mary@mail.com")
                    );
                 */

                // emailToName:
                // [{johnsmith@mail.com=John, john00@mail.com=John, john_newyork@mail.com=John, mary@mail.com=Mary}]

                // emailToID:
                // [{johnsmith@mail.com=0, john00@mail.com=1, john_newyork@mail.com=2, mary@mail.com=3}]

                //  dsu.union(emailToID.get(account.get(1)) = 0 , emailToID.get(emailToID.get(email)) = 1)
                // emailToID.get(account.get(1)) = 0, emailToID.get(email)) = 1

                // dsu.union(0, 1) do
                // parent[find(0)] = find(1)    => p[0] = 1
/*
                 1
                /
                0

                //  dsu.union(account.get(1) = 0 , emailToID.get(email) = 2)
                // parent[find(0)] = find(2)     => p[1] = 2
                         2
                         /
                         1
                        /
                        0

                //  dsu.union(account.get(1) = 3 , emailToID.get(email) = 3)
                // parent[find(3)] = find(3)      => p[3] = 3

                         2
                        /
                        1      3
                        /
                        0
                       List<List<String>> input = Arrays.asList(
                        Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                        Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                        Arrays.asList("Mary", "mary@mail.com")
*/
            // (孩子, 爸爸), 因為都有 johnsmith@mail.com=0 這個 COMMON, 所以最後會成一團
                dsu.union(emailToID.get(account.get(1)), emailToID.get(email)); //建UNION
            }
        }


        // emailToName:
        // [{johnsmith@mail.com=John, john00@mail.com=John, john_newyork@mail.com=John, mary@mail.com=Mary}]

        // emailToID:
        // [{johnsmith@mail.com=0, john00@mail.com=1, john_newyork@mail.com=2, mary@mail.com=3}]

        // 把 DSU 分群後的結果塞到 map
        Map<Integer, List<String>> ans = new HashMap();
        for (String email : emailToName.keySet()) {

            // 找 root idx, 看是否可以找到同個爸爸
            int index = dsu.find(emailToID.get(email));

            // 存在  此 index的話, ans map用 此index 取得的 list 加 email, 存回
            // 不存在此 index的話, ans map 存入 (new list 放入 email)
            // ans.computeIfAbsent(index, x -> new ArrayList()).add(email);
            if(ans.containsKey(index)) {
                ans.get(index).add(email);
            } else {
                List<String> list = new ArrayList<>();
                list.add(email);
                ans.put(index,list);
            }
        }

        // 分群後, 加上 name 到第一位
        // the first element of each account is the name,
        // and the rest of the elements are emails in sorted order.
        for (List<String> component : ans.values()) {
            Collections.sort(component);
            component.add(0, emailToName.get(component.get(0))); //get emailToName's name
        }
        return new ArrayList(ans.values());
    }


    public static void main(String args[]) {
        /*
                        2
                        /
                       1      3
                       /
                      0
         */
        List<List<String>> input = Arrays.asList(
                Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                Arrays.asList("Mary", "mary@mail.com")
        );
/*
        List<List<String>> input = Arrays.asList(
                Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                Arrays.asList("John", "john_newyork@mail.com", "johnsmith@mail.com"),
                Arrays.asList("Mary", "mary@mail.com")
        );

                         1
                        /
                        0     3
                       /
                      2

*/
        List<List<String>> output = new AccountsMerge().accountsMerge(input);

        output.stream().forEach(list -> System.out.println(list.toString()));


    }
}
/*
    IF TWO'S parent is the same, they are in same group
 */
class DSU {
    int[] parent;

    public DSU() {
        parent = new int[10001];
        for (int i = 0; i <= 10000; ++i)
            parent[i] = i;
    }

    // 找尋 root
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    /*      y
           /
          x

     */
    // x's root's parent = y's root
    public void union(int x, int y) {

        parent[find(x)] = find(y);
    }
}

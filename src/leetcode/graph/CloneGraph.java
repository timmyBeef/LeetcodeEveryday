package leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/clone-graph/

/*

use hashmap

if cloned

  return map's node

if not

  create new node, and put it to map

Given a reference of a node in a connected undirected graph,
return a deep copy (clone) of the graph. Each node in the graph
contains a val (int) and a list (List[Node]) of its neighbors.

USE DFS,
use HashMap<Integer, Node> to record has cloned node

if(map.containsKey(node value)) {
    return map.get(node value);
}
Node newNode = ...
map.put()

for(Node neighbor : node.neighbors) {
    newNode.neighbors.add(clone(neighbor))
}
return newNode
 */

public class CloneGraph {
    public HashMap<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {

        return clone(node);
    }

    public Node clone(Node node) {
        if (node == null) return null;

        // clone過了 直接回傳
        if (map.containsKey(node.val))
            return map.get(node.val);

        // clone a new node
        Node newNode = new Node(node.val, new ArrayList<Node>()); //!!!
        map.put(newNode.val, newNode); // clone 過要放入 map

        // clone neighbors
        for (Node neighbor : node.neighbors)
            newNode.neighbors.add(clone(neighbor)); //!!!
        return newNode;
    }
}

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};


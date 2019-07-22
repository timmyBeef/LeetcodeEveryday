package leetcode.trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

use dfs or bfs

The idea is simple: print the tree in pre-order traversal and use "X" to
denote null node and split node with ",". We can use a StringBuilder for
building the string on the fly. For deserializing, we use a Queue to store
the pre-order traversal and since we have "X" as null node, we know exactly
how to where to end building subtress.

You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"

Serialize:
       private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(SPLITER);
        } else {
            sb.append(node.val).append(SPLITER);
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
       }

deSerialize: 用 Queue
        Queue<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(SPLITER)));

        then buildTree(node)

        String val = nodes.poll();
        if (val.equals(NN)) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }

Time complexity : in both serialization and deserialization functions,
        we visit each node exactly once, thus the time complexity is O(N),
        where N is the number of nodes, i.e. the size of tree.

Space complexity : in both serialization and deserialization functions,
        we keep the entire tree, either at the beginning or at the end,
        therefore, the space complexity is O(N).
*/
public class SerializeAndDeserializeBinaryTree {
    private static final String SPLITER = ",";
    private static final String NN = "XX";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(SPLITER);
        } else {
            sb.append(node.val).append(SPLITER);
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(SPLITER)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Queue<String> nodes) {
        String val = nodes.poll();
        if (val.equals(NN)) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }

    public static void main(String[] args) {
/*        You may serialize the following tree:

                 1
                / \
               2   3
                  / \
                 4   5

        as "[1,2,3,null,null,4,5]"
*/
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;

        String serializedStr = new SerializeAndDeserializeBinaryTree().serialize(n1);
        System.out.println(serializedStr);

        TreeNode deserializedNode = new SerializeAndDeserializeBinaryTree().deserialize(serializedStr);

        String afterDeserializedStr = new SerializeAndDeserializeBinaryTree().serialize(deserializedNode);
        System.out.println(afterDeserializedStr);
    }
}

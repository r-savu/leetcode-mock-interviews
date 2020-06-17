/*
  Given the root of a binary tree, consider all root to leaf paths: paths from the root to any leaf.  (A leaf is a node with no children.)

  A node is insufficient if every such root to leaf path intersecting this node has sum strictly less than limit.

  Delete all insufficient nodes simultaneously, and return the root of the resulting binary tree.

  Example 1:
               1
            /     \
        2            3
      /   \         /  \
    4     -99   -99      7
   / \    /  \   / \    / \
  8   9 -99 -99 12 13 -99 14

  Input: root = [1,2,3,4,-99,-99,7,8,9,-99,-99,12,13,-99,14], limit = 1

        1
       / \
      2   3
     /     \
    4       7
   / \       \
  8   9      14
  Output: [1,2,3,4,null,null,7,8,9,null,14]

  Example 2:
       5
      / \
     4   8
    /   / \
   11  17  4
   / \    / \
  7   1  5   3

  Input: root = [5,4,8,11,null,17,4,7,1,null,null,5,3], limit = 22

        5
       / \
      4   8
     /   / \
    11  17  4
    /      /
   7      5
  Output: [5,4,8,11,null,17,4,7,null,null,null,5]

  Example 3:

        1
       / \
      2  -3
     /   /
   -5   4

  Input: root = [1,2,-3,-5,null,4,null], limit = -1

    1
     \
     -3
     /
    4
  Output: [1,null,-3,4]

  Note:

  The given tree will have between 1 and 5000 nodes.
  -10^5 <= node.val <= 10^5
  -10^9 <= limit <= 10^9*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private boolean isSufficient(TreeNode node, int limit, int sumToNode) {
        if (node.left == null && node.right == null) {
            return sumToNode + node.val >= limit;
        }
        boolean left = false;
        boolean right = false;
        if (node.left != null) {
            left = isSufficient(node.left, limit, sumToNode + node.val);
        }
        if (node.right != null) {
            right = isSufficient(node.right, limit, sumToNode + node.val);
        }

        return left || right;
    }

    private TreeNode sufficientSubset(TreeNode root, int limit, int sumToNode){
        if (root == null) return null;
        if (!isSufficient(root, limit, sumToNode)) return null;
        root.left = sufficientSubset(root.left, limit, sumToNode + root.val);
        root.right = sufficientSubset(root.right, limit, sumToNode + root.val);
        return root;
    }

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return sufficientSubset(root, limit, 0);
    }
}

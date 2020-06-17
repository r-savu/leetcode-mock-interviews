/*
  Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

  For example:
  Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
  return its level order traversal as:
  [
    [3],
    [9,20],
    [15,7]
  ]*/

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if (root == null) return ret;

        List row = new LinkedList<Integer>();
        ret.add(row);

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur != null) {
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
                if (q.peek() == null) q.add(null);
                row.add(cur.val);
            } else if (q.peek() != null) {
                row = new LinkedList<Integer>();
                ret.add(row);
            }
        }
        return ret;
    }
}

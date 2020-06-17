/*
  Given a Binary Search Tree and a target number, return true if there exist two
  elements in the BST such that their sum is equal to the given target.

  Example 1:

  Input: 
      5
     / \
    3   6
   / \   \
  2   4   7

  Target = 9

  Output: True
 

  Example 2:

  Input: 
      5
     / \
    3   6
   / \   \
  2   4   7

  Target = 28

  Output: False*/

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
    private boolean findTarget(TreeNode n1, TreeNode n2, int k) {
        if (n1 == null || n2 == null) return false;
        if (n1.val + n2.val == k) {
            if (n1 != n2) return true;
            else return findTarget(n1.left, n2.right, k);
        } 
        else if (n1.val + n2.val > k) {
            return findTarget(n1.left, n2, k) || findTarget(n1, n2.left, k);
        }
        else {
            return findTarget(n1.right, n2, k) || findTarget(n1, n2.right, k);
        }
    }
    public boolean findTarget(TreeNode root, int k) {
        return findTarget(root, root, k);
    }
}

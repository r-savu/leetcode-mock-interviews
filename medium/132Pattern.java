/*
  Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj.
  Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.

  Note: n will be less than 15,000.

  Example 1:
  Input: [1, 2, 3, 4]

  Output: False

  Explanation: There is no 132 pattern in the sequence.
  Example 2:
  Input: [3, 1, 4, 2]

  Output: True

  Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
  Example 3:
  Input: [-1, 3, 2, 0]

  Output: True

  Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].*/

class Solution {
    public boolean find132pattern(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            int max = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                }
                if (nums[j] > nums[i] && nums[j] < max) {
                    return true;
                }
            }
        }
        return false;
    }
}

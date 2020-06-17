/*
  Given an array of integers, return indices of the two numbers such that they add up to a specific target.

  You may assume that each input would have exactly one solution, and you may not use the same element twice.

  Example:

  Given nums = [2, 7, 11, 15], target = 9,

  Because nums[0] + nums[1] = 2 + 7 = 9,
  return [0, 1].
*/

class Solution {
    private Map<Integer, Integer> m = new HashMap<>();
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (m.containsKey(n)) {
                return new int[]{m.get(n), i};
            }
            m.put(target - n, i);
        }
        return new int[]{};
    }
}

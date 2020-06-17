/*
  You are given a sorted array consisting of only integers where every element appears exactly twice,
  except for one element which appears exactly once. Find this single element that appears only once.

  Follow up: Your solution should run in O(log n) time and O(1) space.

  Example 1:
  Input: nums = [1,1,2,3,3,4,4,8,8]
  Output: 2

  Example 2:
  Input: nums = [3,3,7,7,10,11,11]
  Output: 10
 

  Constraints:

  1 <= nums.length <= 10^5
  0 <= nums[i] <= 10^5*/

class Solution {
    private int search(int[] nums, int lo, int hi) {
        int mid = (lo + hi) / 2;
        int v = nums[mid];
        int l = nums[mid - 1];
        int r = nums[mid + 1];
        if (v != l && v != r) return v;
        if (mid % 2 == 0) {
            if (v == r) return search(nums, mid, hi);
            else return search(nums, lo, mid);
        } else {
            if (v == l) return search(nums, mid + 2, hi);
            else return search(nums, lo, mid);
        }
        
        
    }
    public int singleNonDuplicate(int[] nums) {
        int l = nums.length;
        if (l == 1 || nums[0] != nums[1]) return nums[0];
        if (nums[l - 1] != nums[l - 2]) return nums[l - 1];
        
        return search(nums, 2, l - 3);
        
    }
}

/*
  Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

  (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

  You are given a target value to search. If found in the array return its index, otherwise return -1.

  You may assume no duplicate exists in the array.

  Your algorithm's runtime complexity must be in the order of O(log n).

  Example 1:

  Input: nums = [4,5,6,7,0,1,2], target = 0
  Output: 4
  Example 2:

  Input: nums = [4,5,6,7,0,1,2], target = 3
  Output: -1*/

class Solution {
    private int search(int[] nums, int target, int lo, int hi) {
        if (lo >= hi) return target == nums[lo] ? lo : -1;

        int mid = (lo + hi) / 2;

        if (target == nums[mid]) return mid;

        if (nums[lo] < nums[hi]) {
            return nums[mid] < target
                ? search(nums, target, mid + 1, hi)
                : search (nums, target, lo, mid - 1);
        }

        if (nums[mid] < nums[hi]) {
            if (target > nums[mid] && target <= nums[hi]) {
                return search(nums, target, mid + 1, hi);
            }
            return search(nums, target, lo, mid -1);
        } else {
            if (target >= nums[lo] && target < nums[mid]) {
                return search(nums, target, lo, mid - 1);
            }
            return search(nums, target, mid + 1, hi);
        }
    }
    public int search(int[] nums, int target) {
        if (nums.length < 1) return -1;
        return search(nums, target, 0, nums.length - 1);
    }
}

/*
  Given a collection of distinct integers, return all possible permutations.

  Example:

  Input: [1,2,3]
  Output:
  [
    [1,2,3],
    [1,3,2],
    [2,1,3],
    [2,3,1],
    [3,1,2],
    [3,2,1]
  ]
*/

class Solution {
    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    private void permute(int[] nums, int k) {
        for (int i = k; i < nums.length; i++) {
            swap(nums, i, k);
            permute(nums, k+1);
            swap(nums, i, k);
        }
        if (k == nums.length - 1) {
            result.add(IntStream.of(nums).boxed().collect(Collectors.toList()));
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        permute(nums, 0);
        return result;
    }
}

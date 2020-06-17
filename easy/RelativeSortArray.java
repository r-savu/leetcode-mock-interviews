/*
  Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

  Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.
  Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.

 

  Example 1:

  Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
  Output: [2,2,2,1,4,3,3,9,6,7,19]
 

  Constraints:

  arr1.length, arr2.length <= 1000
  0 <= arr1[i], arr2[i] <= 1000
  Each arr2[i] is distinct.
  Each arr2[i] is in arr1.*/

class Solution {
    private Map<Integer, Integer> ord;
    
    private void quickSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int pi = partition(arr, lo, hi);
            quickSort(arr, lo, pi - 1);
            quickSort(arr, pi + 1, hi);
        }
    }
    private boolean less(int a, int b) {
        Integer ordA = ord.get(a);
        Integer ordB = ord.get(b);
        if (ordA != null) {
            if (ordB != null) {
                return ordA.compareTo(ordB) < 0;
            }
            return true;
        }
        return a < b;
    }
    private int partition(int[] arr, int lo, int hi) {
        int pivot = arr[hi];
        int i = lo - 1;
        int tmp;
        for (int j = lo; j < hi; j++) {
            if (less(arr[j], pivot)){
                i++;
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        tmp = arr[i + 1];
        arr[i + 1] = arr[hi];
        arr[hi] = tmp;
        return i+1;
        
    }
    
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        ord = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            ord.put(arr2[i], i);
        }
        quickSort(arr1, 0, arr1.length - 1);
        return arr1;
    }
}

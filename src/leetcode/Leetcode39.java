package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode39 {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List< List<Integer>> res = new ArrayList<>();
    getCombiantion(res, new ArrayList<>(), candidates, 0, 0, target);

    return  res;
  }

  public void getCombiantion(List< List<Integer>> res, List<Integer> list, int[] arr, int index, int sum, int target) {
    if (sum > target) {
      return;
    }
    if (sum == target) {
      res.add(new ArrayList<>(list));
      return;
    }
    for (int i = index; i < arr.length; ++i) {
      List<Integer> temp = new ArrayList<>(list);
      temp.add(arr[i]);
      getCombiantion(res, temp, arr, i, sum + arr[i], target);
    }
  }
}

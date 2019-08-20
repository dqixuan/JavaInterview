package leetcode;

import java.util.*;

public class Leetcode46 {
  public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    int[] visited = new int[nums.length];
    getRes(res, new ArrayList<>(), nums, visited);

    return res;
  }
  public static void getRes(List<List<Integer>> res, List<Integer> list, int[] nums, int[] visited) {
    if (list.size() == nums.length) {
      res.add(new ArrayList<>(list));
      return;
    }

    for (int i = 0; i < nums.length; ++i) {
      if (visited[i] == 1) {
        continue;
      }
      visited[i] = 1;
      list.add(nums[i]);
      getRes(res, list, nums, visited);
      visited[i] = 0;
      list.remove(list.size() - 1);
    }
  }
  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    System.out.println(permute(nums));
  }
}

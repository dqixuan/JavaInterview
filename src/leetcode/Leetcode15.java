package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode15 {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums == null || nums.length < 3) {
      return res;
    }

    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; ++i) {
      if (nums[i] > 0) {
        break;
      }
      if (i > 0 && nums[i] == nums[i - 1] ) {
        continue;
      }
      int left = i + 1, right = nums.length - 1;

      while (left < right) {
        if (nums[left] + nums[right] + nums[i] == 0) {
          res.add(Arrays.asList(nums[i], nums[left], nums[right]));
          while (left < right && nums[left] == nums[left + 1] ) {
            left++;
          }
          while (left < right && nums[right] == nums[right - 1]) {
            right--;
          }
          left++;
          right--;
        } else if (nums[left] + nums[right] + nums[i] > 0 ) {
          right--;
        } else {
          left++;
        }
      }
    }

    return res;
  }
}

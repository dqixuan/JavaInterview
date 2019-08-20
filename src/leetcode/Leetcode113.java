package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 说明: 叶子节点是指没有子节点的节点
 */

public class Leetcode113 {
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List< List<Integer> > res = new ArrayList<>();
    getPath(res, new ArrayList<>(), root, sum);
    return res;
  }
  public void getPath(List<List<Integer>> res, List<Integer> list, TreeNode node, int sum) {
    if (node == null) {
      return ;
    }
    list.add(node.val);
    sum -= node.val;

    if (node.left == null && node.right == null) {
      if (sum == 0) {
        res.add(new ArrayList<>(list));
      }
    } else {
      if (node.left != null) {
        getPath(res, list, node.left, sum);
      }
      if (node.right != null){
        getPath(res, list, node.right, sum);
      }
    }
    list.remove(list.size() - 1);
  }
}

package leetcode;

import java.util.LinkedList;

public class Solution {
  public static int countCharacters(String[] words, String chars) {
    if (chars == null || chars.length() == 0) {
      return 0;
    }
    if (words == null || words.length == 0) {
      return 0;
    }
    boolean [] flag = new boolean[words.length];
    int[] tmpArr = new int[128];
    for (int i = 0; i < chars.length(); ++i) {
      tmpArr[chars.charAt(i)]++;
    }
    for (int i = 0; i < words.length; ++i) {
      int[] arr = tmpArr;
      String tmpStr = words[i];
      for (int j = 0; j < tmpStr.length(); ++j) {
        if (arr[tmpStr.charAt(j)] == 0) {
          flag[i] = true;
          break;
        } else {
          arr[tmpStr.charAt(j)]--;
        }
      }
    }
    int len = 0;
    for (int i = 0; i < words.length; ++i) {
      if (!flag[i]) {
        len += words[i].length();
      }
    }
    return len;
  }
  public static void main(String[] args) {
//      String[] arr = {"cat", "bt", "hat", "tree"};
//      String chars = "atach";
//    System.out.println(countCharacters(arr, chars));
    LinkedList<Integer> list = new LinkedList<>();
    list.addLast(1);
    System.out.println(list.removeFirst());
  }
}

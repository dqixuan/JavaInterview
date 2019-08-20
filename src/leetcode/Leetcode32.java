package leetcode;

import java.util.Stack;

public class Leetcode32 {
  public int longestValidParentheses(String s) {
    if (s.length() == 0 || s == null) {
      return 0;
    }
    int len = s.length();
    Stack<Character> stack = new Stack<>();
    char temp = 0;
    for (int i = 0; i < len; ++i) {
      temp = s.charAt(i);
      if (temp == ')') {
        if (!stack.isEmpty() &&stack.peek() == '(') {
          stack.pop();
        } else {
          stack.push(temp);
        }
      } else {
        stack.push(temp);
      }
    }
    return len - stack.size();
  }
}

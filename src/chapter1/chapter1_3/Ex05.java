package chapter1.chapter1_3;

import edu.princeton.cs.algs4.StdOut;

public class Ex05 {
  public static void main(String[] args) {
    int N = 50;
    Stack<Integer> stack = new Stack<Integer>();
    while (N > 0) {
      stack.push(N % 2);
      N = N / 2;
    }

    for (int d : stack) {
      StdOut.print(d);
    }
  }
}

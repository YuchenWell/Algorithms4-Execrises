package chapter1.chapter1_1;

import edu.princeton.cs.algs4.StdOut;

public class Ex20 {
  public static double ln(int N) {
    if (N == 0) {
      return 0;
    } else {
      return Math.log(N) + ln(N - 1);
    }
  }

  public static void main(String[] args) {
    System.out.println(ln(10));
  }
}

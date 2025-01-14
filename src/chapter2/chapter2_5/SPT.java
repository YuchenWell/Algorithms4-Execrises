package chapter2.chapter2_5;

import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

public class SPT {
  public static void main(String[] args) {
    int n = StdIn.readInt();
    Job[] jobs = new Job[n];

    for (int i = 0; i < n; i++) {
      jobs[i] = new Job(StdIn.readString(), StdIn.readDouble());
    }

    Arrays.sort(jobs);

    for (int i = 0; i < n; i++) {
      System.out.println(jobs[i]);
    }
  }
}

package chapter2.chapter2_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.awt.*;

public class Insertion {
  public static void sort(Comparable[] a) {
    int N = a.length;
    for (int i = 1; i < N; i++) {
      for (int j = i; j > 0; j--) {
        if (less(a[j - 1], a[j])) break;
        exch(a, j, j - 1);
      }
    }
  }

  private static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  private static void exch(Comparable[] a, int i, int j) {
    Comparable temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public static boolean isSorted(Comparable[] a) {
    for (int i = 1; i < a.length; i++) {
      if (less(a[i], a[i - 1])) return false;
    }
    return true;
  }

  public static void show(Comparable[] a) {
    for (int i = 0; i < a.length; i++) {
      StdOut.print(a[i] + " ");
    }
    StdOut.println();
  }

  /**
   * Exercise 2.1.18
   * 排序可是轨迹
   */
  public static void drawSort(Comparable[] a) {
    int N = a.length;
    StdDraw.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    StdDraw.setYscale(N + 3, 0);
    StdDraw.setXscale(0, N + 3);
    StdDraw.setPenColor(Color.BLACK);

    // Header
    StdDraw.text(3 + N / 2, 0.4, "a[ ]");

    // 两个序列列在第一行的列标题
    StdDraw.text(1, 1, "i");
    StdDraw.text(2, 1, "j");

    // 第一行下面的分割线
    StdDraw.line(0, 1.5, N + 3, 1.5);

    // 列序号旁的分割线
    StdDraw.line(2.5, 0, 2.5, N + 3);

    // 第一行的序列和第二行的初始值
    for (int i = 0; i < N; i++) {
      // 第一行的序列
      StdDraw.text(3 + i, 1, i + "");
      // 第二行的初始值
      StdDraw.text(3 + i, 2, a[i].toString());
    }

    for (int i = 1; i < N; i++) {
      int min = i;

      for (int j = i; j > 0; j--) {
        if (less(a[j - 1], a[j])) break;
        exch(a, j, j - 1);

        min = j - 1;
      }

      // 初始颜色 黑色
      StdDraw.setPenColor(Color.BLACK);

      // 每次交换后，Index前有序
      StdDraw.text(1, 2 + i, i + "");

      // 每次交换后，最小值的index
      StdDraw.textRight(2, 2 + i, min + "");

      // 打印每次交换前的状态
      for (int j = 0; j < N; j++) {
        // 初始颜色 黑色
        StdDraw.setPenColor(Color.BLACK);
        // 最小值 红色
        if (j == min) StdDraw.setPenColor(Color.RED);
        // 已经交换过的值 灰色
        if (j > i) StdDraw.setPenColor(Color.GRAY);

        StdDraw.text(3 + j, 2 + i, a[j].toString());
      }


    }

    // 最后一行，排序后最终结果。
    StdDraw.setPenColor(Color.GREEN);
    for (int i = 0; i < N; i++) {
      StdDraw.text(3 + i, N + 2, a[i].toString());
    }
  }


  public static void main(String[] args) {
    /*
     * 用来排序的文件
     * - tiny.txt ```S O R T E X A M P L E```
     * - words3.txt
     */
    String filename = "algs4-data/tiny.txt";

    String[] a = new In(filename).readAllStrings();
    sort(a);
    assert isSorted(a);
    show(a);
  }
}

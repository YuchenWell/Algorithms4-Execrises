package chapter1.chapter1_5;

import chapter1.chapter1_4.StopWatch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Ex08 {
  private int[] id;
  private int count;

  public Ex08(int N) {
    count = N;
    id = new int[N];

    for (int i = 0; i < N; i++) {
      id[i] = i;
    }
  }

  public int count() {
    return count;
  }

  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  public int find(int p) {
    return id[p];
  }

  public void union(int p, int q) {
    int pID = find(p);
    int qID = find(q);
    if (pID == qID) return;

    for (int i = 0; i < id.length; i++) {
      // - Right:
      // if (id[i] == pID) id[i] = qID;

      // - Wrong:
      if (id[i] == id[p]) id[i] = id[q];
    }

    count--;
  }


  public static void main(String[] args) {
    /*
     * UF文件
     * - tinyUF.txt 10个触点 11条连接
     * - mediumUF.txt 625个触点 900条连接
     * - largeUF.txt 1000000个触点 2000000条连接
     */
    String filename = "algs4-data/tinyUF.txt";

    In in = new In(filename);
    int N = in.readInt();
    int cnt = 0;
    Ex08 uf = new Ex08(N);

    StopWatch timer = new StopWatch();
    while (!in.isEmpty()) {
      int p = in.readInt();
      int q = in.readInt();
      cnt++;

      if (cnt % 10000 == 0) {
        StdOut.printf("%s in %6.2f seconds \n", cnt, timer.elapsedTime());
      }
      if (uf.connected(p, q)) continue;
      uf.union(q, p);
    }

    StdOut.println(uf.count() + " components");
    StdOut.println(timer.elapsedTime() + " seconds");
  }
}
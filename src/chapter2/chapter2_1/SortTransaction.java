package chapter2.chapter2_1;

import chapter1.chapter1_3.Queue;
import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

/**
 * Exercise 2.1.22
 */

public class SortTransaction {
  public static Transaction[] readTransactions() {
    Queue<Transaction> queue = new Queue<>();
    while (StdIn.hasNextLine()) {
      String line = StdIn.readLine();
      queue.enqueue(new Transaction(line));
    }
    Transaction[] transactions = new Transaction[queue.size()];
    for (int i = 0; i < transactions.length; i++) {
      transactions[i] = queue.dequeue();
    }
    return transactions;
  }

  public static void main(String[] args) {
    Transaction[] transactions = readTransactions();
    Arrays.sort(transactions);
    for (int i = 0; i < transactions.length; i++) {
      System.out.println(transactions[i]);
    }
  }
}

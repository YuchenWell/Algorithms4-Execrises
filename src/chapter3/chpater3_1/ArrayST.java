package chapter3.chpater3_1;

import chapter1.chapter1_3.Queue;

public class ArrayST<Key extends Comparable<Key>, Value> {
  private Key[] keys;
  private Value[] vals;
  private int N;

  public ArrayST(int capacity) {
    keys = (Key[]) new Object[capacity];
    vals = (Value[]) new Object[capacity];
    N = 0;
  }

  public int size() {
    return N;
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public Value get(Key key) {
    for (int i = 0; i < N; i++) {
      if (key.equals(keys[i])) {
        return vals[i];
      }
    }

    return null;
  }

  public void put(Key key, Value val) {
    for (int i = 0; i < N; i++) {
      if (key.equals(keys[i])) {
        vals[i] = val;
        return;
      }
    }

    keys[N] = key;
    vals[N] = val;
    N++;
  }

  public void delete(Key key) {
    for (int i = 0; i < N; i++) {
      if (keys[i].equals(key)) {
        keys[i] = keys[N - 1];
        vals[i] = vals[N - 1];
        keys[N - 1] = null;
        vals[N - 1] = null;
        N--;
        return;
      }
    }
  }

  public boolean contains(Key key) {
    return get(key) != null;
  }

  public Iterable<Key> keys() {
    Queue<Key> queue = new Queue<>();
    for (int i = 0; i < N; i++) {

      queue.enqueue(keys[i]);
    }
    return queue;
  }
}

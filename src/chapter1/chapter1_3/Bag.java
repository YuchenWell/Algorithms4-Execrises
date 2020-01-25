package chapter1.chapter1_3;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
  private Node first;

  private class Node {
    Item item;
    Node next;
  }

  public void add(Item item) {
    Node oldFirst = first;
    first = new Node();
    first.item = item;
    first.next = oldFirst;
  }

  public Iterator<Item> iterator() {
    return new ListIterator();
  }

  public class ListIterator implements Iterator<Item> {
    Node current = first;

    public boolean hasNext() {
      return current.next != null;
    }

    public void remove() {
    }

    public Item next() {
      Item item = current.item;
      current = current.next;
      return item;
    }
  }
}
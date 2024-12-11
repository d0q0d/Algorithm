package com.github.alirezagolshan.ds;

import java.util.LinkedList;

public class Stack<T> {

  private final LinkedList<T> list;

  public Stack() {
    list = new LinkedList<>();
  }

  public void push(T item) {
    list.addFirst(item);
  }

  public void pop() {
    list.remove();
  }

  public boolean isEmpty() {
    return list.isEmpty();
  }

  public int size() {
    return list.size();
  }

  @Override
  public String toString() {
    return "Stack{" + "list=" + list + '}';
  }
}

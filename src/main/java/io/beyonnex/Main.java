package io.beyonnex;

import java.util.Objects;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
  }

  public boolean isAnagram(char[] first, char[] second) {
    Objects.requireNonNull(first, "First text shouldn't be null");
    Objects.requireNonNull(second, "Second text shouldn't be null");

    if (first.length != second.length) return false;

    throw new RuntimeException();
  }
}

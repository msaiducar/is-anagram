package io.beyonnex;

public class Main {

  public static void main(String[] args) {
    if (args.length != 2) {
      printUsage();
      return;
    }

    AnagramChecker checker = new AnagramChecker();
    try {
      boolean isAnagram = checker.isAnagram(args[0], args[1]);
      System.out.printf("Given texts are%s anagram to each other%n", isAnagram ? "" : " not");
      System.out.printf("1st : %s%n", args[0]);
      System.out.printf("2nd : %s%n", args[1]);
    } catch (InvalidInputException e) {
      System.out.println(e.getMessage());
    }
  }

  private static void printUsage() {
    System.out.println("Usage: java -jar is-anagram.jar 'dormitory' 'dirty room'");
  }
}

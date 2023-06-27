package io.beyonnex;

import java.util.HashMap;

public class AnagramChecker {

  private static final String WHITESPACE_REGEXP = "\\s";

  public boolean isAnagram(String first, String second) {
    String preparedFirst = removeWhitespaces(first).toLowerCase();
    String preparedSecond = removeWhitespaces(second).toLowerCase();

    if (notContainsOnlyLetters(preparedFirst) || notContainsOnlyLetters(preparedSecond)) {
      throw new InvalidInputException("Input text should only contain english letters");
    }

    return isAnagram(preparedFirst.toCharArray(), preparedSecond.toCharArray());
  }

  private String removeWhitespaces(String text) {
    return text.replaceAll(WHITESPACE_REGEXP, "");
  }

  private boolean notContainsOnlyLetters(String text) {
    return !text.chars().allMatch(Character::isLetter);
  }

  /**
   * Checks if given two character arrays are anagram of each other. The arrays should only contain
   * english letters.
   *
   * @param first char array
   * @param second char array
   * @return true if anagram, false otherwise
   */
  private boolean isAnagram(char[] first, char[] second) {
    if (first.length != second.length) return false;

    HashMap<Character, Integer> frequencyMap = new HashMap<>();

    // count the character frequency of the first input
    for (char c : first) {
      frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
    }

    // reduce the count of character from second input
    for (char c : second) {
      // stop if the character doesn't exist in the first input
      if (!frequencyMap.containsKey(c)) return false;

      frequencyMap.put(c, frequencyMap.get(c) - 1);
    }

    // inputs are anagram if all character counts are 0
    return frequencyMap.values().parallelStream().allMatch(count -> count == 0);
  }
}

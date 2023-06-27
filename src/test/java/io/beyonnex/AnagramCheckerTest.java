package io.beyonnex;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AnagramCheckerTest {

  private AnagramChecker checker;

  @BeforeEach
  public void init() {
    checker = new AnagramChecker();
  }

  @Test
  public void shouldFail_whenInputsHaveNonLetterChar() {
    assertThrows(
        InvalidInputException.class,
        () -> checker.isAnagram("42", ""),
        "should throw invalidInputException if the first argument has non letter char");
    assertThrows(
        InvalidInputException.class,
        () -> checker.isAnagram("", "42"),
        "should throw invalidInputException if the second argument has non letter char");
  }

  @Test
  public void shouldReturnFalse_whenInputsHaveDifferentLength() {
    assertFalse(checker.isAnagram("a", ""));
  }

  @Test
  public void shouldReturnFalse_whenInputsHaveDifferentLengthIgnoringWhitespaces() {
    assertFalse(checker.isAnagram("a a", " a "));
  }

  @Test
  public void shouldReturnFalse_whenInputsAreNotAnagram() {
    assertFalse(checker.isAnagram("abc", "abD"));
  }

  @Test
  public void shouldReturnTrue_whenInputsAreAnagram() {
    assertTrue(checker.isAnagram("race", "care"));
  }

  @Test
  public void shouldReturnTrue_whenInputsAreAnagramWithWhitespace() {
    assertTrue(checker.isAnagram("rac e", "c   are"));
  }

  @Test
  public void shouldReturnTrue_whenInputsAreAnagramWithCase() {
    assertTrue(checker.isAnagram("rac e", "CaRe"));
  }
}

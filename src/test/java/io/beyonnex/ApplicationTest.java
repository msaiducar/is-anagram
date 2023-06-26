package io.beyonnex;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ApplicationTest {

  private static Main application;

  @BeforeAll
  public static void init() {
    application = new Main();
  }

  @Test
  public void shouldFail_whenInputsAreNull() {
    assertThrows(
        NullPointerException.class,
        () -> application.isAnagram(null, new char[] {}),
        "should throw nullPointerException if the first argument is null");
    assertThrows(
        NullPointerException.class,
        () -> application.isAnagram(new char[] {}, null),
        "should throw nullPointerException if the second argument is null");
  }

  @Test
  public void shouldReturnFalse_whenInputsHaveDifferentLength(){
    assertFalse(application.isAnagram(new char[]{'a'}, new char[]{}));
  }
}

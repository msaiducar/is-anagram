package io.beyonnex;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;
import java.util.random.RandomGenerator;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Test class intended to show the time complexity of the isAnagram algorithm.
 *
 * <p>Generates random texts starting with length of 100, and multiplies by 10 up until 100_000_000.
 *
 * <p>The observed execution times exhibited a linear relationship with the input size, confirming
 * the O(n) time complexity.
 */
public class ComplexityTest {
  private static final int[] INPUT_TEXT_LENGTHS =
      new int[] {100, 1000, 10_000, 100_000, 1_000_000, 10_000_000, 100_000_000};
  private static final RandomGenerator generator = RandomGenerator.getDefault();
  private AnagramChecker checker;

  @BeforeEach
  public void init() {
    checker = new AnagramChecker();
  }

  @ParameterizedTest(name = "{0} chars length inputs for is anagram test")
  @MethodSource("provideInputsForIsAnagram")
  public void shouldReturnTrue_ifInputsAreAnagrams(int length, String first, String second) {
    assertTrue(checker.isAnagram(first, second));
  }

  /**
   * @return test input arrays for each input text length
   */
  private static Stream<Arguments> provideInputsForIsAnagram() {
    Arguments[] testInputs = new Arguments[INPUT_TEXT_LENGTHS.length];
    for (int index = 0; index < INPUT_TEXT_LENGTHS.length; index++) {
      char[] randomCharArray = generateRandomCharArray(INPUT_TEXT_LENGTHS[index]);
      char[] shuffledCharArray = shuffleCharArray(randomCharArray);
      testInputs[index] =
          Arguments.of(INPUT_TEXT_LENGTHS[index], new String(randomCharArray), new String(shuffledCharArray));
    }

    return Stream.of(testInputs);
  }

  /**
   * @return array of random characters with the size of the given length
   */
  private static char[] generateRandomCharArray(int length) {
    char[] array = new char[length];
    for (int index = 0; index < length; index++) {
      array[index] = randomCharacter();
    }
    return array;
  }

  /**
   * @return the copy of given array shuffled
   */
  private static char[] shuffleCharArray(char[] array) {
    char[] copy = Arrays.copyOf(array, array.length);
    for (int i = copy.length - 1; i > 0; i--) {
      int index = generator.nextInt(i + 1);
      char c = copy[index];
      copy[index] = copy[i];
      copy[i] = c;
    }
    return copy;
  }

  /**
   * @return random character from [a-zA-Z]
   */
  private static char randomCharacter() {
    if (generator.nextBoolean()) {
      return (char) (generator.nextInt(26) + 'a');
    } else {
      return (char) (generator.nextInt(26) + 'A');
    }
  }
}

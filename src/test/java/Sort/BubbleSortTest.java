package Sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class BubbleSortTest {
    @Test
    @DisplayName("A null input should return null")
    void nullSortInput() {
        Assertions.assertNull(BubbleSort.sort(null));
    }

    @Test
    @DisplayName("An empty input should return an empty array")
    void emptySortInput() {
        Integer[] emptyArray = {};
        Integer[] result = BubbleSort.sort(emptyArray);
        Assertions.assertArrayEquals(emptyArray, result);
        Assertions.assertNotSame(emptyArray, result, "Must return a copy of the object");
    }

    @Test
    @DisplayName("A single element input should return a copy of the array")
    void singleElementInput() {
        Integer[] emptyArray = {1};
        Integer[] result = BubbleSort.sort(emptyArray);
        Assertions.assertArrayEquals(emptyArray, result);
        Assertions.assertNotSame(emptyArray, result, "Must return a copy of the object");
    }

    @ParameterizedTest
    @MethodSource("dataGenerator")
    @DisplayName("testing sort with integer input")
    void singleElementInput(Integer[] input, Integer[] expected) {
        Integer[] output = BubbleSort.sort(input);
        Assertions.assertArrayEquals(output, expected);
        Assertions.assertNotSame(output, expected, "Must return a copy of the object");
    }


    public static Stream<Arguments> dataGenerator() {
        return IntStream.rangeClosed(2, 20).mapToObj(BubbleSortTest::generateInteger);
    }

    private static Arguments generateInteger(int n) {
        Random random = new Random();
        Integer[] data = Stream.generate(() -> random.nextInt(n)).limit(n).toArray(Integer[]::new);
        Integer[] expectedOutput = Arrays.stream(data).sorted().toArray(Integer[]::new);
        return Arguments.of(data, expectedOutput);
    }

}
package Sort;

import java.util.Arrays;

import static java.lang.reflect.Array.newInstance;

public class MergeSort {
    public static <T extends Comparable<T>> T[] sort(T[] array) {
        if (array == null) return null;
        if (array.length <= 1) return array.clone();

        T[] left = Arrays.copyOfRange(array, 0, array.length / 2);
        T[] right = Arrays.copyOfRange(array, array.length / 2, array.length);
        return merge(left, right);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> T[] merge(T[] left, T[] right) {
        T[] ordered = (T[]) newInstance(left[0].getClass(), left.length + right.length);

        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) < 0) {
                ordered[k] = left[i];
                i++;
            } else {
                ordered[k] = right[j];
                j++;
            }
            k++;
        }

        if (i == left.length) {
            System.arraycopy(right, j, ordered, k, ordered.length - k);
        }

        if (j == right.length) {
            System.arraycopy(left, i, ordered, k, ordered.length - k);
        }

        return ordered;
    }
}

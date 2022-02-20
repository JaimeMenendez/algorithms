package Sort;

public class BubbleSort {
    public static <T extends Comparable<T>> T[] sort(T[] array) {
        if (array == null) return null;
        if (array.length <= 1) return array.clone();

        T[] arr = array.clone();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

        return arr;
    }
}

package sortitout;

/**
 *
 * @author Bradley White
 */
public class InsertionSort<T> {

    public static <T extends Comparable<T>> void insertionSort(T[] randomList, int first, int last) {
        for (int i = first; i < last; i++) {
            T current = randomList[i];
            int j = i;
            while (j > 0 && randomList[j].compareTo(current) < 0) {
                randomList[j] = randomList[j - 1];
                j--;
            }
            randomList[j] = current;
        }
    }
}

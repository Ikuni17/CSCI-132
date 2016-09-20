package insertionsortexperiments;

/**
 *
 * Bradley White
 */
public class InsertionSort {

    public static void insertionSort(Integer[] randomList) {
        for (int i = 1; i < randomList.length; i++) {
            int current = randomList[i];
            int j = i;
            while (j > 0 && randomList[j - 1] > current) {
                randomList[j] = randomList[j - 1];
                j--;
            }

        }
    }
}

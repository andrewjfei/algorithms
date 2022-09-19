package dev.andrewjfei.sort;

/**
 * The {@code QuickSort} sorting algorithm is able to sort an unordered array in {@code O(nlog(n))} time. This is
 * achieved by halving the sorting space on every iteration (due to the recursive nature of the algorithm).
 *
 * @author andrewjfei
 */
public class QuickSort {

    /**
     * This {@code sort} method is used to call the private recursive {@code quickSort} method.
     *
     * @param array the array to be sorted.
     */
    public static void sort(int[] array) {
        if (array.length > 1) {
            quickSort(array, 0, array.length - 1);
        }
    }

    /**
     * This {@code quickSort} method is used within the {@code QuickSort} class to recursively sort the lower and upper
     * halves of the array.
     *
     * @param array the array to be sorted.
     * @param startIndex the starting index of the portion of the array to be sorted.
     * @param endIndex the ending index of the portion of the array to be sorted.
     */
    private static void quickSort(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        int pivotIndex = split(array, startIndex, endIndex);

        // Sort below and above pivot index
        quickSort(array, startIndex, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, endIndex);
    }

    /**
     * This {@code split} method roughly sorts a specific portion of an array given a pivot point. Where the values
     * below the pivot are smaller than the pivot value and the values above the pivot are greater than the pivot value
     * given a starting and ending index.
     *
     * @param array the array to be sorted.
     * @param startIndex the starting index of the portion of the array to be sorted.
     * @param endIndex the ending index of the portion of the array to be sorted.
     */
    private static int split(int[] array, int startIndex, int endIndex) {
        int pivot = array[endIndex];
        int i = startIndex - 1;

        for (int j = startIndex; j < endIndex; j++) {
            if (array[j] < pivot) {
                i++;

                // Swap values
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        i++;
        array[endIndex] = array[i];
        array[i] = pivot;
        return i;
    }
}

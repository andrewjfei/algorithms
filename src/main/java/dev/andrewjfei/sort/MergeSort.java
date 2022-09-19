package dev.andrewjfei.sort;

/**
 * The {@code MergeSort} sorting algorithm is able to sort an unordered array in {@code O(nlog(n))} time. This is
 * achieved by halving the sorting space on every iteration (due to the recursive nature of the algorithm).
 *
 * @author andrewjfei
 */
public class MergeSort {

    /**
     * This {@code sort} method is used to call the private recursive {@code mergeSort} method.
     *
     * @param array the array to be sorted.
     */
    public static void sort(int[] array) {
        if (array.length > 1) {
            int[] tempArray = new int[array.length];
            mergeSort(array, tempArray, 0, array.length - 1);
        }
    }

    /**
     * This {@code mergeSort} method is used within the {@code MergeSort} class to recursively sort the left and right
     * halves of the array.
     *
     * @param array the array to be sorted.
     * @param tempArray a temporary array used when merging sorted halves.
     * @param startIndex the starting index of the portion of the array to be sorted.
     * @param endIndex the ending index of the portion of the array to be sorted.
     */
    private static void mergeSort(int[] array, int[] tempArray, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        // Rounds down if value has a decimal
        int middleIndex = (startIndex + endIndex) / 2;

        mergeSort(array, tempArray, startIndex, middleIndex);
        mergeSort(array, tempArray, middleIndex + 1, endIndex);
        merge(array, tempArray, startIndex, middleIndex, endIndex);
    }

    /**
     * This {@code merge} method merges two sorted arrays and combines them together in the original array.
     *
     * @param array the array to be sorted.
     * @param tempArray a temporary array used when merging sorted halves.
     * @param startIndex the starting index of the portion of the array to be sorted.
     * @param middleIndex the middle index of the portion of the array to be sorted.
     * @param endIndex the ending index of the portion of the array to be sorted.
     */
    private static void merge(int[] array, int[] tempArray, int startIndex, int middleIndex, int endIndex) {
        int tempArrayIndex = startIndex;
        int leftIndex = startIndex;
        int leftEnd = middleIndex;
        int rightIndex = middleIndex + 1;
        int rightEnd = endIndex;

        while (leftIndex <= leftEnd || rightIndex <= rightEnd) {
            if (leftIndex > leftEnd) {
                tempArray[tempArrayIndex] = array[rightIndex];
                rightIndex++;
            } else if (rightIndex > rightEnd) {
                tempArray[tempArrayIndex] = array[leftIndex];
                leftIndex++;
            } else {
                if (array[leftIndex] < array[rightIndex]) {
                    tempArray[tempArrayIndex] = array[leftIndex];
                    leftIndex++;
                } else {
                    tempArray[tempArrayIndex] = array[rightIndex];
                    rightIndex++;
                }
            }
            tempArrayIndex++;
        }

        // Copy sorted temp sub array into array
        for (int i = startIndex; i <= endIndex; i++) {
            array[i] = tempArray[i];
        }
    }
}

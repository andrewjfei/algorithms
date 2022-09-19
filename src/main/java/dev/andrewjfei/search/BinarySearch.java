package dev.andrewjfei.search;

/**
 * The {@code BinarySearch} algorithm is able to search an ascending ordered array in {@code O(log(n))} time. This is
 * achieved by halving the search space on every iteration (due to the recursive nature of the algorithm).
 *
 * @author andrewjfei
 */
public class BinarySearch {

    /**
     * This {@code search} method is used to call the private recursive {@code binarySearch} method.
     *
     * @param array the sorted array by ascending order to be searched.
     * @param target the element in the array to find.
     * @return the index of the target element.
     */
    public static int search(int[] array, int target) {
        if (array.length > 0) {
            return binarySearch(array, 0 , array.length - 1, target);
        }

        // If target does not exist in array return -1
        return -1;
    }

    /**
     * This {@code binarySearch} method search a portion of the original array given a starting and ending index. The
     * defined indexes provides a smaller search space which can be recursively called on.
     *
     * @param array the sorted array by ascending order to be searched.
     * @param startIndex the starting index of the portion of the array to search.
     * @param endIndex the ending index of the portion of the array to search.
     * @param target the element in the array to find.
     * @return the index of the target element.
     */
    private static int binarySearch(int[] array, int startIndex, int endIndex, int target) {
        if (startIndex > endIndex) {
            return -1;
        }

        int middleIndex = (startIndex + endIndex) / 2;

        if (array[middleIndex] == target) {
            return middleIndex;
        } else if (array[middleIndex] > target) {
            return binarySearch(array, startIndex, middleIndex - 1, target);
        } else {
            return binarySearch(array, middleIndex + 1, endIndex, target);
        }
    }
}

package dev.andrewjfei.sort;

public class QuickSort {
    public static void sort(int[] array) {
        if (array.length > 1) {
            sort(array, 0, array.length - 1);
        }
    }

    private static void sort(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        int pivotIndex = split(array, startIndex, endIndex);

        // Sort below and above pivot index
        sort(array, startIndex, pivotIndex - 1);
        sort(array, pivotIndex + 1, endIndex);
    }

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

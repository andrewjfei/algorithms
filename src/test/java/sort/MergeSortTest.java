package sort;

import dev.andrewjfei.sort.MergeSort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergeSortTest {

    @Test
    public void sort_whenParsedAnArrayOfSizeOne_shouldReturnArray() {
        // Given
        int[] array = new int[] { 3 };
        int[] sortedArray = new int[] { 3 };

        // When
        MergeSort.sort(array);

        // Then
        for (int i = 0; i < array.length; i++) {
            assertEquals(sortedArray[i], array[i]);
        }
    }

    @Test
    public void sort_whenParsedAnUnsortedPositiveArray_shouldSortArray() {
        // Given
        int[] array = new int[] { 3, 8, 9, 5, 6, 7, 2, 4 };
        int[] sortedArray = new int[] { 2, 3, 4, 5, 6, 7, 8, 9 };

        // When
        MergeSort.sort(array);

        // Then
        for (int i = 0; i < array.length; i++) {
            assertEquals(sortedArray[i], array[i]);
        }
    }

    @Test
    public void sort_whenParsedAnUnsortedNegativeArray_shouldSortArray() {
        // Given
        int[] array = new int[] { -3, -8, -9, -5, -6, -7, -2, -4 };
        int[] sortedArray = new int[] { -9, -8, -7, -6, -5, -4, -3, -2 };

        // When
        MergeSort.sort(array);

        // Then
        for (int i = 0; i < array.length; i++) {
            assertEquals(sortedArray[i], array[i]);
        }
    }
}

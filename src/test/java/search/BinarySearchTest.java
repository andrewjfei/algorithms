package search;

import dev.andrewjfei.search.BinarySearch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTest {

    @Test
    public void search_whenParsedAnArrayOfSizeOne_shouldReturnNegativeOne() {
        // Given
        int[] array = new int[] { };

        // When
        int targetIndex = BinarySearch.search(array, 2);

        // Then
        assertEquals(-1, targetIndex);
    }

    @Test
    public void search_whenGivenAnInvalidTarget_andParsedASortedPositiveArray_shouldReturnNegativeOne() {
        // Given
        int[] array = new int[] { 2, 3, 4, 5, 6, 7, 8, 9 };

        // When
        int targetIndex = BinarySearch.search(array, -7);

        // Then
        assertEquals(-1, targetIndex);
    }

    @Test
    public void search_whenGivenAValidTarget_andParsedASortedPositiveArray_shouldReturnCorrectIndex() {
        // Given
        int[] array = new int[] { 2, 3, 4, 5, 6, 7, 8, 9 };

        // When
        int targetIndex = BinarySearch.search(array, 7);

        // Then
       assertEquals(5, targetIndex);
    }

    @Test
    public void search_whenGivenAValidTarget_andParsedASortedNegativeArray_shouldReturnCorrectIndex() {
        // Given
        int[] array = new int[] { -9, -8, -7, -6, -5, -4, -3, -2 };

        // When
        int targetIndex = BinarySearch.search(array, -7);

        // Then
        assertEquals(2, targetIndex);
    }
}

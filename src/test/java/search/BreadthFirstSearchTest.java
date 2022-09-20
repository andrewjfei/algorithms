package search;

import dev.andrewjfei.search.BinarySearch;
import dev.andrewjfei.search.BinaryTree;
import dev.andrewjfei.search.BreadthFirstSearch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BreadthFirstSearchTest {
    BinaryTree tree;

    @BeforeEach
    public void setUp() {
        tree = new BinaryTree();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);
        tree.add(7);
        tree.add(8);
        tree.add(9);
    }

    @Test
    public void search_whenParsedATreeOfSizeZero_shouldReturnFalse() {
        // Given
        tree = new BinaryTree();

        // When
        boolean hasTarget = BreadthFirstSearch.search(tree, 1);

        // Then
        assertFalse(hasTarget);
    }

    @Test
    public void search_whenParsedATreeWithExistingTargetValue_shouldReturnTrue() {
        int element = 10;

        // Given
        tree.add(10);

        // When
        boolean hasTarget = BreadthFirstSearch.search(tree, element);

        // Then
        assertTrue(hasTarget);
    }

    @Test
    public void search_whenParsedATreeWithNonExistingTargetValue_shouldReturnFalse() {
        int element = 10;

        // Given
        // When
        boolean hasTarget = BreadthFirstSearch.search(tree, element);

        // Then
        assertFalse(hasTarget);
    }
}

package dev.andrewjfei.search;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * The {@code BreadthFirstSearch} algorithm is able to search a tree in {@code O(n)} time. This is due to
 * traversing through every node in the tree.
 *
 * @author andrewjfei
 */
public class BreadthFirstSearch {

        /**
         * This {@code search} method is used to call the private recursive {@code breadthFirstSearch} method.
         *
         * @param tree the tree to search for the target.
         * @param target the element in the tree to find.
         * @return {@code true} if the target element exists in the tree, otherwise {@code false}.
         */
        public static boolean search(BinaryTree tree, int target) {
            if (tree.size() > 0) {
                return breadthFirstSearch(tree.root(), target);
            }

            // If target does not exist in tree
            return false;
        }

        /**
         * This {@code breadthFirstSearch} method searches a tree for a target node, by traversing as broad across the
         * branches first before exploring the next level of branches.
         *
         * @param root the root node of the tree.
         * @param target the element to find in the tree.
         * @return {@code true} if the target element exists in the tree, otherwise {@code false}.
         */
        private static boolean breadthFirstSearch(BinaryTree.Node root, int target) {
            Queue<BinaryTree.Node> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                BinaryTree.Node node = queue.poll();

                if (node.getData() == target) {
                    return true;
                }

                if (node.getLeftChild() != null) {
                    queue.add(node.getLeftChild());
                }

                if (node.getRightChild() != null) {
                    queue.add(node.getRightChild());
                }
            }

            return false;
        }
}

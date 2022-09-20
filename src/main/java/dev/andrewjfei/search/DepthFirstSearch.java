package dev.andrewjfei.search;

/**
 * The {@code DepthFirstSearch} algorithm is able to search a tree in {@code O(n)} time. This is
 * traversing through every node in the tree.
 *
 * @author andrewjfei
 */
public class DepthFirstSearch {

        /**
         * This {@code search} method is used to call the private recursive {@code depthFirstSearch} method.
         *
         * @param tree the tree to search for the target.
         * @param target the element in the tree to find.
         * @return {@code true} if the target element exists in the tree, otherwise {@code false}.
         */
        public static boolean search(BinaryTree tree, int target) {
            if (tree.size() > 0) {
                return depthFirstSearch(tree.root(), target);
            }

            // If target does not exist in tree
            return false;
        }

        /**
         * This {@code depthFirstSearch} method searches a tree for a target node, by traversing to as deep down the
         * branches first before exploring the next branch.
         *
         * @param node the currently visited node.
         * @param target the element to find in the tree.
         * @return {@code true} if the target element exists in the tree, otherwise {@code false}.
         */
        private static boolean depthFirstSearch(BinaryTree.Node node, int target) {
            if (node == null) {
                return false;
            }

            if (node.getData() == target) {
                return true;
            }

            return depthFirstSearch(node.getLeftChild(), target) || depthFirstSearch(node.getRightChild(), target);
        }
}

package dev.andrewjfei.search;

public class BinaryTree {
    private int size;
    private Node root;

    public BinaryTree() {
        size = 0;
    }

    public void add(int i)  {
        Node newNode = new Node(i);

        if (isEmpty()) {
            root = newNode;
        } else {
            sink(root, newNode);
        }

        size++;
    }

    public Node root() {
        return root;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0 ? true : false;
    }

    private void sink(Node parentNode, Node newNode) {
        if (parentNode.getLeftChild() == null && parentNode.getRightChild() == null) {
            int random = (int) Math.round(Math.random());

            if (random == 0) {
                parentNode.setLeftChild(newNode);
            } else {
                parentNode.setRightChild(newNode);
            }

            return;
        }

        if (parentNode.getLeftChild() == null)  {
            parentNode.setLeftChild(newNode);
            return;
        }

        if (parentNode.getRightChild() == null)  {
            parentNode.setRightChild(newNode);
            return;
        }

        if (parentNode.getLeftChild() != null && parentNode.getRightChild() != null) {
            int random = (int) Math.round(Math.random());

            if (random == 0) {
                sink(parentNode.getLeftChild(), newNode);
            } else {
                sink(parentNode.getRightChild(), newNode);
            }
        }
    }

    public class Node {
        private int data;
        private Node leftChild;
        private Node rightChild;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }
    }
}

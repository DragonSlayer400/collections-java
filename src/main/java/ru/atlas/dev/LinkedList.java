package ru.atlas.dev;

public class LinkedList implements List {

    private Node first;
    private Node last;
    private int size = 0;

    @Override
    public boolean add(StudentGroup studentGroup) {
        if(size == 0){
            Node node = new Node(null, studentGroup, null);
            first = node;
            last = node;
        } else {
            Node secondLast = last;
            last = new Node(secondLast, studentGroup, null);
            secondLast.setNext(last);
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(StudentGroup studentGroup) {
        int index = getIndexByElement(studentGroup);
        if(index != -1){
            return removeAt(index);
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public boolean contains(StudentGroup studentGroup) {
        return getIndexByElement(studentGroup) != -1;
    }

    @Override
    public boolean add(StudentGroup studentGroup, int index) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        if(index == size){
            return add(studentGroup);
        }
        Node nodeNext = getNode(index);
        Node nodePrevious = nodeNext.getPrevious();
        Node newNode = new Node(nodePrevious, studentGroup, nodeNext);
        nodeNext.setPrevious(newNode);
        if(nodePrevious != null){
            nodePrevious.setNext(newNode);
        } else {
            first = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean removeAt(int index) {
        Node node = getNode(index);
        Node nodeNext = node.getNext();
        Node nodePrevious = node.getPrevious();
        if(nodeNext != null){
            nodeNext.setPrevious(nodePrevious);
        } else {
            last = nodePrevious;
        }
        if(nodePrevious != null){
            nodePrevious.setNext(nodeNext);
        } else {
            first = nodeNext;
        }
        size--;
        return true;
    }

    @Override
    public StudentGroup get(int index) {
        return getNode(index).getValue();
    }

    private int getIndexByElement(StudentGroup group){
        Node node = first;
        for (int i = 0; i < size; i++) {
            if(node.getValue().equals(group)){
                return i;
            }
            node = node.getNext();
        }
        return -1;
    }

    private Node getNode(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node;
    }

    private static class Node {
        private Node previous;
        private StudentGroup value;
        private Node next;

        public Node(Node previous, StudentGroup value, Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public StudentGroup getValue() {
            return value;
        }

        public void setValue(StudentGroup value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}

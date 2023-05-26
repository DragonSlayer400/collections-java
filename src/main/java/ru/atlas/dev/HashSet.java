package ru.atlas.dev;

public class HashSet implements Set {

    private final static int INITIAL_CAPACITY = 16;
    private final static double LOAD_FACTORY = 0.75;
    private int size = 0;
    private Entry[] array = new Entry[INITIAL_CAPACITY];

    @Override
    public boolean add(StudentGroup studentGroup) {
        if(size >= (array.length * LOAD_FACTORY)){
            increaseArray();
        }
        boolean addedFlag = add(studentGroup, array);
        if(addedFlag){
            size++;
        }
        return addedFlag;
    }

    @Override
    public boolean remove(StudentGroup studentGroup) {
        int position = getElementPosition(studentGroup, array.length);
        if(array[position] == null){
            return false;
        }
        Entry secondLast = array[position];
        Entry last = secondLast.getNext();
        if(secondLast.getValue().equals(studentGroup)){
            array[position] = last;
            size--;
            return true;
        }
        while (last != null){
            if(last.getValue().equals(studentGroup)){
                secondLast.setNext(last.getNext());
                size--;
                return true;
            } else {
                secondLast = last;
                last = last.getNext();
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new Entry[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public boolean contains(StudentGroup studentGroup) {
        int position = getElementPosition(studentGroup, array.length);
        if(array[position] == null){
            return false;
        }
        Entry secondLast = array[position];
        Entry last = secondLast.getNext();
        if(secondLast.getValue().equals(studentGroup)){
            return true;
        }
        while (last != null){
            if(last.getValue().equals(studentGroup)){
                return true;
            } else {
                last = last.getNext();
            }
        }
        return false;
    }

    private void increaseArray(){
        Entry[] newArray = new Entry[array.length * 2];
        for (Entry entry : array) {
            Entry elementFromArray = entry;
            while (elementFromArray != null){
                add(elementFromArray.getValue(), newArray);
                elementFromArray = elementFromArray.getNext();
            }
        }
        array = newArray;
    }

    private boolean add(StudentGroup studentGroup, Entry[] dst){
        int position = getElementPosition(studentGroup, dst.length);
        if(dst[position] == null){
            dst[position] = new Entry(studentGroup, null);
            return true;
        } else {
            Entry elementFromArray = dst[position];
            while (true){
                if(elementFromArray.getValue().equals(studentGroup)){
                    return false;
                } else if (elementFromArray.next == null) {
                    elementFromArray.setNext(new Entry(studentGroup, null));
                    return true;
                } else {
                    elementFromArray = elementFromArray.getNext();
                }
            }
        }
    }

    private int getElementPosition(StudentGroup studentGroup, int arrayLength){
        return Math.abs(studentGroup.hashCode() % arrayLength);
    }

    private static class Entry {
        private StudentGroup value;
        private Entry next;

        public Entry(StudentGroup value, Entry next) {
            this.value = value;
            this.next = next;
        }

        public StudentGroup getValue() {
            return value;
        }

        public void setValue(StudentGroup value) {
            this.value = value;
        }

        public Entry getNext() {
            return next;
        }

        public void setNext(Entry next) {
            this.next = next;
        }
    }
}

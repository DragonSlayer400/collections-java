package ru.atlas.dev;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashMap implements Map{

    private final static int INITIAL_CAPACITY = 16;
    private final static double LOAD_FACTOR = 0.75;

    private Entry[] array = new Entry[INITIAL_CAPACITY];

    private int size = 0;

    @Override
    public void put(Curator key, StudentGroup value) {
        if(size >= (array.length * LOAD_FACTOR)){
            increaseArray();
        }
        if (put(key, value, array)){
            size++;
        }
    }

    private boolean put(Curator key, StudentGroup value, Entry[] dst){
        int position = getElementPosition(key, dst.length);
        Entry elementFromArray = dst[position];
        if(elementFromArray == null){
            dst[position] = new Entry(key, value,null);
            return true;
        } else {
            while (true){
                if (elementFromArray.getKey().equals(key)){
                    elementFromArray.setValue(value);
                    return false;
                }
                if(elementFromArray.getNext() == null){
                    elementFromArray.setNext(new Entry(key, value, null));
                    return true;
                }
                elementFromArray = elementFromArray.getNext();
            }
        }
    }

    @Override
    public StudentGroup get(Curator key) {
        int position = getElementPosition(key, array.length);
        Entry elementFromArray = array[position];
        while (elementFromArray != null){
            if(elementFromArray.getKey().equals(key)){
                return elementFromArray.getValue();
            }
            elementFromArray = elementFromArray.getNext();
        }
        return null;
    }

    @Override
    public Set<Curator> keySet() {
        Set<Curator> keys = new HashSet<>();
        for (Entry entry : array) {
            Entry elementFromArray = entry;
            while (elementFromArray != null){
                keys.add(elementFromArray.getKey());
                elementFromArray = elementFromArray.getNext();
            }
        }
        return keys;
    }

    @Override
    public List<StudentGroup> values() {
        List<StudentGroup> values = new ArrayList<>();
        for (Entry entry : array) {
            Entry elementFromArray = entry;
            while (elementFromArray != null){
                values.add(elementFromArray.getValue());
                elementFromArray = elementFromArray.getNext();
            }
        }
        return values;
    }

    @Override
    public boolean remove(Curator key) {
        int position = getElementPosition(key, array.length);
        Entry elementFromArray = array[position];
        if(elementFromArray != null && elementFromArray.getKey().equals(key)){
            array[position] = elementFromArray.getNext();
            size--;
            return true;
        } else {
            while(elementFromArray != null){
                Entry nextElement = elementFromArray.getNext();
                if(nextElement == null){
                    return false;
                }
                if(nextElement.getKey().equals(key)){
                    elementFromArray.setNext(nextElement.getNext());
                    size--;
                    return true;
                }
                elementFromArray = nextElement;
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

    private int getElementPosition(Curator key, int arrayLength){
        return Math.abs(key.hashCode() % arrayLength);
    }

    private void increaseArray(){
        Entry[] newArray = new Entry[array.length * 2];
        for (Entry entry : array) {
            Entry elementFromArray = entry;
            while (elementFromArray != null){
                put(elementFromArray.getKey(), elementFromArray.getValue(), newArray);
                elementFromArray = elementFromArray.getNext();
            }
        }
        array = newArray;
    }

    private static class Entry {
        private Curator key;
        private StudentGroup value;
        private Entry next;

        public Entry(Curator key, StudentGroup value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Curator getKey() {
            return key;
        }

        public void setKey(Curator key) {
            this.key = key;
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

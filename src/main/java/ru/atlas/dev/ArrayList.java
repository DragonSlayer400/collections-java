package ru.atlas.dev;

public class ArrayList implements List {

    private StudentGroup[] array = new StudentGroup[10];

    private int size = 0;

    @Override
    public boolean add(StudentGroup studentGroup) {
        increaseArray();
        array[size] = studentGroup;
        size++;
        return true;
    }

    @Override
    public boolean remove(StudentGroup studentGroup) {
        for (int i = 0; i < size; i++) {
            if(array[i].equals(studentGroup)){
                return removeAt(i);
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
        array = new StudentGroup[10];
        size = 0;
    }

    @Override
    public boolean add(StudentGroup studentGroup, int index) {
        increaseArray();
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        for (int i = size; i > index ; i--) {
            array[i] = array[i - 1];
        }
        array[index] = studentGroup;
        size++;
        return true;
    }

    @Override
    public boolean removeAt(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return true;
    }

    @Override
    public StudentGroup get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public boolean contains(StudentGroup studentGroup) {
        for (int i = 0; i < array.length; i++) {
            if(array[i].equals(studentGroup)){
                return true;
            }
        }
        return false;
    }

    private void checkIndex(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
    }

    private void increaseArray(){
        if (size >= array.length){
            StudentGroup[] newArray = new StudentGroup[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }
    public StudentGroup[] getArray(){
        return array;
    }
}

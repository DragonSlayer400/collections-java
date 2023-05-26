package ru.atlas.dev;

public interface List extends Collection {
    @Override
    boolean add(StudentGroup studentGroup);
    @Override
    boolean remove(StudentGroup studentGroup);
    @Override
    int size();
    @Override
    void clear();
    @Override
    boolean contains(StudentGroup studentGroup);
    boolean add(StudentGroup studentGroup, int index);
    boolean removeAt(int index);
    StudentGroup get(int index);
}

package ru.atlas.dev;

public interface Set extends Collection {
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
}

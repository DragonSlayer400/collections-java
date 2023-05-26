package ru.atlas.dev;

public interface Collection {
    boolean add(StudentGroup studentGroup);
    boolean remove(StudentGroup studentGroup);
    int size();
    void clear();
    boolean contains(StudentGroup studentGroup);
}

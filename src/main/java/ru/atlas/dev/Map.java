package ru.atlas.dev;

import java.util.List;
import java.util.Set;

public interface Map {
    void put(Curator key, StudentGroup value);
    StudentGroup get(Curator key);
    Set<Curator> keySet();
    List<StudentGroup> values();
    boolean remove(Curator key);
    int size();
    void clear();
}

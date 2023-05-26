package ru.atlas.dev;

import java.util.Objects;

public class StudentGroup {
    private long numberGroup;
    private String groupName;

    public StudentGroup(long numberGroup, String groupName) {
        this.numberGroup = numberGroup;
        this.groupName = groupName;
    }

    public long getNumberGroup() {
        return numberGroup;
    }

    public String getGroupName() {
        return groupName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentGroup group = (StudentGroup) o;
        return numberGroup == group.numberGroup && Objects.equals(groupName, group.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberGroup, groupName);
    }
}

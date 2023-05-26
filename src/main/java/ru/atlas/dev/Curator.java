package ru.atlas.dev;

import java.util.Objects;

public class Curator {

    private long tableNumber;

    private String name;
    private String lastName;

    public Curator(long tableNumber, String name, String lastName) {
        this.tableNumber = tableNumber;
        this.name = name;
        this.lastName = lastName;
    }

    public long getTableNumber() {
        return tableNumber;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curator curator = (Curator) o;
        return tableNumber == curator.tableNumber && Objects.equals(name, curator.name) && Objects.equals(lastName, curator.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableNumber, name, lastName);
    }
}

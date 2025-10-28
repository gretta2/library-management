package org.example.LAB1.library;

public class Librarian {
    private final int id;
    private final String name;

    public Librarian(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "Librarian ID: " + id + ", Name: " + name;
    }
}
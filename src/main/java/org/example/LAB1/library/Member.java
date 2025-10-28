package org.example.LAB1.library;

public class Member {
    private final int id;
    private final String name;

    public Member(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }


    public double calculateLateFees(int daysLate) {
        return daysLate * 1.0;
    }

    @Override
    public String toString() {
        return "Member ID: " + id + ", Name: " + name;
    }
}
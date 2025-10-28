package org.example.LAB1.library;

public class StudentMember extends Member {
    public StudentMember(int id, String name) {
        super(id, name);
    }

    @Override
    public double calculateLateFees(int daysLate) {
        return daysLate * 0.5;
    }
}
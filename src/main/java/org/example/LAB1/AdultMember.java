package org.example.LAB1.library;


public class AdultMember extends Member {
    public AdultMember(int id, String name) {
        super(id, name);
    }

    @Override
    public double calculateLateFees(int daysLate) {
        return daysLate * 1.5; // adults pay more
    }
}
package org.example.LAB1;

import org.example.LAB1.library.AdultMember;
import org.example.LAB1.library.Member;
import org.example.LAB1.library.StudentMember;

public class Main {
    public static void main(String[] args) {
        Member student = new StudentMember(1, "Alice");
        Member adult = new AdultMember(2, "Bob");

        System.out.println(student.getName() + " late fee: " + student.calculateLateFees(4));
        System.out.println(adult.getName() + " late fee: " + adult.calculateLateFees(4));
    }
}
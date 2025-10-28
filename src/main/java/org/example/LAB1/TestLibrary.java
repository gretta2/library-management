package org.example.LAB1;

import org.example.LAB1.library.Book;
import org.example.LAB3.Member;

public class TestLibrary {
    public static void main(String[] args) {

        Library lib = new Library();

        Book b1 = new Book(1, "Java Basics", "John Doe");
        Book b2 = new Book(2, "OOP Concepts", "Jane Smith");

        lib.addBook(b1);
        lib.addBook(b2);

        Member s = new Member(4, "Alicia");
        Member a = new Member(5, "Bobette");

        lib.borrowBook(s, b1);
        lib.borrowBook(a, b2);

        lib.showBorrowedBooks();
    }
}
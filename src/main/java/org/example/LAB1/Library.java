
package org.example.LAB1;
import org.example.LAB1.library.Book;
import org.example.LAB3.Member;

import java.util.*;

public class Library {
    private final List<Book> books = new ArrayList<>();
    private final Map<Member, List<Book>> borrowedBooks = new HashMap<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void borrowBook(Member member, Book book) {
        if (!book.isBorrowed()) {
            book.setBorrowed(true);
            borrowedBooks.putIfAbsent(member, new ArrayList<>());
            borrowedBooks.get(member).add(book);
            System.out.println(member.getName() + " borrowed " + book.getTitle());
        } else {
            System.out.println("Sorry, this book is already borrowed.");
        }
    }

    public void showBorrowedBooks() {
        for (Map.Entry<Member, List<Book>> entry : borrowedBooks.entrySet()) {
            System.out.println(entry.getKey().getName() + " has borrowed:");
            for (Book book : entry.getValue()) {
                System.out.println("  - " + book.getTitle());
            }
        }
    }
}
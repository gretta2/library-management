package org.example.LAB3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookDAO bookDAO = new BookDAO();
        MemberDAO memberDAO = new MemberDAO();
        BorrowingDAO borrowDAO = new BorrowingDAO();

        while (true) {
            System.out.println("===Library Management System ===");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Show All Books");
            System.out.println("6. Show All Members");
            System.out.println("7. Show Borrowed Books");
            System.out.println("8. Update Book Title");
            System.out.println("9. Update Member Name");
            System.out.println("10. Delete Book");
            System.out.println("11. Delete Member");
            System.out.println("0. Exit");
            System.out.print(" Enter your choice: ");

            try {
                int choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1 -> { // Add Book
                        System.out.print("Enter book title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter author name: ");
                        String author = sc.nextLine();
                        bookDAO.addBook(title, author);
                    }

                    case 2 -> { // Add Member
                        System.out.print("Enter member name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter member type: ");
                        String type = sc.nextLine();
                        memberDAO.addMember(name, type);
                    }

                    case 3 -> { // Borrow Book
                        memberDAO.showMembers();
                        bookDAO.showBooks();
                        System.out.print("Enter member ID: ");
                        int memberId = sc.nextInt();
                        System.out.print("Enter book ID: ");
                        int bookId = sc.nextInt();
                        borrowDAO.borrowBook(memberId, bookId);
                    }

                    case 4 -> { // Return Book
                        memberDAO.showMembers();
                        bookDAO.showBooks();
                        System.out.print("Enter member ID: ");
                        int memberId = sc.nextInt();
                        System.out.print("Enter book ID: ");
                        int bookId = sc.nextInt();
                        borrowDAO.returnBook(memberId, bookId);
                    }

                    case 5 -> bookDAO.showBooks(); // Show all books
                    case 6 -> memberDAO.showMembers(); // Show all members
                    case 7 -> borrowDAO.showBorrowedBooks(); // Show borrowed books

                    case 8 -> { // Update Book
                        bookDAO.showBooks();
                        System.out.print("Enter book ID to update: ");
                        int bookId = sc.nextInt();
                        sc.nextLine(); // consume newline
                        System.out.print("Enter new title: ");
                        String newTitle = sc.nextLine();
                        bookDAO.updateBook(bookId, newTitle);
                    }

                    case 9 -> { // Update Member
                        memberDAO.showMembers();
                        System.out.print("Enter member ID to update: ");
                        int memberId = sc.nextInt();
                        sc.nextLine(); // consume newline
                        System.out.print("Enter new name: ");
                        String newName = sc.nextLine();
                        memberDAO.updateMember(memberId, newName);
                    }

                    case 10 -> { // Delete Book
                        bookDAO.showBooks();
                        System.out.print("Enter book ID to delete: ");
                        int bookId = sc.nextInt();
                        bookDAO.deleteBook(bookId);
                    }

                    case 11 -> { // Delete Member
                        memberDAO.showMembers();
                        System.out.print("Enter member ID to delete: ");
                        int memberId = sc.nextInt();
                        memberDAO.deleteMember(memberId);
                    }

                    case 0 -> { // Exit
                        System.out.println(" Exiting system. Goodbye!");
                        sc.close();
                        System.exit(0);
                    }

                    default -> System.out.println(" Invalid choice. Try again!");
                }

            } catch (InputMismatchException e) {
                System.out.println(" Invalid input. Enter numbers only!");
                sc.nextLine(); // clear scanner buffer
            }
        }
    }
}
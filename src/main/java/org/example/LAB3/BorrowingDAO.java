package org.example.LAB3;

import java.sql.*;

public class BorrowingDAO {

    public void borrowBook(int memberId, int bookId) {
        String checkMember = "SELECT * FROM members WHERE id=?";
        String checkBook = "SELECT * FROM books WHERE id=? AND is_borrowed=false";
        String insertBorrow = "INSERT INTO borrowings (member_id, book_id) VALUES (?, ?)";
        String markBorrowed = "UPDATE books SET is_borrowed=true WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt1 = conn.prepareStatement(checkMember);
             PreparedStatement stmt2 = conn.prepareStatement(checkBook);
             PreparedStatement stmt3 = conn.prepareStatement(insertBorrow);
             PreparedStatement stmt4 = conn.prepareStatement(markBorrowed)) {

            // Check member exists
            stmt1.setInt(1, memberId);
            ResultSet rsMember = stmt1.executeQuery();
            if (!rsMember.next()) {
                System.out.println("❌ Member ID not found.");
                return;
            }

            // Check book available
            stmt2.setInt(1, bookId);
            ResultSet rsBook = stmt2.executeQuery();
            if (!rsBook.next()) {
                System.out.println("❌ Book ID not available or already borrowed.");
                return;
            }

            // Borrow book
            stmt3.setInt(1, memberId);
            stmt3.setInt(2, bookId);
            stmt3.executeUpdate();

            stmt4.setInt(1, bookId);
            stmt4.executeUpdate();

            System.out.println("✅ Book borrowed successfully!");

        } catch (SQLException e) {
            System.out.println("❌ Error borrowing book!");
            e.printStackTrace();
        }
    }

    public void returnBook(int memberId, int bookId) {
        String deleteBorrow = "DELETE FROM borrowings WHERE member_id=? AND book_id=?";
        String markAvailable = "UPDATE books SET is_borrowed=false WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt1 = conn.prepareStatement(deleteBorrow);
             PreparedStatement stmt2 = conn.prepareStatement(markAvailable)) {

            stmt1.setInt(1, memberId);
            stmt1.setInt(2, bookId);
            int deleted = stmt1.executeUpdate();

            if (deleted == 0) {
                System.out.println("❌ Borrow record not found.");
                return;
            }

            stmt2.setInt(1, bookId);
            stmt2.executeUpdate();
            System.out.println("✅ Book returned successfully!");

        } catch (SQLException e) {
            System.out.println("❌ Error returning book!");
            e.printStackTrace();
        }
    }

    public void showBorrowedBooks() {
        String sql = """
            SELECT m.name AS member_name, b.title AS book_title, br.borrow_date
            FROM borrowings br
            JOIN members m ON br.member_id = m.id
            JOIN books b ON br.book_id = b.id;
        """;

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n📘 Borrowed Books:");
            while (rs.next()) {
                System.out.println(rs.getString("member_name") +
                        " borrowed \"" + rs.getString("book_title") +
                        "\" on " + rs.getDate("borrow_date"));
            }

        } catch (SQLException e) {
            System.out.println("❌ Error fetching borrowed books!");
            e.printStackTrace();
        }
    }
}
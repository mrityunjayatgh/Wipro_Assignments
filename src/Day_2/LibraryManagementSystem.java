package Day_2;

import java.io.*;
import java.util.*;

class Book implements Serializable {
    int id;
    String title;
    String author;
    boolean isIssued;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String toString() {
        return "Book ID: " + id + ", Title: " + title + ", Author: " + author + ", Issued: " + isIssued;
    }
}

class Member implements Serializable {
    int id;
    String name;

    public Member(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "Member ID: " + id + ", Name: " + name;
    }
}

class Transaction implements Serializable {
    int bookId;
    int memberId;
    Date issueDate;
    Date returnDate;

    public Transaction(int bookId, int memberId, Date issueDate, Date returnDate) {
        this.bookId = bookId;
        this.memberId = memberId;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    public String toString() {
        return "Book ID: " + bookId + ", Member ID: " + memberId + ", Issue Date: " + issueDate + ", Return Date: " + returnDate;
    }
}

public class LibraryManagementSystem {
    private static final String BOOK_FILE = "books.dat";
    private static final String MEMBER_FILE = "members.dat";
    private static final String TRANSACTION_FILE = "transactions.dat";

    private static List<Book> books = new ArrayList<>();
    private static List<Member> members = new ArrayList<>();
    private static List<Transaction> transactions = new ArrayList<>();

    public static void main(String[] args) {
        loadFromFile();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. View Books");
            System.out.println("6. View Members");
            System.out.println("7. View Transactions");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> addBook(scanner);
                case 2 -> addMember(scanner);
                case 3 -> issueBook(scanner);
                case 4 -> returnBook(scanner);
                case 5 -> viewBooks();
                case 6 -> viewMembers();
                case 7 -> viewTransactions();
                case 8 -> {
                    saveToFile();
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addBook(Scanner scanner) {
        System.out.print("Enter Book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Book Author: ");
        String author = scanner.nextLine();

        books.add(new Book(id, title, author));
        System.out.println("Book added successfully.");
    }

    private static void addMember(Scanner scanner) {
        System.out.print("Enter Member ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Member Name: ");
        String name = scanner.nextLine();

        members.add(new Member(id, name));
        System.out.println("Member added successfully.");
    }

    private static void issueBook(Scanner scanner) {
        System.out.print("Enter Book ID to Issue: ");
        int bookId = scanner.nextInt();
        System.out.print("Enter Member ID: ");
        int memberId = scanner.nextInt();

        for (Book book : books) {
            if (book.id == bookId && !book.isIssued) {
                book.isIssued = true;
                transactions.add(new Transaction(bookId, memberId, new Date(), null));
                System.out.println("Book issued successfully.");
                return;
            }
        }
        System.out.println("Book not found or already issued.");
    }

    private static void returnBook(Scanner scanner) {
        System.out.print("Enter Book ID to Return: ");
        int bookId = scanner.nextInt();

        for (Book book : books) {
            if (book.id == bookId && book.isIssued) {
                book.isIssued = false;
                for (Transaction transaction : transactions) {
                    if (transaction.bookId == bookId && transaction.returnDate == null) {
                        transaction.returnDate = new Date();
                        System.out.println("Book returned successfully.");
                        return;
                    }
                }
            }
        }
        System.out.println("Book not found or not issued.");
    }

    private static void viewBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private static void viewMembers() {
        for (Member member : members) {
            System.out.println(member);
        }
    }

    private static void viewTransactions() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    private static void saveToFile() {
        try (ObjectOutputStream bookOut = new ObjectOutputStream(new FileOutputStream(BOOK_FILE));
             ObjectOutputStream memberOut = new ObjectOutputStream(new FileOutputStream(MEMBER_FILE));
             ObjectOutputStream transactionOut = new ObjectOutputStream(new FileOutputStream(TRANSACTION_FILE))) {
            bookOut.writeObject(books);
            memberOut.writeObject(members);
            transactionOut.writeObject(transactions);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    private static void loadFromFile() {
        try (ObjectInputStream bookIn = new ObjectInputStream(new FileInputStream(BOOK_FILE));
             ObjectInputStream memberIn = new ObjectInputStream(new FileInputStream(MEMBER_FILE));
             ObjectInputStream transactionIn = new ObjectInputStream(new FileInputStream(TRANSACTION_FILE))) {
            books = (List<Book>) bookIn.readObject();
            members = (List<Member>) memberIn.readObject();
            transactions = (List<Transaction>) transactionIn.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No previous data found or error loading data: " + e.getMessage());
        }
    }
}

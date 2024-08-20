import java.util.*;
import java.util.Scanner;


public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();

    public static void main(String[] args) {
        Library library = new Library();
        library.run();
    }
    Scanner scanner = new Scanner(System.in);


    private void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add book");
            System.out.println("2. Add member");
            System.out.println("3. Search books");
            System.out.println("4. Checkout book");
            System.out.println("5. Return book");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    addMember(scanner);
                    break;
                case 3:
                    searchBooks(scanner);
                    break;
                case 4:
                    checkoutBook(scanner);
                    break;
                case 5:
                    returnBook(scanner);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void returnBook(Scanner scanner) {

    }


    private void addBook(Scanner scanner) {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();

        Book book = new Book(title, author, isbn);
        books.add(book);
        System.out.println("Book added successfully!");
    }


    private void addMember(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            System.out.println("Invalid email address. Please try again.");
            return;
        }

        Member member = new Member(name, email);
        members.add(member);
        System.out.println("Member added successfully!");
    }


    private void searchBooks(Scanner scanner) {
        System.out.print("Enter search query: ");
        String query = scanner.nextLine();

        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(query.toLowerCase())) {
                results.add(book);
            }
        }

        if (results.isEmpty()) {
            System.out.println("No results found.");
        } else {
            for (Book book : results) {
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("ISBN: " + book.getIsbn());
                System.out.println("Availability: " + (book.isAvailable() ? "Yes" : "No"));
                System.out.println();
            }
        }
    }


    private void checkoutBook(Scanner scanner) {
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();

        Book book = findBookByIsbn(isbn);
        if (book == null) {
            System.out.println("Book found. ");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("Book is  available for checkout");
        }
    }

    private Book findBookByIsbn(String isbn) {
        return null;
    }
}
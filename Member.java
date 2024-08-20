import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private String email;
    private List<Book> borrowedBooks = new ArrayList<>();

    public Member(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}
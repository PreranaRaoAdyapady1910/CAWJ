package LAB3.Q13_BookShop;


import java.util.ArrayList;
import java.util.List;

public class BookShop {
    private List<Book> books = new ArrayList<>();

    public List<Book> getAllBooks() {
        return books;
    }

    public Book addBook(String title, String author,
                        double price, String publisher, int stock) {
        Book existing = searchBook(title, author);

        if (existing != null) {
            existing.addStock(stock);
            return existing;
        }

        Book book = new Book(title, author, price, publisher, stock);
        books.add(book);
        return book;
    }

    public Book searchBook(String title, String author) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)
                    && book.getAuthor().equalsIgnoreCase(author)) {
                return book;
            }
        }
        return null;
    }

    public void processTransaction(String title, String author,
                                   int copies) {
        Book book = searchBook(title, author);

        if (book == null) {
            System.out.println("Book is not available.");
            return;
        }

        System.out.println(book);

        if (copies <= 0) {
            System.out.println("Enter a valid number of copies.");
            return;
        }

        if (book.hasStock(copies)) {
            double total = book.getPrice(copies);
            System.out.println("Total cost: " + total);

            book.removeStock(copies);
            System.out.println("Order successful.");
            System.out.println("Remaining stock: " + book.getStock());
        } else {
            System.out.println("Required copies not in stock.");
        }
    }

    public void seedBooks() {
        addBook("Learning Python", "Mark Lutz",
                550.0, "Tech Press", 8);

        addBook("Computer Networks", "Andrew Tanenbaum",
                700.0, "Academic House", 5);

        addBook("Data Structures", "Narasimha Karumanchi",
                450.0, "Career Books", 12);
    }
}

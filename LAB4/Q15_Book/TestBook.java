package LAB4.Q15_Book;


public class TestBook {
    public static void main(String[] args) {

        Author author = new Author(
                "Ravi Kumar", "ravi@example.com", 'm');

        Book book1 = new Book(
                "Python Basics", author, 450.0, 20);

        Book book2 = new Book(
                "Learning Java", author, 600.0);

        
        assert author.getName().equals("Ravi Kumar");
        assert author.getEmail().equals("ravi@example.com");
        assert author.getGender() == 'm';

        assert book1.getName().equals("Python Basics");
        assert book1.getAuthor() == author;
        assert book1.getPrice() == 450.0;
        assert book1.getQty() == 20;

        book1.setPrice(500.0);
        assert book1.getPrice() == 500.0;

        assert book2.getQty() == 0;

        book2.setQty(15);
        assert book2.getQty() == 15;

        System.out.println(book1);
        System.out.println(book2);

        System.out.println("All tests passed!");
    }
}

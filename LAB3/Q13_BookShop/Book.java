package LAB3.Q13_BookShop;


public class Book {
    private String title;
    private String author;
    private double price;
    private String publisher;
    private int stock;

    public Book(String title, String author, double price,
                String publisher, int stock) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.publisher = publisher;
        this.stock = stock;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getStock() {
        return stock;
    }

    public boolean hasStock(int copies) {
        return stock >= copies;
    }

    public void addStock(int copies) {
        stock += copies;
    }

    public void removeStock(int copies) {
        stock -= copies;
    }

    public double getPrice(int copies) {
        return price * copies;
    }

    @Override
    public String toString() {
        return "\nTitle: " + title
                + "\nAuthor: " + author
                + "\nPrice: " + price
                + "\nPublisher: " + publisher
                + "\nStock: " + stock;
    }
}


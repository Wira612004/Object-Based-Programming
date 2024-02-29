// Wira Harsa Abiyasa Rifki Ghani | TI22I
// Task 2 Object Based Programming

class Square {
    double width;
    double height;

    public Square(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getLuas() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }
}

class Book {
    String author;
    String title;
    double price;
    int publisherNumber;

    public Book(String author, String title, double price, int publisherNumber) {
        this.author = author;
        this.title = title;
        this.price = price;
        this.publisherNumber = publisherNumber;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return "Book: " + title + " by " + author + ", Price: $" + price + ", Publisher Number: " + publisherNumber;
    }
}

public class OBPTask2 {
    public static void main(String[] args) {
        Book book1 = new Book("J.K. Rowling", "Harry Potter and the Philosopher's Stone", 180000, 123456);
        Book book2 = new Book("George Orwell", "1984", 134000, 789012);
        Book book3 = new Book("Harper Lee", "To Kill a Mockingbird", 150000, 345678);

        Square square = new Square(8, 14);

        double totalPrice = book1.getPrice() + book2.getPrice() + book3.getPrice();

        System.out.println("Square Properties:");
        System.out.println("Width: " + square.width);
        System.out.println("Height: " + square.height);
        System.out.println("Area: " + square.getLuas());
        System.out.println("Perimeter: " + square.getPerimeter());

        System.out.println("\nBooks:");
        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);

        System.out.println("\nTotal price for all books: IDR " + totalPrice);
    }
}

import java.util.ArrayList;
import java.util.Scanner;

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

public class BookShop {
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Book> trolley = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in); // Creating scanner object as a class variable

    public static void main(String[] args) {
        // Populate books
        books.add(new Book("J.K. Rowling", "Harry Potter and the Philosopher's Stone", 10, 123456));
        books.add(new Book("George Orwell", "1984", 8, 789012));
        books.add(new Book("Harper Lee", "To Kill a Mockingbird", 12, 345678));
        books.add(new Book("Keigo Higashino", "newcomer", 15, 334122));
        books.add(new Book("Adolf Hitler", "Mein Kampf", 69, 911939));
        books.add(new Book("Oliver Bowden", "Assassin's Creed", 12, 987201));

        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. List Books");
            System.out.println("2. My Trolley");
            System.out.println("3. Search Book Info");
            System.out.println("4. Buy Book");
            System.out.println("5. Buy Book from Trolley");
            System.out.println("6. Checkout");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    listBooks();
                    break;
                case 2:
                    showTrolley();
                    break;
                case 3:
                    searchBookInfo();
                    break;
                case 4:
                    buyBook();
                    break;
                case 5:
                    buyBookFromTrolley();
                    break;
                case 6:
                    generateReceipt();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 7.");
            }
        } while (choice != 7);

        scanner.close(); // Closing the scanner object when the program ends
    }

    static void listBooks() {
        System.out.println("\nList of Books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    static void showTrolley() {
        System.out.println("\nYour Trolley:");
        for (Book book : trolley) {
            System.out.println(book);
        }
    }

    static void searchBookInfo() {
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter book title to search: ");
        String searchTitle = scanner.nextLine();

        boolean found = false;
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(searchTitle)) {
                System.out.println("\nBook Info:");
                System.out.println(book);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book not found!");
        }
    }

    static void buyBook() {
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter book title to buy: ");
        String buyTitle = scanner.nextLine();

        for (Book book : books) {
            if (book.title.equalsIgnoreCase(buyTitle)) {
                trolley.add(book);
                System.out.println("Book added to your trolley!");
                return;
            }
        }
        System.out.println("Book not found!");
    }

    static void buyBookFromTrolley() {
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter book title from trolley to buy: ");
        String buyTitle = scanner.nextLine();

        for (Book book : trolley) {
            if (book.title.equalsIgnoreCase(buyTitle)) {
                trolley.remove(book);
                System.out.println("Book bought from your trolley!");
                return;
            }
        }
        System.out.println("Book not found in your trolley!");
    }

    static void generateReceipt() {
        double total = 0;
        System.out.println("\n=====================");
        System.out.println("       RECEIPT       ");
        System.out.println("=====================");
        for (Book book : trolley) {
            System.out.printf("%-35s $%.2f%n", book.title + " by " + book.author, book.price);
            total += book.price;
        }
        System.out.println("---------------------");
        System.out.printf("%-35s $%.2f%n", "Total:", total);
        System.out.println("=====================");
    }
    
}

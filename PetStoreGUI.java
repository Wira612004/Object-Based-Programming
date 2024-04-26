import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

// Base class representing a product
abstract class Product {
    private int productId;
    private String name;
    private double price;
    private int quantity;

    public Product(int productId, String name, double price, int quantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void updateQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract String getProductDetails();
}

// Subclass representing pet food
class Food extends Product {
    private String flavor;

    public Food(int productId, String name, double price, int quantity, String flavor) {
        super(productId, name, price, quantity);
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }

    @Override
    public String getProductDetails() {
        return "Product ID: " + getProductId() + ", Name: " + getName() + ", Price: IDR " + getPrice() +
                ", Quantity: " + getQuantity() + ", Flavor: " + flavor;
    }
}

// Subclass representing pet toy
class Toy extends Product {
    private String type;

    public Toy(int productId, String name, double price, int quantity, String type) {
        super(productId, name, price, quantity);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String getProductDetails() {
        return "Product ID: " + getProductId() + ", Name: " + getName() + ", Price: IDR " + getPrice() +
                ", Quantity: " + getQuantity() + ", Type: " + type;
    }
}

// Database class to manage products
class Database {
    private java.util.Map<Integer, Product> products;

    public Database() {
        products = new java.util.HashMap<>();
    }

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    public Product getProduct(int productId) {
        return products.get(productId);
    }

    public Collection<Product> getAllProducts() {
        return products.values();
    }
}

public class PetStoreGUI extends JFrame {
    private static final long serialVersionUID = 1L;

    private static Database database;
    private static java.util.List<Product> shoppingCart;

    public PetStoreGUI() {
        database = new Database();
        loadProducts();

        shoppingCart = new java.util.ArrayList<>();

        setTitle("Pet Store");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JTextArea productTextArea = new JTextArea();
        productTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(productTextArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JButton viewProductsBtn = new JButton("View Products");
        viewProductsBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Available Products:\n");
                for (Product product : database.getAllProducts()) {
                    sb.append(product.getProductDetails()).append("\n");
                }
                productTextArea.setText(sb.toString());
            }
        });

        JButton viewCartBtn = new JButton("View Cart");
        viewCartBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Shopping Cart:\n");
                for (Product product : shoppingCart) {
                    sb.append(product.getProductDetails()).append("\n");
                }
                productTextArea.setText(sb.toString());
            }
        });

        JButton checkoutBtn = new JButton("Checkout");
        checkoutBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double total = 0;
                StringBuilder sb = new StringBuilder();
                sb.append("Shopping Receipt:\n");
                sb.append("-----------------------------------------\n");
                for (Product product : shoppingCart) {
                    sb.append(product.getProductDetails()).append("\n");
                    total += product.getPrice() * product.getQuantity(); // Updated to include quantity
                }
                sb.append("-----------------------------------------\n");
                sb.append("Total amount to pay: IDR ").append(total).append("\n");
                JOptionPane.showMessageDialog(null, sb.toString(), "Checkout", JOptionPane.INFORMATION_MESSAGE);
                shoppingCart.clear();
            }
        });

        JButton addToCartBtn = new JButton("Add to Cart");
        addToCartBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String productIdStr = JOptionPane.showInputDialog("Enter the Product ID to add to cart:");
                try {
                    int productId = Integer.parseInt(productIdStr);
                    Product product = database.getProduct(productId);
                    if (product != null) {
                        String quantityStr = JOptionPane.showInputDialog("Enter the quantity:");
                        int quantity = Integer.parseInt(quantityStr);
                        if (quantity <= product.getQuantity()) {
                            product.updateQuantity(product.getQuantity() - quantity);
                            Product productCopy = product instanceof Food ?
                                    new Food(product.getProductId(), product.getName(), product.getPrice(), quantity, ((Food) product).getFlavor()) :
                                    new Toy(product.getProductId(), product.getName(), product.getPrice(), quantity, ((Toy) product).getType());
                            shoppingCart.add(productCopy);
                            JOptionPane.showMessageDialog(null, productCopy.getName() + " (x" + quantity + ") has been added to the cart.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Not enough quantity available.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Product not found.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid product ID or quantity. Please enter valid numbers.");
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(viewProductsBtn);
        buttonPanel.add(viewCartBtn);
        buttonPanel.add(checkoutBtn);
        buttonPanel.add(addToCartBtn);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setVisible(true);
    }

    // Method to load products
    private static void loadProducts() {
        // Simulated product data
        database.addProduct(new Food(101, "Dog Food", 21000, 10, "Chicken Flavor"));
        database.addProduct(new Toy(102, "Cat Toy", 15000, 15, "Ball"));
        database.addProduct(new Food(103, "Cat Food", 30000, 45, "Shark with Rendang seasoning"));
        database.addProduct(new Toy(104, "Dog Toy", 18000, 20, "Rubber Bone"));
    }

    public static void main(String[] args) {
        new PetStoreGUI();
    }
}

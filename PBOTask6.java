// PBO Task 6
// Wira Harsa ARG | 20220040142
// TI22I

// Shape interface
interface Shape {
    double getPerimeter();
    double getArea();
}

// Rectangle class implementing Shape
class Rectangle implements Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double getPerimeter() {
        return 2 * (length + width);
    }

    @Override
    public double getArea() {
        return length * width;
    }
}

// Square class extending Rectangle
class Square extends Rectangle {
    public Square(double side) {
        super(side, side);
    }
}

// Circle class implementing Shape
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

// Abstract Triangle class implementing Shape
abstract class Triangle implements Shape {
    // Abstract method to calculate the area of the triangle
    public abstract double getArea();
}

// Geometry interface
interface Geometry {
    double getVolume();
    double getBaseArea(Shape shape);
}

// Cube class implementing Geometry
class Cube implements Geometry {
    private double side;

    public Cube(double side) {
        this.side = side;
    }

    @Override
    public double getVolume() {
        return side * side * side;
    }

    @Override
    public double getBaseArea(Shape shape) {
        return shape.getArea();
    }
}

// Prism class implementing Geometry
class Prism implements Geometry {
    private double height;
    private Shape base;

    public Prism(double height, Shape base) {
        this.height = height;
        this.base = base;
    }

    @Override
    public double getVolume() {
        return height * base.getArea();
    }

    @Override
    public double getBaseArea(Shape shape) {
        return shape.getArea();
    }
}

// Cylinder class implementing Geometry
class Cylinder implements Geometry {
    private double radius;
    private double height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double getVolume() {
        return Math.PI * radius * radius * height;
    }

    @Override
    public double getBaseArea(Shape shape) {
        return shape.getArea();
    }
}

// Block class implementing Geometry
class Block implements Geometry {
    private double length;
    private double width;
    private double height;

    public Block(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public double getVolume() {
        return length * width * height;
    }

    @Override
    public double getBaseArea(Shape shape) {
        return shape.getArea();
    }
}

// Main class with main method
public class PBOTask6 {
    public static void main(String[] args) {
        // Creating instances and demonstrating functionality
        Rectangle rectangle = new Rectangle(5, 4);
        System.out.println("Rectangle Area: " + rectangle.getArea());
        System.out.println("Rectangle Perimeter: " + rectangle.getPerimeter());

        Square square = new Square(5);
        System.out.println("Square Area: " + square.getArea());
        System.out.println("Square Perimeter: " + square.getPerimeter());

        Circle circle = new Circle(3);
        System.out.println("Circle Area: " + circle.getArea());
        System.out.println("Circle Perimeter: " + circle.getPerimeter());

        Cube cube = new Cube(3);
        System.out.println("Cube Volume: " + cube.getVolume());

        Prism prism = new Prism(4, rectangle);
        System.out.println("Prism Volume: " + prism.getVolume());

        Cylinder cylinder = new Cylinder(3, 5);
        System.out.println("Cylinder Volume: " + cylinder.getVolume());

        Block block = new Block(3, 4, 5);
        System.out.println("Block Volume: " + block.getVolume());
    }
}


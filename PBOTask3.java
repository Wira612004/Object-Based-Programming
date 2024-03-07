// Wira Harsa | TI22I
// Object Based Programming | Task 3


import java.lang.Math;

class Shape {
    public double area() {
        return 0.0;
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double area() {
        return width * height;
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }
}

class Triangle extends Shape {
    protected double side1;
    protected double side2;
    protected double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double area() {
        // Heron's formula for area of a triangle
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
}

class RightTriangle extends Triangle {
    public RightTriangle(double base, double height) {
        super(base, height, Math.sqrt(base * base + height * height));
    }
}

class EquilateralTriangle extends Triangle {
    public EquilateralTriangle(double side) {
        super(side, side, side);
    }
}

class IsoscelesTriangle extends Triangle {
    public IsoscelesTriangle(double base, double side) {
        super(base, side, side);
    }
}

class AnyTriangle extends Triangle {
    public AnyTriangle(double side1, double side2, double side3) {
        super(side1, side2, side3);
    }
}

public class PBOTask3 {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(4, 5);
        System.out.println("Area of rectangle: " + rectangle.area());

        Circle circle = new Circle(3);
        System.out.println("Area of circle: " + circle.area());

        RightTriangle rightTriangle = new RightTriangle(3, 4);
        System.out.println("Area of right triangle: " + rightTriangle.area());

        EquilateralTriangle equilateralTriangle = new EquilateralTriangle(5);
        System.out.println("Area of equilateral triangle: " + equilateralTriangle.area());

        IsoscelesTriangle isoscelesTriangle = new IsoscelesTriangle(4, 6);
        System.out.println("Area of isosceles triangle: " + isoscelesTriangle.area());

        AnyTriangle anyTriangle = new AnyTriangle(7, 8, 9);
        System.out.println("Area of any triangle: " + anyTriangle.area());
    }
}

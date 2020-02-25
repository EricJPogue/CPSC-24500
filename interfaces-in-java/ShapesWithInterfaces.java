/*
    An interface is 100% abstract class and has only abstract methods.
    Class can implement any number of interfaces.

    abstract public double CalcArea();
    abstract public double CalcPerimeter();
*/

//**************************************
//************************************************
//**********************************************************

// Interfaces
interface ShapeInterface {
    public double CalculateArea();
    public double CalculatePerimeter();

    // Todo: Add other useful Shape related methods like Draw().
}

// Class
class Shape {
	protected int width; // Attributes or Member Veriables
    protected int height;

    // Constructors
    public Shape(int widthIn, int heightIn) {
        width = widthIn;
        height = heightIn;
    }

    // Methods or Member Functions
    public String toString()  {
        return "W=" + width + " H=" + height;
    }
}

class Rectangle extends Shape implements ShapeInterface {
    public Rectangle(int widthIn, int heightIn) {
        super(widthIn, heightIn);
    }

    public double CalculateArea() {
        return width * height;
    }

    public double CalculatePerimeter() {
        return width + width + height + height;
    }
}

class Square extends Rectangle implements ShapeInterface {
    public Square(int widthIn) {
        super(widthIn, widthIn /* height = width for a square */);
    }
}

class Circle extends Shape implements ShapeInterface {
    public Circle(int widthIn, int heightIn) {
        super(widthIn, heightIn);
    }

    public double CalculateArea() {
        // Radius is equal to width / 2
        return Math.PI * (width/2) * (width/2);
    }

    public double CalculatePerimeter() {
        // Width and height must be equal in a circle.
        double radius = width/2;
        double perimeter = 2 * Math.PI * radius;
        return perimeter;
    }
}

public class ShapesWithInterfaces {
	public static void main(String[] args) {
        System.out.println();
         
        // Objects
        Shape myShape = new Shape(100, 100);
        System.out.println("Shape: " + myShape);   
		System.out.println();        

		Rectangle myRectangle  = new Rectangle(100, 100);
        System.out.println("Rectangle: " + myRectangle);
        System.out.printf("Rectangle Area: %.2f", myRectangle.CalculateArea());
		System.out.println();        


		Circle myCircle = new Circle(100, 100);
        System.out.println("Circle: " + myCircle);
        System.out.printf("Circle Area: %.2f\n", myCircle.CalculateArea());
        System.out.println();        


        Shape myTestShape = new Circle(100, 100);

        ShapeInterface myShapeInterface = (ShapeInterface) myTestShape;
        System.out.printf("ShapeInterface Area: %.2f\n", myShapeInterface.CalculateArea());



	}
}


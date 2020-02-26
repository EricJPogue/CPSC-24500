/*
    Shapes with Interfaces demonstrate Classes, Objects, 
	Encapsulation, Inheritance, Polymorphism, and Interfaces 
	utilizing Shapes. 
*/

// Interface
interface ShapeInterface {
    public double CalculateArea();
    public double CalculatePerimeter();

    // Todo: Add other useful Shape related 
	// methods like Paint() or Resize().  
}

// Class
class Shape {
	protected int width; // Attributes or Member Variables
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
 
	// Alternatively Abstraction could be implemented with:
	//   abstract public double CalculateArea();
    //   abstract public double CalculatePerimeter();
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
        super(widthIn, widthIn /* width & height are equal for a square */);
    }
}

class Circle extends Shape implements ShapeInterface {
    public Circle(int widthIn) {
        super(widthIn, widthIn /* width & height are equal for a circle */);
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

        // Shape
        Shape myShape = new Shape(100, 100);
        System.out.println("\nShape: " + myShape + "\n");   

		// Rectangle 
		Rectangle myRectangle  = new Rectangle(100, 200);

        System.out.println("Rectangle:" + myRectangle);
        System.out.printf("Area=%.2f\n", myRectangle.CalculateArea());
        System.out.printf("Perimeter=%.2f\n\n", 
			myRectangle.CalculatePerimeter());

		// Circle
		Circle myCircle = new Circle(50);

        System.out.println("Circle:" + myCircle);
        System.out.printf("Area=%.2f\n", myCircle.CalculateArea());
        System.out.printf("Perimeter=%.2f\n\n", 
			myCircle.CalculatePerimeter());

		// Circle assigned to a Shape typecast to a ShapeInterface
        Shape myS = new Circle(35);
        ShapeInterface myShapeInterface = (ShapeInterface) myS;

        System.out.println("Circle(35) assigned to a Shape:");
        System.out.printf("Area=%.2f\n", myShapeInterface.CalculateArea());
        System.out.printf("Perimeter=%.2f\n\n", 
			myShapeInterface.CalculatePerimeter());

		// Array of Shapes polymorphically assigned Circles, Rectangles,
		// and Squares 
		System.out.println("Polymorphic Array:");
		Shape[] shapes = new Shape[4];
		shapes[0] = new Circle(75);
		shapes[1] = new Rectangle(100,200);
		shapes[2] = new Square(50);
		shapes[3] = new Rectangle(50,25);

		for (Shape s : shapes) {
			ShapeInterface mySI = (ShapeInterface)s;

			System.out.println(s.getClass());
        	System.out.printf("Area=%.2f\n", mySI.CalculateArea());
        	System.out.printf("Perimeter=%.2f\n\n", 
				mySI.CalculatePerimeter());
		}
	}
}


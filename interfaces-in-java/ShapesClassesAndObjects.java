//**************************************
//************************************************
//**********************************************************
// Classes & Objects

// Class
class Shape {
	int width;
	int height;
}

public class ShapesClassesAndObjects {
	public static void main(String[] args) {

		// Object
		Shape myShape = new Shape();
		myShape.width = 100;
		myShape.height = 100;
		System.out.println("W="+myShape.width+
			"H="+myShape.height);
	}
}


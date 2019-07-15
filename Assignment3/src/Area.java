import java.util.Scanner;

/**
 * @author vrinda
 *
 */

class Shape {
	/**
	 * @param width
	 * @param height
	 * @return area of rectangle
	 */
	@SuppressWarnings("finally")
	double rectangle(double width, double height) {
		try {
			double result = width * height;
			return result;
		} catch (ArithmeticException e) {
			System.out.println("Exception occured");
		} finally {
			return width * height;
		}
	}

	/**
	 * @param width
	 * @param height
	 * @return area of triangle
	 */
	double triangle(double width, double height) {
		try {
			double result = 0.5 * width * height;
			return result;
		} catch (ArithmeticException e) {
			System.out.println("Exception occured");
		} finally {
			return 0.5 * width * height;
		}
	}

	/**
	 * @param width
	 * @return area of square
	 */
	double square(double width) {
		try {
			double result = width * width;
			return result;
		} catch (ArithmeticException e) {
			System.out.println("Exception occured");
		} finally {
			return width * width;
		}
	}

	/**
	 * @param radius
	 * @return area of circle
	 */
	double circle(double radius) {
		double pi = 3.14;
		try {
			double result = pi * radius * radius;
			return result;
		} catch (ArithmeticException e) {
			System.out.println("Exception occured");
		} finally {
			return pi * radius * radius;
		}
	}
}

public class Area {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		Shape area = new Shape();
		System.out.println("Chose the shape whose area you want to calculate");
		System.out.println("1.)Rectangle\t2.)Triangle\t3.)Square\t4.)Circle");
		int shape = sc.nextInt();
		try{
			switch (shape){
			case 1 :
				System.out.println("Enter the width and height");
				double width = sc.nextDouble();
				double height = sc.nextDouble();
				System.out.println( "Rectangle area " + area.rectangle(width, height));
				break;
			case 2 :
				System.out.println("Enter the width and height");
				double widthTriangle = sc.nextDouble();
				double heightTriangle = sc.nextDouble();
				System.out.println( "Triangle area " + area.triangle(widthTriangle, heightTriangle));
				break;
			case 3 :
				System.out.println("Enter the width ");
				double widthSquare = sc.nextDouble();
				System.out.println( "Square area " + area.square(widthSquare));
				break;
			case 4 :
				System.out.println("Enter the radius");
				double radius = sc.nextDouble();
				System.out.println( "Circle area " + area.square(radius));
				break;
			}
		}
		catch (Exception e){
			System.out.println("Please enter valid number");
		}
		
	}
}
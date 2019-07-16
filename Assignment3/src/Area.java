import java.util.Scanner;
class Shape{
    /** calculates area of rectangle
     * @param width : width of rectangle
     * @param height : height of rectangle
     * @return (width * height)
     */
    double getRectangleArea(double width, double height){
        try{
	    double result = width * height;
	} 
	catch (ArithmeticException e){
	    System.out.println("Exception occured");
	} 
	finally{
	    return width * height;
	}
    }
    /** calculates area of triangle
     * @param base : base of triangle
     * @param height : height of triangle
     * @return base*height/2
     */
    double getTriangleArea(double base, double height){
        double halfConstant = 0.5;
	try{
	     double result = halfConstant * base * height;
	} 
	catch (ArithmeticException e){
	    System.out.println("Exception occured");
	} 
	finally{
	    return halfConstant * base * height;
	}
    }

    /**
     * calculates area of square 
     * @param width : width of square
     * @return width*width
     */
     double getSquareArea(double width){
         try{
	     double result = width * width;
	 } 
         catch (ArithmeticException e){
	     System.out.println("Exception occured");
	 } 
	 finally{
	     return width * width;
	 }
     }
     /**
      * calculates area of circle
      * @param radius :radius of circle
      * @return pi*radius*radius
      */
     double getCircleArea(double radius){
         double pi = 3.14;
	 try{
	     double result = pi * radius * radius;
	 } 
	 catch (ArithmeticException e){
	     System.out.println("Exception occured");
	 } 
	 finally{
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
		System.out.println( "Rectangle area " + area.getRectangleArea(width, height));
		break;
	 case 2 :
		System.out.println("Enter the width and height");
		double widthTriangle = sc.nextDouble();
		double heightTriangle = sc.nextDouble();
		System.out.println( "Triangle area " + area.getTriangleArea(widthTriangle, heightTriangle));
		break;
	 case 3 :
		System.out.println("Enter the width ");
		double widthSquare = sc.nextDouble();
		System.out.println( "Square area " + area.getSquareArea(widthSquare));
		break;
	 case 4 :
		System.out.println("Enter the radius");
		double radius = sc.nextDouble();
		System.out.println( "Circle area " + area.getSquareArea(radius));
		break;
	 default:
		System.out.println("You did not enter number mentioned above");
	 }
     }
     catch (Exception e){
	 System.out.println("Please enter valid number");
     }
   }
}

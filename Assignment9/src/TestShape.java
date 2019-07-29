import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class TestShape {
	
	Screen screen = new Screen();
	List<Integer> parameters = new ArrayList<Integer>();
	@Test
	public void addShapeTest() {
		parameters.add(2);
		parameters.add(3);
		assertTrue(screen.addShape(ShapeType.Rectangle,new Point(2,3),parameters ));
		parameters.clear();
		parameters.add(4);
		assertTrue(screen.addShape(ShapeType.Square,new Point(2,3),parameters ));
		parameters.clear();
		parameters.add(3);
		assertTrue(screen.addShape(ShapeType.Circle,new Point(3,3),parameters ));
		parameters.clear();
	}

	@Test
	public void deleteShapeTest() {
		parameters.add(3);
		screen.addShape(ShapeType.Circle,new Point(3,3),parameters );
		assertTrue(screen.deleteShape(ShapeType.Circle, new Point(3,3),parameters));
		assertFalse(screen.deleteShape(ShapeType.Triangle, new Point(3,3),parameters ));
	}
	@Test
	public void shapeEnclosingPointTest(){
		List<ShapeType> shapeList2 = new ArrayList<ShapeType>();
		List<Shape> shapeListEnclosingPoint2 = new ArrayList<Shape>();
		
		parameters.add(3);
		screen.addShape(ShapeType.Circle,new Point(3,3),parameters );
		Shape shape1 = ShapeFactory.createShape(ShapeType.Circle,new Point(3,3),parameters);
		parameters.clear();
		
		parameters.add(2);
		parameters.add(3);
		screen.addShape(ShapeType.Rectangle,new Point(2,3),parameters );
		Shape shape2 = ShapeFactory.createShape(ShapeType.Rectangle,new Point(2,3),parameters );
		parameters.clear();
		
		parameters.add(20);
		screen.addShape(ShapeType.Square,new Point(60,30),parameters );
		Shape shape3 = ShapeFactory.createShape(ShapeType.Square,new Point(60,30),parameters);
		
		shapeListEnclosingPoint2.add(shape1);
		shapeListEnclosingPoint2.add(shape2);
	
		//assertEquals(shapeListEnclosingPoint2,screen.shapeEnclosingPoint(new Point(3, 3)));
		
		
	}


}

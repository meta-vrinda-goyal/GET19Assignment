import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
public class Triangle implements Shape{
	
	Point originPoint;
	int side1;
	int side2;
	int side3;
	Timestamp timestamp;
	
	public Triangle(Point originPoint, List<Integer> parameters, Timestamp timestamp) {
		this.originPoint = originPoint;
		this.side1 = parameters.get(0);
		this.side2 = parameters.get(1);
		this.side3 = parameters.get(2);	
		this.timestamp = timestamp;
	}
	
	@Override
	public double getArea() {
		double s = getPerimeter()/2;
		return Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));			
	}

	@Override
	public double getPerimeter() {
		return  (side1 + side2 + side3);
	}

	@Override
	public Point getOrigin() {
		return originPoint;
	}

	@Override
	public List<Integer> getParameters() {
		List<Integer> parameters = new ArrayList<Integer>();
		parameters.add(side1);
		parameters.add(side2);
		parameters.add(side3);
		return parameters;
	}
	
	@Override
	public Timestamp getTimestamp() {
		return timestamp;
	}
	
	@Override
	public ShapeType getShapeType() {
		return ShapeType.Triangle;
	}

	@Override
	public boolean isPointEnclosed(Point point) {
		return false;
	}	
}

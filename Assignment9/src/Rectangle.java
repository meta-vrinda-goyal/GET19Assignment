import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Rectangle implements Shape {
	
	Point originPoint;
	int breadth;
	int length;
	Timestamp timestamp;

	public Rectangle(Point originPoint, List<Integer> parameters, Timestamp timestamp) {
		this.originPoint = originPoint;
		this.breadth = parameters.get(0);
		this.length = parameters.get(1);
		this.timestamp = timestamp;
	}

	@Override
	public double getArea() {
		return (breadth * length);
	}

	@Override
	public double getPerimeter() {
		return (2 * breadth * length);
	}

	@Override
	public Point getOrigin() {
		return originPoint;
	}
	
	@Override
	public List<Integer> getParameters() {
		List<Integer> parameters = new ArrayList<Integer>();
		parameters.add(breadth);
		parameters.add(length);
		return parameters;
	}
	
	@Override
	public Timestamp getTimestamp() {
		return timestamp;
	}
	
	@Override
	public ShapeType getShapeType() {
		return ShapeType.Rectangle;
	}

	@Override
	public boolean isPointEnclosed(Point point) {
		double xPodouble=point.getXCoordinate();
		double yPodouble=point.getYCoordinate();
		double xOrigin = originPoint.getXCoordinate();
		double yOrigin = originPoint.getYCoordinate();
		if(xPodouble >= xOrigin && xPodouble <= (xOrigin + breadth) && yPodouble >= yOrigin && yPodouble <= (yOrigin + length)){
			return true;
		}
		return false;
	}
}

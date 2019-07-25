import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Circle implements Shape {
	
	Point originPoint;
	int radius;
	final double pi=3.14;
	Timestamp timestamp;
	
	public Circle(Point originPoint, List<Integer> parameters, Timestamp timestamp) {
		this.originPoint = originPoint;
		this.radius = parameters.get(0);
		this.timestamp = timestamp;
	}
	
	@Override
	public double getArea() {
		return (pi * radius * radius);
	}
	
	@Override
	public double getPerimeter() {
		return (2 * pi * radius);
	}
	
	@Override
	public Point getOrigin() {
		return originPoint;
	}

	@Override
	public List<Integer> getParameters() {
		List<Integer> parameters = new ArrayList<Integer>();
		parameters.add(radius);
		return parameters;
	}

	@Override
	public Timestamp getTimestamp() {
		return timestamp;
	}
	
	@Override
	public ShapeType getShapeType() {
		return ShapeType.Circle;
	}
	
	@Override
	public boolean isPointEnclosed(Point point) {
		double xPoint=point.getXCoordinate();
		double yPoint=point.getYCoordinate();
		double distance = Math.sqrt((Math.pow(originPoint.getXCoordinate(),2)) + (Math.pow(originPoint.getYCoordinate(),2)));
		double factor = distance + radius;
		double xCenter = (factor * originPoint.getXCoordinate())/distance;
		double yCenter = (factor * originPoint.getYCoordinate())/distance;
		if(xPoint >= (xCenter - radius) && xPoint <= (xCenter + radius))
			if(yPoint >= (yCenter - radius) && yPoint <= (yCenter + radius))
				return true;
		return false;
		
	}
}

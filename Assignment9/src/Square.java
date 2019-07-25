import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Square implements Shape {
	
	Point originPoint;
	int side;
	Timestamp timestamp;
	
	public Square(Point originPoint, List<Integer> parameters, Timestamp timestamp) {
		this.originPoint = originPoint;
		this.side = parameters.get(0);
		this.timestamp = timestamp;
	}
	
	@Override
	public double getArea() {
		return (side * side);
	}
	
	@Override
	public double getPerimeter() {
		return (4 * side);
	}
	
	@Override
	public Point getOrigin() {
		return originPoint;
	}
	
	@Override
	public List<Integer> getParameters() {
		List<Integer> parameters = new ArrayList<Integer>();
		parameters.add(side);
		return parameters;
	}
	
	@Override
	public Timestamp getTimestamp() {
		return timestamp;
	}
	
	@Override
	public ShapeType getShapeType() {
		return ShapeType.Square;
	}
	
	@Override
	public boolean isPointEnclosed(Point point) {
		double xPoint=point.getXCoordinate();
		double yPoint=point.getYCoordinate();
		double xOrigin = originPoint.getXCoordinate();
		double yOrigin = originPoint.getYCoordinate();
		if(xPoint >= xOrigin && xPoint <= (xOrigin + side) && yPoint >= yOrigin && yPoint <= (yOrigin + side))
			return true;
		return false;
	}
}

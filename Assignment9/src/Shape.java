import java.sql.Timestamp;
import java.util.List;

public interface Shape {
	
	public double getArea();
	
	public double getPerimeter();
	
	public Point getOrigin();
	
	public List<Integer> getParameters();
	
	public Timestamp getTimestamp();
	
	public ShapeType getShapeType();
	
	public boolean isPointEnclosed(Point point);
}

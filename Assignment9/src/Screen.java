import java.util.ArrayList;
import java.util.List;

public class Screen {
	
	//list of shapes on screen
	List<Shape> shapeList = new ArrayList<Shape>();
	
	/**
	 * @param shapeType of shape
	 * @param point for origin
	 * @param parameters for shape
	 * @return true if successfully add else false
	 */
	public boolean addShape(ShapeType shapeType, Point point, List<Integer> parameters){
		Shape shape = ShapeFactory.createShape(shapeType, point, parameters);
		shapeList.add(shape);
		return true;
	}
	
	public void deleteAllshapes(){
		//clear whole list
		shapeList.clear();
	}
	
	/**
	 * @param shapeType of shape
	 * @param point for origin
	 * @param parameters for shape
	 * @return true if shape is successfully deleted from the list else false(shape does not exist)
	 */
	public boolean deleteShape(ShapeType shapeType, Point point, List<Integer> parameters){
		for(int i = 0; i < shapeList.size(); i++){
			Shape shape = shapeList.get(i);
			//check the shape to be removed
			if(shape.getShapeType().equals(shapeType) && shape.getOrigin().equals(point) && shape.getParameters().equals(parameters)){
				//remove shape from list
				shapeList.remove(i);
				return true;
			}
		}
		//shape not found
		return false;
	}
	
	/**
	 * @param point which is enclosed
	 * @return list of all shapes enclosing that point
	 */
	public List<Shape> shapeEnclosingPoint(Point point){
		//create new list which will consist of all shapes enclosing that point
		List<Shape> shapeListEnclosingPoint = new ArrayList<Shape>();
		//traverse through list
		for(int i = 0; i < shapeList.size(); i++){
			//check if point is enclosed
			if(shapeList.get(i).isPointEnclosed(point)){
				//add that shape to new list
				shapeListEnclosingPoint.add(shapeList.get(i));
			}
		}
		//return new list
		return shapeListEnclosingPoint;
	}
	
	/**
	 * @return list sorted by area
	 */
	public List<Shape> sortByArea(){
		//create new list which have shapes sorted by area
		List<Shape> shapeListSorted = shapeList;
		//Bubble sorting 
		for(int i = 0; i < shapeListSorted.size() - 1; i++){
			for(int j = 0; j < shapeListSorted.size() -1 -i; j++){
				//comparing arae
				if(shapeListSorted.get(j).getArea() > shapeListSorted.get(j + 1).getArea()){
					swap(shapeListSorted, j);
				}
			}
		}
		//return sorted list
		return shapeListSorted;
	}
	
	/**
	 * @return list sorted by perimeter
	 */
	public List<Shape> sortByPerimeter(){
		//create new list which have shapes sorted by perimeter
		List<Shape> shapeListSorted = shapeList;
		//Bubble sorting 
		for(int i = 0; i < shapeListSorted.size() - 1; i++){
			for(int j = 0; j < shapeListSorted.size() -1 -i; j++){
				//comparing perimeter
				if(shapeListSorted.get(j).getPerimeter() > shapeListSorted.get(j + 1).getPerimeter()){
					swap(shapeListSorted, j);
				}
			}
		}
		//return sorted list
		return shapeListSorted;
	}
	
	/**
	 * @return list sorted by timestamp
	 */
	public List<Shape> sortByTimestamp(){
		//create new list which have shapes sorted by timestamp
		List<Shape> shapeListSorted = shapeList;
		//Bubble sorting
		for(int i = 0; i < shapeListSorted.size() - 1; i++){
			//comparing timestamp
			for(int j = 0; j < shapeListSorted.size() -1 -i; j++){
				if(shapeListSorted.get(j).getTimestamp().after(shapeListSorted.get(j + 1).getTimestamp())){
					swap(shapeListSorted, j);
				}
			}
		}
		//return sorted list
		return shapeListSorted;
	}
	
	/**
	 * @return list sorted by distance from origin
	 */
	public List<Shape> sortByOriginDistance(){
		// distance of shape from origin
		double distance1;
		double distance2;
		// x coordinate of shape 
		double shape1XOrigin;
		double shape2XOrigin;
		// y coordinate of shape
		double shape1YOrigin;
		double shape2YOrigin;
		//create new list which have shapes sorted by distance from origin
		List<Shape> shapeListSorted = shapeList;
		for(int i = 0; i < shapeListSorted.size() - 1; i++){
			for(int j = 0; j < shapeListSorted.size() -1 -i; j++){
	            shape1XOrigin = shapeListSorted.get(j).getOrigin().getXCoordinate();
	            shape2XOrigin = shapeListSorted.get(j + 1).getOrigin().getXCoordinate();
	            shape1YOrigin = shapeListSorted.get(j).getOrigin().getYCoordinate();
	            shape2YOrigin = shapeListSorted.get(j + 1).getOrigin().getYCoordinate();
	            distance1 = Math.sqrt((Math.pow(shape1XOrigin,2)) + (Math.pow(shape1YOrigin,2)));
	            distance2 = Math.sqrt((Math.pow(shape2XOrigin,2)) + (Math.pow(shape2YOrigin,2)));
				//comparing distance of both shape 
	            if(distance1 > distance2){
					swap(shapeListSorted, j);
				}
			}
		}
		//return sorted list
		return shapeListSorted;
	}

	/**
	 * @param shapeListSorted sorted shape list
	 * @param j index
	 */
	private void swap(List<Shape> shapeListSorted, int j) {
		//swapping the values at adjacent indexes 
		Shape shape = shapeListSorted.get(j);
		shapeListSorted.set(j,shapeListSorted.get(j+1));
		shapeListSorted.set(j + 1,shape);
	}
}

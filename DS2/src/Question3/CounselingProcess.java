package Question3;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class CounselingProcess {
	//map for storing programs and it's quantity
	static Map<String, Integer> programs = new HashMap<String, Integer>();
	//Queue for storing student
	static Queue students = new Queue(10);

	/**
	 * method to read excel file and storing data
	 */
	private static void readExcelFile() {
		//reading file "counselling"
		File file = new File("counselling.xls");
		//variable for storing key
		String key = "";
		try {
			//getting workbook
			Workbook workbook = Workbook.getWorkbook(file);
			//getting sheet of programs
			Sheet sheet = workbook.getSheet(0);
			//traversing the sheet
			for (int i = 0; i < sheet.getRows(); i++) {
				for (int j = 0; j < sheet.getColumns(); j++) {
					//getting cell
					Cell cell = sheet.getCell(j, i);
					//if cell is name
					if (cell.getType() == CellType.LABEL){
						key = cell.getContents();
					}
					//if cell is number
					else{
						programs.put(key, Integer.parseInt(cell.getContents()));
					}
				}
			}
			//getting sheet of students
			sheet = workbook.getSheet(1);
			//traversing the sheet
			for (int i = 0; i < sheet.getRows(); i++) {
				//creating new student object
				Student student = new Student();
				//array for storing preference
				String[] preference = new String[5];
				for (int j = 0; j < sheet.getColumns(); j++) {
					Cell cell = sheet.getCell(j, i);
					//if first col then get name
					if (j == 0){
						student.setName(cell.getContents());
					}
					//store preferences in array
					else{
						preference[j - 1] = cell.getContents();
					}
				}
				//add student object in queue
				student.setPreference(preference);
				students.enqueue(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * method to allocate program
	 */
	public static void allocateProgram(){
		try {
			//workbook for writing
			WritableWorkbook workbook =Workbook.createWorkbook(new File("result.xls"));
			//sheet for writing
			WritableSheet sheet=workbook.createSheet("sheet1", 0);
			//starting row = 0;
			int rowNo = 0;
			for(int i = 0; i<10; i++){
				//dequeue student from queue
				Student student=students.dequeue();
				for(int j=0;j<5;j++){
					//if student preference is not full
					if(programs.get(student.getPreference()[j])>0){
						//get label as name
						Label name=new Label(0,rowNo,student.getName());
						//store name
						sheet.addCell(name);
						//get label as preference
						Label program=new Label(1,rowNo++,student.getPreference()[j]);
						//store preference
						sheet.addCell(program);
						//update capacity of program in hashmap
						programs.put(student.getPreference()[j], programs.get(student.getPreference()[j])-1);
						break;
					}
				}
			}
			workbook.write();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public static void main(String[] arg){
		readExcelFile();
		allocateProgram();
	}
}

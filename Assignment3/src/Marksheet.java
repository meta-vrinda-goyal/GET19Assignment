import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Marksheet{
	Scanner in = new Scanner(System.in);
	private float[] grades; // array to store the grades of students
	final float minGrade = 0;
	final float maxGrade = 100;
	String noOfStudents; //String variable for getting number of students from user in the form of string
	int totalStudents;	 //for storing number of students in integer form
	
    /**
     * checks whether input string is number or not
     * @param s string
     * @return true if number else false
     */
    boolean isNumber(String s){ 
        for(int i = 0; i < s.length(); i++){
        	if (!(Character.isDigit(s.charAt(i)))){
        		return false;
        	}
        }
        return true; 
    } 
	/**
	 * gets the grades from user and stores in an array
	 */
	void getGrades(){
		float grade;
        System.out.print("Enter the number of students.");
        /* Taking input as total number of students*/
	    do{
			System.out.println("No of students should be positive integer");
			noOfStudents = in.nextLine();
		} while (!isNumber(noOfStudents) || Integer.parseInt(noOfStudents)==0); //checks whether number of students is a positive integer
		
		totalStudents=Integer.parseInt(noOfStudents); //string converted to integer
        grades = new float[totalStudents];
        
        /*taking input as grades*/
        int i = 0;
		while (i < totalStudents){
			System.out.printf("Enter the grade for student" + (i + 1));
			String gradeInput;
			/*grade entered should be b/w 0 and 100*/
			do{
				System.out.println("Grade must be integer between 0 and 100!");
				gradeInput = in.nextLine();
				
			} while (!isNumber(gradeInput) || Integer.parseInt(gradeInput)<0 || Integer.parseInt(gradeInput)>100);
			grade=Integer.parseInt(gradeInput);
			grades[i] = grade;
			i++;
		}
	}

	/**
	 * calculates average of all grades
	 * @return average/(grades.length)
	 */
	float getAverage(){
		float average = 0;
        try{
			for (int i = 0; i < grades.length; i++){
			    average += grades[i];
			}
			return (average / grades.length);
		} 
		catch (Exception e){
			return (average / grades.length);
			}
	}
	

	/**
	 * calculate maximum grade obtained
	 * @return maxGrade
	 */
	float getMaxGrade(){
		float maxGrade = -1;
		try{
			maxGrade = grades[0];
			for(int i = 1; i < grades.length; i++){
				if (grades[i] > maxGrade){
					maxGrade = grades[i];
				}
			}
			return maxGrade;
		}
		catch (Exception e){
			System.out.println("Cannot calculate maximum grade");
			return maxGrade;
		}
	}

	/**
	 * minimum among all grades
	 * @return minGrade
	 */
	float getMinGrade(){
		float minGrade = -1;
		try{
			minGrade = grades[0];
			for (int i = 1; i < grades.length; i++){
				if (grades[i] < minGrade){
					minGrade = grades[i];
				}
			}
			return minGrade;
		} 
		catch (Exception e){
			System.out.println("Cannot calculate minimum grade");
			return minGrade;
		}

	}

	/**
	 * calculates percentage of students passed
	 * @return (noOfPassed / grades.length) * 100
	 */
	float perOfPassed(){
		float noOfPassed = 0;
		float passPercentage = 40; // passing percentage is 40
		try{
			for (int i = 0; i < grades.length; i++){
			    if (grades[i] >= passPercentage){
					noOfPassed++;
				}
			}
			return (noOfPassed / grades.length) * 100;
		}
		catch(Exception e){
			System.out.println("Cannot calculate number of students passed");
			return (noOfPassed / grades.length) * 100; 
			
		}
	}

	public static void main(String[] args) {
		Marksheet marksheet = new Marksheet();
		marksheet.getGrades();
		System.out.printf("Average is %.2f\n" , marksheet.getAverage());
		System.out.printf("Minimum is %.2f\n" , marksheet.getMinGrade());
		System.out.printf("Maximum is %.2f\n" , marksheet.getMaxGrade());
		System.out.printf("Percentage of students passed is %.2f\n" , marksheet.perOfPassed());
	}

}

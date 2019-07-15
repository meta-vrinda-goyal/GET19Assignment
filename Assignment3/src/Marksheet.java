import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Marksheet {
	Scanner in = new Scanner(System.in);
	private float[] grades; // array to store the grades of students
	final float minGrade = 0;
	final float maxGrade = 100;
	boolean validinput = false;
	boolean validinput2 = true;
	int noOfStudents;

	/**
	 * getting the grades from user and storing in an array
	 */
	void getGrades() {

		System.out.print("Enter the number of students: ");
		try {
			noOfStudents = in.nextInt();

		} catch (Exception e) {
			System.out.println("Invalid value");

		}

		grades = new float[noOfStudents];

		int i = 0;
		while (i < noOfStudents) {
			System.out.printf("Enter the grade for student" + (i + 1));
			float grade = in.nextInt();
			if (grade >= minGrade && grade <= maxGrade) {
				grades[i] = grade;
				i++;
			} else {
				System.out.println("Error! Grade must be integer between 0 and 100!");
			}
		}
	}

	/**
	 * @return the average of grades
	 */
	float average() {
		float avg = 0;
		try {

			for (int i = 0; i < grades.length; i++) {
				avg += grades[i];
			}
			return (avg / grades.length);
		} catch (Exception e) {

			return (avg / grades.length);
		}
	}

	/**
	 * @return maximum among all grades
	 */
	float max() {
		float max = -1;

		try {
			max = grades[0];
			for (int i = 1; i < grades.length; i++) {
				if (grades[i] > max)
					max = grades[i];
			}
			return max;
		} catch (Exception e) {
			System.out.println("Error ! Array index out of bound");
			return max;
		}

	}

	/**
	 * @return minimum among all grades
	 */
	float min() {
		float min = -1;
		try {
			min = grades[0];
			for (int i = 1; i < grades.length; i++) {
				if (grades[i] < min)
					min = grades[i];
			}
			return min;
		} catch (Exception e) {
			System.out.println("Error ! Array index out of bound");
			return min;
		}

	}

	/**
	 * @return percentage of students passed
	 */
	float perOfPassed() {
		float pass = 0;
		float passPercentage = 40; // passing percentage is 40
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] >= passPercentage)
				pass++;
		}
		// System.print
		return (pass / grades.length) * 100;

	}

	public static void main(String[] args) {
		Marksheet marksheet = new Marksheet();

		marksheet.getGrades();
		System.out.printf("Average is %.2f\n" , marksheet.average());
		System.out.printf("Minimum is %.2f\n" , marksheet.min());
		System.out.printf("Maximum is %.2f\n" , marksheet.max());
		System.out.printf("Percentage of students passed is %.2f\n" , marksheet.perOfPassed());
	}

}

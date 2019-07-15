import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * JobScheduler of FCFS algorithm which computes completion time,waiting time, turnaround time of each
 * process and average waiting time and maximum waiting time 
 * 
 */
public class JobScheduler {

	List<Integer> completionTimeList = new ArrayList<Integer>();
	List<Integer> waitingTimeList = new ArrayList<Integer>();
	List<Integer> turnAroundTimeList = new ArrayList<Integer>();

	public void print2D(int mat[][]) {
		// Loop through all rows
		for (int i = 0; i < mat.length; i++)

			// Loop through all elements of current row
			for (int j = 0; j < mat[i].length; j++)
				System.out.print(mat[i][j] + " ");
	}

	public List<Integer> completionTime(int arr[][], int noOfProcess) {
		int sum = 0; // sum stores the total time of execution
		for (int i = 0, j = 0; i < noOfProcess; i++) {
			/*
			 * if process arrives after the execution of previous process completion time
			 * will be arrival time + burst time
			 */
			if (arr[i][j] >= sum) {
				completionTimeList.add(arr[i][j] + arr[i][j + 1]);
				sum = arr[i][j] + arr[i][j + 1];
			}
			/*
			 * else if process arrives before completion of previous process the completion
			 * time will be completion time of previous + burst
			 */
			else {
				completionTimeList.add(sum + arr[i][j + 1]);
				sum = sum + arr[i][j + 1];
			}
		}
		completionTimeList.forEach(System.out::println);
		return completionTimeList;
	}

	public void waitingTime(int arr[][], int noOfProcess) {
		int temp = 0; // temp will store the completion time of previous process
		for (int i = 0; i < noOfProcess; i++) {
			/*
			 * if process arrives later than completion time of previous then waiting time
			 * will be 0 otherwise waiting time will be arrival time - completion time of
			 * previous
			 */
			if (arr[i][0] >= temp)
				waitingTimeList.add(0);
			else
				waitingTimeList.add(temp - arr[i][0]);
			temp = completionTimeList.get(i);
		}
		waitingTimeList.forEach(System.out::println);
	}

	public void turnAroundTime(int arr[][], int noOfProcess) {
		// turnaround time is completion time - arrival time
		for (int i = 0; i < noOfProcess; i++) {
			turnAroundTimeList.add(completionTimeList.get(i) - arr[i][0]);
		}
		turnAroundTimeList.forEach(System.out::println);
	}

	public void avgWaitingTime(int arr[][], int noOfProcess) {
		double waitTime = 0;
		for (int i = 0; i < noOfProcess; i++) {
			waitTime += waitingTimeList.get(i);
		}
		System.out.println("avg wait time" + (waitTime / noOfProcess));
	}

	public void maxWaitingTime(int arr[][], int noOfProcess) {
		int max = 0;
		for (int i = 0; i < noOfProcess; i++) {
			if (waitingTimeList.get(i) > max)
				max = waitingTimeList.get(i);
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		System.out.println("Enter the number of process");
		Scanner sc = new Scanner(System.in);
		boolean validInput = false;
		int noOfProcess = 0;
		do {
			System.out.println("Please enter an integer");
			try {
				noOfProcess = Integer.parseInt(sc.nextLine());
				validInput = true;
			} catch (IllegalArgumentException e) {
				System.out.println("Invalid value");
			}
		} while (!validInput);
		/*
		 * 2D array with rows representing each process and first col representing
		 * arrival time and second col representing burst time
		 */
		int[][] processArr = new int[noOfProcess][2];
		// temp will store the arrival time of preceding process
		int temp = 0;
		label: for (int i = 0, j = 0; i < noOfProcess;) {
			System.out.println("Enter the arrival time of process " + (i + 1));
			int arrivalTime = sc.nextInt();
			if (arrivalTime < temp) {
				System.out.println("Arrival time cant be less than previous process arrival time");
				continue label;
			} else {
				processArr[i][j] = arrivalTime;
				temp = arrivalTime;
				if (j == 0)
					j = 1;
			}
			System.out.println("Enter the burst time of process " + (i + 1));
			int burstTime = sc.nextInt();
			if (burstTime < 0) {
				System.out.println("burst time cant be negative");
				continue label;
			}
			processArr[i][j] = burstTime;
			if (j == 1)
				j = 0;
			i++;
		}
		JobScheduler fcfs = new JobScheduler();
		fcfs.completionTime(processArr, noOfProcess);
		fcfs.waitingTime(processArr, noOfProcess);
		fcfs.turnAroundTime(processArr, noOfProcess);
		fcfs.avgWaitingTime(processArr, noOfProcess);
		fcfs.maxWaitingTime(processArr, noOfProcess);

	}
}

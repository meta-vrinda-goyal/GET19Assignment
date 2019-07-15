import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		HexCalc cal = new HexCalc();
		Scanner sc = new Scanner(System.in);
		boolean validInput = false;
		boolean validInput2 = false;
		String hex1 = "";
		String hex2 = "";
		do{
			System.out.println("Please enter valid hexadecimals");
			try{
				hex1 = sc.nextLine();
				hex2 = sc.nextLine();
				validInput = cal.isHex(hex1);
				validInput2 = cal.isHex(hex2);

			} catch (IllegalArgumentException e){
				System.out.println("Invalid value");
			}
		} while (!(validInput && validInput2));
		
		System.out.println("Please enter the desired operation you want to perform");
		System.out.println("1.)Add\n2.)Subtract\n3.)Multiply\n4.)Divide\n5.)Compare two numbers");
		
		int choice = sc.nextInt();

		switch (choice){
		case 1:

			System.out.println("Answer:" + cal.doAddition(hex1, hex2));
			break;
		case 2:

			System.out.println("Answer:" + cal.doSubtraction(hex1, hex2));
			break;
		case 3:

			System.out.println("Answer:" + cal.doMultiply(hex1, hex2));
			break;
		case 4:

			System.out.println("Answer:" + cal.doDivision(hex1, hex2));
			break;
		case 5:

			System.out.println("Answer:" + cal.compare(hex1, hex2));
			break;
		}
	}
}

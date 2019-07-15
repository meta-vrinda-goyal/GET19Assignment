import java.util.Scanner;

public class Main {
	public static void main(String[] args)  {
		HexCalc cal = new HexCalc();
		Scanner sc = new Scanner(System.in);
		boolean validInput = false;
		boolean validInput2 = false;
		String hex1 = "";
		String hex2 = "";
		do {
			System.out.println("Please enter valid hexadecimals");
			try {
				hex1 = sc.nextLine();
				hex2 = sc.nextLine();
				validInput = cal.isHex(hex1);
				validInput2 = cal.isHex(hex2);

			} catch (IllegalArgumentException e) {
				System.out.println("Invalid value");
			}
		} while (!(validInput && validInput2));
		System.out.println("Please enter the desired operation you want to perform");
		System.out.println(
				"1.)Add\n2.)Subtract\n3.)Multiply\n4.)Divide\n5.)Compare if equal\n6.)compare if greate\n7.)compare if less");
		int choice = sc.nextInt();

		switch (choice) {
		case 1:

			System.out.println("Answer:" + cal.add(hex1, hex2));
			break;
		case 2:

			System.out.println("Answer:" + cal.sub(hex1, hex2));
			break;
		case 3:

			System.out.println("Answer:" + cal.mul(hex1, hex2));
			break;
		case 4:

			System.out.println("Answer:" + cal.div(hex1, hex2));
			break;
		case 5:

			System.out.println("Answer:" + cal.compareIfEq(hex1, hex2));
			break;
		case 6:

			System.out.println("Answer:" + cal.compareIfGreater(hex1, hex2));
			break;
		case 7:

			System.out.println("Answer:" + cal.compareIfLess(hex1, hex2));
			break;

		}
	}
}

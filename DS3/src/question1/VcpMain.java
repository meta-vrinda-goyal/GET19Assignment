package question1;

import java.util.Scanner;

public class VcpMain {
	
	public static void main(String[] arg) {

		VirtualCommandPrompt v = new VirtualCommandPrompt();
		System.out.print(v.getRoot().getName() + ">" + "\t");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		while (input != "exit") {
			String result = v.vcp(input);
			System.out.print(result + ">\t");
			Scanner scanner1 = new Scanner(System.in);
			input = scanner1.nextLine();
		}
	}
}

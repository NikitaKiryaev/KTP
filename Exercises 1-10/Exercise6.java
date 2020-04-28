import java.util.Scanner;
public class Exercise6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input button ");
		String button = scanner.nextLine();
		if (button.length() > 1) {
			System.out.print("Only one character per time ");
			return;
		}
		System.out.println("ASCII code of your button is " + code(button));
	}

	public static int code (String button) {
		int ascii = button.charAt(0);
		return ascii;
		
	}
}
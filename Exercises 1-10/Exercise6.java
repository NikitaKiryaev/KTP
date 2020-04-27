import java.util.Scanner;
public class Exercise6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input button ");
		String button = scanner.nextLine();
		System.out.println("ASCII code of your button is " + code(button));
	}

	public static int code (String button) {
		int ascii = button.charAt(0);
		return ascii;
		
	}
}
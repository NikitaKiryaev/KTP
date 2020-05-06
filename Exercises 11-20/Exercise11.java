import java.util.Scanner;
public class Exercise11{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input word: ");
		String str = scanner.next();
		System.out.print("Input amount of repeat: ");
		int number = scanner.nextInt();
		System.out.print("Result is " + repeats(str, number));


	}

	public static String repeats(String str, int number ){
		String repeated = "";
		for (int i = 0; i < str.length(); i++) {
			char character = str.charAt(i);
			repeated += character.repeat(number);
		}
	return repeat;
	}

}



char[] characters = str.toCharArray();
import java.util.Scanner;
public class Exercise11{
	// Ввод слова и кол-во повторов, и вывод результата
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input word ");
		String word = scanner.nextLine();
		System.out.print("Input amount of repeat ");
		int n = scanner.nextInt();
		System.out.print("Result " + repeat(word, n));

	}
	// Метод повтора букв в слове
	public static String repeat(String word, int n) {
String sum = "";
for (int i = 0; i < word.length(); i++)
for (int l = 0; l < n; l++)
sum += word.charAt(i);
return sum;
}
}
		
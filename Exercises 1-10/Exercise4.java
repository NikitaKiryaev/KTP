import java.util.Scanner;
public class Exercise4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Insert value of prob: ");
		double prob = scanner.nextDouble();
		System.out.print("Insert value of prize: ");
		int prize = scanner.nextInt();
		System.out.print("Insert value of pay ");
		int pay = scanner.nextInt();
		if (profitableGamble(prob, prize, pay)) {
			System.out.print("Profit ");
		}
		else
			System.out.print("Not profit ");
	}

	public static boolean profitableGamble(double prob, int prize, int pay){
		if (prob * prize > pay) {
			return true;
		}
		return false;
	}
}
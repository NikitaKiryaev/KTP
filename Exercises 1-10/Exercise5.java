import java.util.Scanner;
public class Exercise5 {
	public static void main(String[] args) {
		// Ввод и вывод данных
		String ns = args[0];
		int n = Integer.parseInt(ns.trim());
		
		String firsts = args[1];
		int first = Integer.parseInt(firsts.trim());
		
		String seconds = args[2];
		int second = Integer.parseInt(seconds.trim());

		System.out.print(calc(first, second, n));
	}
	public static String calc(int first, int second, int n){
		// Проверка, что нужно сделать с числами чтобы получить третье число
		if (first + second == n) {
			return "added";
		}
		else if (first - second == n) {
			return "subtracted";
		}
		else if (first/second == n) {
			return "divided";
		}
		else if (first*second == n) {
			return "multiplied";
		}
		return "none";
	}

	
}
import java.util.Scanner;
public class Exercise10 {
	public static void main(String[] args) {
		// Ввод и вывод данных
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input a: ");
		int a = scanner.nextInt();
		System.out.print("Input b: ");
		int b = scanner.nextInt();
		System.out.print("Input c: ");
		int c = scanner.nextInt();
		System.out.print(abcmath(a, b, c));
	}


	public static boolean abcmath (int a, int b, int c){
		// Прибавляем к себе число а b раз
		for (int i = 0; i < b; i++) {
			a = a*2;
		}
		// Проверяем, делится ли результат на число с
		if (a % c == 0) {
			return true;
		}
		return false;
	}
}
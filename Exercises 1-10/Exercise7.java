import java.util.Scanner;
public class Exercise7 {
	public static void main(String[] args) {
		// Ввод и вывод данных
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input number: ");
		int number = scanner.nextInt();
		System.out.println("Summary: " + summary(number));

	}
	// Функция нахождения суммы предыдущих чисел с введенным числом
	public static int summary (int number){
		int sum = 0;
		int[] before;
		before = new int[number + 1];
		for (int i = 0; i <= number; i++) {
			before[i] = i;
			
		}
		for (int num : before) {
			sum = sum + num;
			
		}
		return sum;
	}
}
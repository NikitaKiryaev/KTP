import java.lang.Math;
import java.util.Scanner;
public class Exercise9 {
	public static void main(String[] args) {
		// Ввод и вывод данных
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input array length: ");
		int size = scanner.nextInt();
		int[] array = new int [size];
		System.out.print("Input array elements: ");
		for (int i = 0; i < size; i++) {
			array[i] = scanner.nextInt();
		}
		

		System.out.print("Result: " + cubes(array, size));
	}


	public static int cubes (int[] array, int size){
		// Возведение в куб и суммирование эелементов массива
		int sum = 0;
		for (int g = 0; g < size; g++) {
			sum += Math.pow(array[g], 3);

		}
		return sum;
	}
}
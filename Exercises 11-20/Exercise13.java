import java.util.Scanner;
public class Exercise13{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input size ");
		int size = scanner.nextInt();
		int[] arr = new int [size];
		System.out.print("Input numbers ");
		for (int i = 0; i < size; i++) {
			arr[i] = scanner.nextInt();
		}
		System.out.print("Result is " + isInt(arr, size));
	}

	public static boolean isInt(int[] arr, int size){
		int sum = 0;
		for (int i = 0 ; i < size; i++) {
			sum += arr[i];
		}
		return sum % size == 0;
		
	}
}
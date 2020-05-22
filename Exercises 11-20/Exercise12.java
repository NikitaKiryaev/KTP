import java.util.Scanner;
import java.util.*;
public class Exercise12{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input size of array ");
		int size = scanner.nextInt();
		int [] arr = new int [size];
		System.out.print("Input numbers ");
		for (int g = 0; g < size; g++) {
			arr[g] = scanner.nextInt();
		}
		System.out.print("Result: " + difference(arr, size));
				
	}
	public static int difference (int[] arr ,int size){ 
		int biggest = 0;
		int smallest = 0;
		Arrays.sort(arr);
		smallest = arr[0];
		biggest = arr[size - 1];
		int result = biggest - smallest;
		return result;
	}

}
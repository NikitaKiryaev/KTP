import java.util.Scanner;
public class Exercise8 {
	public static void main(String[] args) {
		// Ввод и вывод данных
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input first side of triangle: ");
		int side1 = scanner.nextInt();
		if (side1 <= 0) {
			System.out.print("Wrong side ");
			return;
		}
		System.out.print("Input second side of triangle: ");
		int side2 = scanner.nextInt();
		if (side2 <= 0) {
			System.out.print("Wrong side ");
			return;
		}
		System.out.print("Third side is: " + find_side(side1, side2));
	}

	//Функция нахождения максимальной третьей стороны
	public static int find_side (int side1, int side2){
		  

    int max_length = side1 + side2 - 1;
    return max_length;
	}
}
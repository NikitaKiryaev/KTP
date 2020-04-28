import java.util.Scanner;
public class Exercise2 {
	public static void main(String[] args) {
		// Ввод и вывод данных
		Scanner scanner = new Scanner(System.in);
		System.out.print("Vedite visotu ");
		double h = scanner.nextDouble();
		System.out.print("Vedite osnovanie ");
		double a = scanner.nextDouble();
		System.out.print("Ploschad: " + Result(h,a));
	}

	public static double Result (double h, double a){
		// Вычисление площади треугольника
		double s = a*h/2;
		return s;
	}
}

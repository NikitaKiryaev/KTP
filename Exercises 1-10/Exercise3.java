import java.util.Scanner;
public class Exercise3 {
	public static void main(String[] args) {
		// Ввод и вывод данных, и проверка правильности введенных данных
		Scanner scanner = new Scanner(System.in);
		System.out.print("How many chickens ");
		int chicken = scanner.nextInt();
		if (chicken < 0) {
			System.out.println("Wrong amount of chickens ");
			return;
		}
		System.out.print("How many cows ");
		int cow = scanner.nextInt();
		if (cow < 0) {
			System.out.println("Wrong amount of cows ");
			return;
		}
		System.out.print("How many pigs ");
		int pig = scanner.nextInt();
		if (pig < 0) {
			System.out.println("Wrong amount of pigs ");
			return;
		}
		System.out.print("Amount of legs = " + Summary(chicken, cow, pig));
	}	
	


	public static int Summary (int chicken, int cow, int pig){
		// Вычисление кол-ва ног всех животных
		int s = chicken*2 + cow*4 + pig*4;
		return s;
	}
}
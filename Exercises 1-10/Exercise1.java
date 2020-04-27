import java.util.Scanner;
public class Exercise1{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input first number ");
		int x = sc.nextInt();
		System.out.println("Input second number ");
		int y = sc.nextInt();
		System.out.println("Remainder of division " + Remainder(x,y));
		
	}
	public static int Remainder(int x, int y){
		int z = x%y;
		return z;
	}
	
}

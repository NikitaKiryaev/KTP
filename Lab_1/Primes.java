// Класс Primes
public class Primes {
	public static void main(String[] args) {
		for (int n = 2; n < 101; n++) {         // Вывод простых чисел через цикл for
		if (isPrime(n)) {
				System.out.println ("Naideno prostoe chislo " + n);
			}	
		}
	}
	 public static boolean isPrime(int n) {           // Функция, которая определяет простое число или нет.

	 	for (int i = 2; i<n; i++) {
	 		if (n%i == 0) {
	 			return false;
	 		}
	 		 
	 	}
	 	return true;
	 } 
}
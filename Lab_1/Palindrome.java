// Класс Palindrome
public class Palindrome {
	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			String s = args[i];
			if (isPalindrome(s)) {                //Выводи сообщение если слово палиндроми или нет.
				System.out.println("Palindrome " + s);
			
				
				}
			else
				System.out.println("Ne Palindrome " + s);
			}
			
		}
		
	
//Функция переворачивания строки
	public static String reverseString(String s){
		String r = "";
		for (int l = s.length() - 1; l >= 0; --l) {
			r += s.charAt(l);
		}
		return r;
	}

//Функция проверки строки на палиндром
	public static Boolean isPalindrome (String s){    
		if (s.equals(reverseString(s))) {
			return true;
			
		}
		return false;

	}


}
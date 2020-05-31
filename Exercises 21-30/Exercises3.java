public class Exercises3 {

    public static void main( String[] args ) {
        System.out.println(solutions(1, 0, -1));
        System.out.println(findZip("all zip files were unzipped"));
        System.out.println(checkPerfect(28));
        System.out.println(flipEndChars("madam"));
        System.out.println(isValidHexCode("#CD5C5C"));
        System.out.println(same(new int[] {1, 3, 4, 4, 4}, new int[] {2, 5, 7}));
        System.out.println(isKaprekar(297));
        System.out.println(longestZero("100100100"));
        System.out.println(nextPrime(12));
        System.out.println(rightTriangle(3, 4, 5));
    }

    public static int solutions(int a, int b, int c){
        if(a == 0)
            if(b == 0)
                return 0;
            else
                return 1;
        if(b == 0 && ((a > 0 && c > 0) || (a < 0 && c < 0)))
            return 0;
        int D = b * b - 4 * a * c;
        if(D == 0)
            return 1;
        else if(D > 0)
            return 2;
        else if(D < 0)
            return 0;
        return -1;
    }
    public static int findZip(String line){
        int index = line.indexOf("zip");
        String newline = "";
        for(int i = index + 3; i < line.length(); i++)
            newline += line.charAt(i);
        return newline.indexOf("zip") + index + 3;
    }
    public static boolean checkPerfect(int number){
        if(number == 0)
            return false;
        int sum = 0;
        for(int g = 1; g < number; g++)
            if(number % g == 0)
                sum += g;
        if(sum == number)
            return true;
        else
            return false;
    }

    public static String flipEndChars(String string){
        if(string.length() <= 2)
            return "Incompatible.";
        else if(string.charAt(0) == string.charAt(string.length() - 1))
            return "Two's a pair.";
        else{
            char word = string.charAt(0);
            String newString = "";
            newString += string.charAt(string.length() - 1);
            for(int g = 1; g < string.length() - 1; g++)
                newString += string.charAt(g);
            newString += word;
            return newString;
        }
    }

    public static boolean isValidHexCode(String code){
        if(code.length() != 7)
            return false;
        if(code.charAt(0) != '#')
            return false;
        for(int g = 1; g < code.length(); g++)
            if(!((code.charAt(g) >= '0' && code.charAt(g) <= '9') || (code.charAt(g) >= 'A' && code.charAt(g) <= 'F') || (code.charAt(g) >= 'a' && code.charAt(g) <= 'f')))
                return false;
        return true;
    }

    public static boolean same(int[] firstarr, int[] secondarr){
        int arr1 = 0;
        int arr2 = 0;
        boolean check;

        for(int g = 0; g < firstarr.length; g++){
            check = false;
            for(int j = 0; j < g; j++)
                if(firstarr[g] == firstarr[j])
                    check = true;
            if(!check)
                arr1 ++;
        }
        for(int i = 0; i < secondarr.length; i++){
            check = false;
            for(int j = 0; j < i; j++)
                if(secondarr[i] == secondarr[j])
                    check = true;
            if(!check)
                arr2 ++;
        }
        if(arr1 == arr2)
            return true;
        else
            return false;
    }

    public static boolean isKaprekar(int number){
        int a = number * number;

        String line = "" + a;

        int left = 0;
        int right = 0;

        for(int g = 0; g < line.length() / 2; g++)
            left = left * 10 + Integer.parseInt("" + line.charAt(g));


        for(int i = line.length() / 2; i < line.length(); i++)
            right = right * 10 + Integer.parseInt("" + line.charAt(i));;
        if(left + right == number)
            return true;
        else
            return false;
    }

    public static String longestZero(String string){
        String zero = "";
        String res = "";
        for(char symbol: string.toCharArray())
            if(symbol == '1') {
                if (zero.length() < res.length())
                    zero = res;
                res = "";
            }else
                res += symbol;
        return zero;
    }

    public static int nextPrime(int number){
        boolean check = false;

        while(!check){
            check = true;
            for(int g = 2; g < number; g++)
                if(number % g == 0){
                    check = false;
                    break;
                }
            if(!check)
                number++;
        }
        return number;
    }

    private static boolean rightTriangle(int a, int b, int c){

        if(a * a == b * b + c * c)
            return true;

        else if(b * b == a * a + c * c)
            return true;

        else if(c * c == b * b + a * a)
            return true;

        return false;
    }
}
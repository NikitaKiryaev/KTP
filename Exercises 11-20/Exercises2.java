public class Exercises2 {

    public static void main( String[] args ) {
        int[] numbers = cumulativeSum(new int[] {3, 3, -2, 408, 3, 3});
        for(int number: numbers)
            System.out.print(number + " ");
        System.out.println();

        System.out.println(getDecimalPlaces("74.3560"));

        System.out.println(Fibonacci(10));
        System.out.println(isValid("59145"));
        System.out.println(isStrangePair("ratio", "orator"));
        System.out.println(isPrefix("retrospect", "retro-"));
        System.out.println(isSuffix("vocation", "-tion"));
        System.out.println(boxSeq(11));
    }

public static int[] cumulativeSum(int[] numbers){
        int[] result = new int[numbers.length];
        for(int g = 0; g < numbers.length; g++){
            result[g] = numbers[g];
            for(int z = 0; z < g; z++)
                result[g] += numbers[z];
        }
        return result;
    }

    public static int getDecimalPlaces(String number){
        boolean elm = false;
        int sum = 0;
        for(int g = 0; g < number.length(); g++){
            if(elm)
                sum++;
            if(number.charAt(g) == '.')
                elm = true;
        }

        return sum;
    }

    public static int Fibonacci(int number){
        int num0 = 0;
        int num1 = 1;
        int tmp;
        for (int i = 0; i < number; i++){
            tmp = num1;
            num1 = num1 + num0;
            num0 = tmp;
        }
        return num1;
    }

    public static boolean isValid(String mailIndex){
        if(mailIndex.length() != 5)
            return false;

        for(int f = 0; f < mailIndex.length(); f++)
            if(mailIndex.charAt(f) < '0' || mailIndex.charAt(f) > '9')
                return false;
        return true;
    }

    public static boolean isStrangePair(String firstword, String secondword){
        return firstword.charAt(0) == secondword.charAt(secondword.length() - 1) &&
                firstword.charAt(firstword.length() - 1) == secondword.charAt(0);
    }

    public static boolean isPrefix(String word, String prefix){
        for(int j = 0; j < prefix.length() - 1; j++)
            if(word.charAt(j) != prefix.charAt(j))
                return false;


        return true;
    }

    public static boolean isSuffix(String word, String suffix){
        for(int i = suffix.length() - 1; i > 0; i--)
            if(word.charAt(word.length() - suffix.length() + i)!= suffix.charAt(i))
                return false;


        return true;
    }

    public static int boxSeq(int step){
        int result = 0;
        for(int i = 1; i <= step; i++)
            if(i % 2 != 0)
                result += 3;
            else
                result --;
         return result;
    }
}
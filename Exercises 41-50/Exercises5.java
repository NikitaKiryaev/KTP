import javax.annotation.processing.SupportedSourceVersion;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Exercises5 {
    public static void main( String[] args ) {
        int[] out = encrypt("Sunshine");
        System.out.print("[");
        for(int g = 0; g < out.length; g++)
            if(g < out.length - 1)
                System.out.print(out[g] + ", ");
            else
                System.out.print(out[g]);
        System.out.println("]");
        System.out.println(decrypt(new int[]{72, 33, -73, 84, -12, -3, 13, -13, -68}));
        System.out.println(canMove("Rook", "A8", "H8"));
        System.out.println(canComplete("bbutl", "beautiful"));
        System.out.println(sumDigProd(new int[]{16, 28}));
        System.out.println(sameVowelGroup(new String[]{"many", "carriage", "emit", "apricot", "animal"}));
        System.out.println(validateCard(1234567890123452l));
        System.out.println(numToEng((short) 919));
        System.out.println(numToRus((short) 919));
        System.out.println(getSha256Hash("Fluffy@home"));
        System.out.println(correctTitle("sansa stark, lady of winterfell."));
        System.out.println(hexLattice(37));
    }

    public static int[] encrypt(String string){
        int[] result = new int[string.length()];
        result[0] = string.charAt(0);
        for (int g = 1; g < string.length(); g++)
            result[g] = (string.charAt(g) - string.charAt(g - 1));
        return result;
    }
    public static String decrypt(int[] arr){
        String result = "" + (char)arr[0];
        for(int g = 1; g < arr.length; g++)
            result += (char)(result.charAt(result.length() - 1) + arr[g]);
        return result;
    }
    public static boolean canMove(String figure, String startpos, String endpos){
        if(startpos.charAt(0) <= 'H' && startpos.charAt(1) <= '8' && endpos.charAt(0) <= 'H' && endpos.charAt(1) <= '8')
            return false;
        int width = Math.abs(startpos.charAt(0) - endpos.charAt(0));
        int height = Math.abs(startpos.charAt(1) - endpos.charAt(1));
        if(figure.equals("Pawn"))
            if(startpos.charAt(1) == '2' || startpos.charAt(1) == '7')
                if(startpos.charAt(0) == endpos.charAt(0)) {
                    if (startpos.charAt(1) == '7' && endpos.charAt(1) == '5')
                        return true;
                    else if (startpos.charAt(1) == '2' && endpos.charAt(1) == '4')
                        return true;
                    if (Math.abs(startpos.charAt(1) - endpos.charAt(1)) == 1)
                        return true;
                }else
                    if(width == 1 && Math.abs(startpos.charAt(1) - endpos.charAt(1)) == 1)
                        return true;
        if(figure.equals("Rook"))
            if(startpos.charAt(0) == endpos.charAt(0) || startpos.charAt(1) == endpos.charAt(1))
                return true;
        if(figure.equals("Horse"))                                                      
            if((width == 2 && height == 1) || (width == 1 && height == 2))
                return true;
        if(figure.equals("Bishop"))
            if(width == height)
                return true;
        if(figure.equals("Queen")){
            if(width == height)
                return true;
            if(startpos.charAt(0) == endpos.charAt(0) || startpos.charAt(1) == endpos.charAt(1))
                return true;
        }
        if(figure.equals("King"))
            if(width <= 1 && height <= 1)
                return true;
        return false;
    }
    public static boolean canComplete(String firstword, String secondword){
        int score = 0;
        for(char word: secondword.toCharArray())
            if(word == firstword.charAt(score))
                score ++;
        return score == firstword.length();
    }
    public static int sumDigProd(int[] arr){
        int sum = 0;
        int result = 1;
        for(int g: arr)
            sum += g;
        while(sum > 9){
            while(sum > 0){
                result *= sum % 10;
                sum /= 10;
            }
            sum = result;
            result = 1;
        }
        return sum;
    }
    public static ArrayList<String> sameVowelGroup(String[] arr){
        ArrayList<String> out = new ArrayList<>();
        String consonants = "qwrtpsdfghjklzxcvbnm";
        boolean result = true;
        String sameVowels = "";

        for(char word: arr[0].toCharArray())
            if(consonants.indexOf(word) == -1)
                sameVowels += word;
        out.add(arr[0]);

        for(int g = 1; g < arr.length; g++){
            for(char word: arr[g].toCharArray())
                if(consonants.indexOf(word) == -1)
                    if(sameVowels.indexOf(word) == -1)
                        result = false;
            if(result)
                out.add(arr[g]);
            result = true;
        }
        return out;
    }
   
// ТУТ Я ОСТАНОВИЛСЯ!!!
    public static boolean validateCard(long cardNumber){
        if(cardNumber <= 9999999999999l)
            return false;
        short checkDigit = (short)(cardNumber % 10);
        cardNumber /= 10;
        boolean check = false;
        short sum = 0;
        while(cardNumber > 0){
            short number = (short)(cardNumber % 10);
            cardNumber /= 10;
            if(!check){
                number *= 2;
                number = (short) (number / 10 + number % 10);
            }
            sum += number;
            check = !check;
        }
        if(10 - sum % 10 == checkDigit)
            return true;
        else
            return false;
    }
    public static String numToEng(short number){
        if(number == 0)
            return "zero";

        boolean check = false;

        short one = (short)(number % 10);
        number /= 10;
        short ten = (short)(number % 10);
        number /= 10;

        String string = "";

        switch (number){
            case 1:
                string += "one hundred ";
                break;
            case 2:
                string += "two hundred ";
                break;
            case 3:
                string += "three hundred ";
                break;
            case 4:
                string += "four hundred ";
                break;
            case 5:
                string += "five hundred ";
                break;
            case 6:
                string += "six hundred ";
                break;
            case 7:
                string += "seven hundred ";
                break;
            case 8:
                string += "eight hundred ";
                break;
            case 9:
                string += "nine hundred ";
                break;
        }
        switch (ten){
            case 1:
                check = true;
                break;
            case 2:
                string += "twenty ";
                break;
            case 3:
                string += "thirty ";
                break;
            case 4:
                string += "fourty ";
                break;
            case 5:
                string += "fivety ";
                break;
            case 6:
                string += "sixty ";
                break;
            case 7:
                string += "seventy ";
                break;
            case 8:
                string += "eighty ";
                break;
            case 9:
                string += "ninety ";
                break;
        }

        switch (one){
            case 1:
                if(check)
                    string += "eleven";
                else
                    string += "one";
                break;
            case 2:
                if(check)
                    string += "twelve";
                else
                    string += "two";
                break;
            case 3:
                if(check)
                    string += "thirteen";
                else
                    string += "three";
                break;
            case 4:
                if(check)
                    string += "fourteen";
                else
                    string += "four";
                break;
            case 5:
                if(check)
                    string += "fifteen";
                else
                    string += "five";
                break;
            case 6:
                if(check)
                    string += "sixteen";
                else
                    string += "six";
                break;
            case 7:
                if(check)
                    string += "seventeen";
                else
                    string += "seven";
                break;
            case 8:
                if(check)
                    string += "eighteen";
                else
                    string += "eight";
                break;
            case 9:
                if(check)
                    string += "nineteen";
                else
                    string += "nine";
                break;
        }
        return string;
    }
    public static String numToRus(short number){
        if(number == 0)
            return "ноль";

        boolean check = false;
        short one = (short)(number % 10);
        number /= 10;
        short ten = (short)(number % 10);
        number /= 10;
        String string = "";

        switch (number){
            case 1:
                string += "сто ";
                break;
            case 2:
                string += "двести ";
                break;
            case 3:
                string += "тристо ";
                break;
            case 4:
                string += "четыресто ";
                break;
            case 5:
                string += "пятосот ";
                break;
            case 6:
                string += "шестьсот ";
                break;
            case 7:
                string += "семьсот ";
                break;
            case 8:
                string += "восемьсот ";
                break;
            case 9:
                string += "девятьсот ";
                break;
        }
        switch (ten){
            case 1:
                check = true;
                break;
            case 2:
                string += "двадцать ";
                break;
            case 3:
                string += "тридцать ";
                break;
            case 4:
                string += "сорок ";
                break;
            case 5:
                string += "пятьдесят ";
                break;
            case 6:
                string += "шестьдесят ";
                break;
            case 7:
                string += "семьдесят ";
                break;
            case 8:
                string += "восемьдесят ";
                break;
            case 9:
                string += "девятьсот ";
                break;
        }

        switch (one){
            case 1:
                if(check)
                    string += "одинадцать";
                else
                    string += "один";
                break;
            case 2:
                if(check)
                    string += "двенадцать";
                else
                    string += "два";
                break;
            case 3:
                if(check)
                    string += "тринадцать";
                else
                    string += "три";
                break;
            case 4:
                if(check)
                    string += "четырнадцать";
                else
                    string += "четыре";
                break;
            case 5:
                if(check)
                    string += "пятнадцать";
                else
                    string += "пять";
                break;
            case 6:
                if(check)
                    string += "шестнадцать";
                else
                    string += "шесть";
                break;
            case 7:
                if(check)
                    string += "семнадцать";
                else
                    string += "семь";
                break;
            case 8:
                if(check)
                    string += "восемнадцать";
                else
                    string += "восемь";
                break;
            case 9:
                if(check)
                    string += "девятнадцать";
                else
                    string += "девять";
                break;
        }
        return string;
    }
    public static String getSha256Hash(String password){
        StringBuilder string = new StringBuilder();

        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashCode = md.digest(password.getBytes());
            for (byte f : hashCode)
                string.append(String.format("%02x", f));
        }catch (NoSuchAlgorithmException e){
            e.getMessage();
        }
        return string.toString();
    }
    public static String correctTitle(String string){
        string = string.toLowerCase();
        String[] words = string.split(" ");
        string = "";

        for (String word: words){
            if(word.equals("and") || word.equals("the") || word.equals("of") || word.equals("in"))
                string += word;

            else if(word.indexOf('-') != -1){
                int number = word.indexOf('-');
                string += word.substring(0, 1).toUpperCase() + word.substring(1, number + 1) + word.substring(number + 1, number + 2).toUpperCase() + word.substring(number + 2);
            }else
                string += word.substring(0, 1).toUpperCase() + word.substring(1);
            string += " ";
        }
        return string;
    }
    public static String hexLattice(int number){
        int sum = 0;
        int num = 1;
        while(num < number){
            num += 6 * sum;
            sum ++;
        }
        String string = "";

        for(int g= 0; g < sum; g++){
            for(int j = 0; j < sum - g - 1; j++)
                string += ' ';

            for(int j = 0; j < sum + g; j++)
                string += "o ";
            string += '\n';
        }
        for(int g = sum - 2; g >= 0; g--){
            for(int j = 0; j < sum - g - 1; j++)
                string += ' ';
            for(int j = 0; j < sum + g; j++)
                string += "o ";
            string += '\n';
        }
        return string;
    }
}
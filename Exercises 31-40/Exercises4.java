import java.util.ArrayList;

public class Exercises4 {
    public static void main( String[] args ) {
        System.out.println( textprocess(10, 7, "hello my name is Bessie and this is my essay") );
        System.out.println(split("((())())(()(()()))"));
        System.out.println(toCamelCase("is_modal_open"));
        System.out.println(toSnakeCase("isModalOpen"));
        System.out.println(overTime(new double[]{16, 18, 30, 1.8}));
        System.out.println(BMI("205 pounds", "73 inches"));
        System.out.println(bugger(382));
        System.out.println(toStarShorthand("abbccc"));
        System.out.println(doesRhyme("You are off to the races", "a splendid day."));
        System.out.println(trouble(666789,  12345667));
        System.out.println(countUniqueBooks("$AA$BBCATT$C$$B$", '$'));
    }

    public static String textprocess(int n, int k, String string){
        String result = "";
        int score = 0;

        for(String word: string.split(" ")){
            if(word.length() <= k - score){
                if(score != 0)
                    result += " ";

                result += word;
                score += result.length();

            }else{
                score  = word.length();
                result += "\n" + word;
            }

        }
        return result;
    }
    public static ArrayList<String> split(String line){
        int score = 0;
        String string = "";
        ArrayList<String> result = new ArrayList<>();
        for (char symbol: line.toCharArray()) {
            if(symbol == '(')
                score ++;
            if(symbol == ')')
                score--;
            string += symbol;
            if(score == 0){
                result.add(string);
                string = "";
            }
        }
        return result;
    }
    public static String toCamelCase(String line){
        String result = "";
        boolean check = false;

        for (char symbol: line.toCharArray())
            if(symbol == '_')
                check = true;

            else if(check){
                result += (char)(symbol - 32);
                check = false;
            }
            else
                result += symbol;
        return result;
    }

    public static String toSnakeCase(String line){
        String result = "";

        for(char symbol: line.toCharArray())
            if(symbol >='A' && symbol <= 'Z')
                result += "_" + (char)(symbol + 32);
            else
                result += symbol;
        return result;
    }
    public static String overTime(double[] arr){
        double standart = 0;
        double overtime = 0;
        if(arr[1] > 17){
            if(arr[0] < 17)
                standart = 17 - arr[0];
            overtime = arr[1] - 17;
        }
        else
            standart = arr[1] - arr[0];
        return "$" + (double)Math.round((standart * arr[2] + overtime * arr[2] * arr[3]) * 100) / 100;
    }
    public static String BMI(String weight, String height){
        String[] w = weight.split(" ");
        String[] h = height.split(" ");

        double mass = Integer.parseInt(w[0]);
        if(w[1].equals("pounds"))
            mass /= 2.20462;
        double rost = Double.parseDouble(h[0]);
        if(h[1].equals("inches"))
            rost /= 39.3701;
        double bmi = mass / (rost * rost);
        if(bmi < 18.5)
            return (double)Math.round(bmi * 10) / 10 + " Underweight";
        else if(bmi >= 18.5 && bmi <= 24.9)
            return (double)Math.round(bmi * 10) / 10 + " Normal weight";
        else if(bmi >= 25)
            return (double)Math.round(bmi * 10) / 10 + " Overweight";
        return "";
    }
    public static int bugger(int number){
        int tmp = 1;
        if(number > 9)
            while(number > 0) {
                tmp *= number % 10;
                number /= 10;
            }
        else
            return 0;

        return 1 + bugger(tmp);
    }
    public static String toStarShorthand(String line){
        line += " ";
        int count = 1;
        char oldWord = ' ';
        String string = "";
        for(char word: line.toCharArray()){
            if(word != oldWord){
                if(string.equals("")){
                    string += word;
                }
                else if(count == 1){
                    string += word;
                }
                else{
                    string += "*" + count;
                    string += word;
                }

                count = 1;
            }
            else{
                count++;
            }
            oldWord = word;
        }
        return string;
    }
    public static boolean doesRhyme(String first, String second){
        boolean result = true;
        String symbols = "AOUIYE";
        char ch;
        String[] f = first.split(" ");
        String[] s = second.split(" ");
        first = f[f.length - 1].toUpperCase();
        second = s[s.length - 1].toUpperCase();

        if(first.length() > second.length())
            for(int i = 1; i <= second.length(); i++){
                if(result)
                    for (char symbol: symbols.toCharArray()) {
                        ch = second.charAt(second.length() - i);
                        if(symbol == ch){
                            if(!(ch == first.charAt(first.length() - i)))
                                result = false;
                            break;
                        }
                    }
                else
                    i = second.length();
            }
        else
            for(int g = 1; g <= first.length(); g++){
                if(result)
                    for (char symbol: symbols.toCharArray()) {
                        ch = first.charAt(first.length() - g);
                        if(symbol == ch){
                            if(!(second.charAt(second.length() - g) == ch))
                                result = false;
                            break;
                        }
                    }
                else
                    g = first.length();
            }
        return result;
    }
    public static boolean trouble(long num1, long num2){
        long oldnum1 = num1 % 10;
        long oldnum2 = num1 % 100;
        num1 /= 100;
        boolean result = false;

        while(num1 > 0){
            if(oldnum1 == oldnum2 && oldnum2 == num1 % 10){
                result = true;
                break;
            }else{
                oldnum1 = oldnum2;
                oldnum2 = num1 % 10;
                num1 /= 10;
            }
        }
        if(result){
            oldnum1 = num2 % 10;
            num2 /= 10;
            while (num2 > 0){
                if(oldnum1 == num2 % 10){
                    return true;
                }else{
                    oldnum1 = num2 % 10;
                    num2 /= 10;
                }
            }
        }
        return false;
    }
    public static int countUniqueBooks(String stringSequence, char bookEnd){
        int result = 0;
        boolean check = false;
        String words = "";
        for(char word: stringSequence.toCharArray()){
            if(word == bookEnd){
                check = !check;
            }
            else{
                if(check){
                    if(words.indexOf(word) == -1){
                        result++;
                        words += word;
                    }
                }
                else{
                    words = "";
                }
            }
        }
        return result;
    }
}
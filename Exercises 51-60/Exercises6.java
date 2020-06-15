import java.util.ArrayList;

public class Exercises6 {
    public static void main( String[] args ){
        System.out.println(bell(3));
        System.out.println(translateWord("Apple"));
        System.out.println(translateSentence("Do you think it is going to rain today?"));
        System.out.println(validColor("rgb(0,0,0)"));
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2"));
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2", new String[]{"b"}));
        String[] arr = getHashTags("How the Avocado Became the Fruit of the Global Trade");
        for(String string: arr)
            System.out.print(string + " ");
        System.out.println();
        System.out.println(ulam(193));
        System.out.println(longestNonRepeatingSubstring("abcda"));
        System.out.println(convertToRoman(1342));
        System.out.println(formula("6 * 4 = 24"));
        System.out.println(palindromedescendant("23336014"));
    }

    public static int bell(int number){
        return bell(number, number);
    }
    //Сложение чисел стерлинга
    public static int bell( int x, int y){
        if(x != 1)
            return sterling(x, y) + bell(x - 1, y);
        else
            return sterling(x, y);
    }
    //Функция вычисления числа стирлинга в матрице
    public static int sterling(int x, int y){
        if(x == y)
            return 1;
        if(x == 1)
            return 1;
        return sterling(x - 1, y - 1) + x * sterling(x, y - 1);
    }
    public static String translateWord(String word){
        String string = "eyuioa";
        if(string.indexOf(word.charAt(0)) != -1)
            return word + "yay";
        else {
            if(word.charAt(0) > 'Z')
                return word.substring(1) + word.charAt(0) + "ay";
            else{
                return word.substring(1, 2).toUpperCase() + word.substring(2) + word.substring(0, 1).toLowerCase() + "ay";
            }
        }

    }
    public static String translateSentence(String string){
        String[] words = string.split(" ");
        string = "";
        for(String word: words)
            if((word.charAt(word.length() - 1) >= 'A' && word.charAt(word.length() - 1) <= 'Z')
                    || (word.charAt(word.length() - 1) >= 'a' && word.charAt(word.length() - 1) <= 'z'))
                string += translateWord(word) + ' ';
            else
                string += translateWord(word.substring(0, word.length() - 1)) + word.substring(word.length() - 1) + " ";
        return string;
    }
    public static boolean validColor(String string){
        if(!string.substring(0, 3).equals("rgb"))
            return false;
        if(string.charAt(3) == 'a'){
            String[] numbers = string.substring(5, string.length() - 1).split(",");
            if(Integer.parseInt(numbers[0]) < 256)
                if(Integer.parseInt(numbers[1]) < 256)
                    if(Integer.parseInt(numbers[2]) < 256)
                        return Double.parseDouble(numbers[3]) <= 1;
        }
        return false;
    }
    public static String stripUrlParams(String string){
        boolean check = false;
        String param = "";
        String line = "";

        for(char symbol: string.toCharArray())
            if(symbol == '?')
                check = true;
            else
                if(check)
                    param += symbol;
                else
                    line += symbol;
        String[] params = param.split("&");
        if(params.length > 0)
            line += "?";
        for(int i = 0; i < params.length; i++){
            check = true;
            for(int j = i + 1; j< params.length; j++)
                if(params[i].split("=")[0].equals(params[j].split("=")[0]))
                    check = false;
            if(check){
                line += params[i] ;
                if(i < params.length - 2)
                    line += "&";
            }
        }
        return line;
    }
    public static String stripUrlParams(String string, String[] deleteParams){
        boolean check = false;
        String param = "";
        String line = "";

        for(char symbol: string.toCharArray())
            if(symbol == '?')
                check = true;
            else
                if(check)
                    param += symbol;
                else
                    line += symbol;
        String[] params = param.split("&");
        if(params.length > 0)
            line += "?";
        for(int g = 0; g < params.length; g++){
            check = true;
            for(int j = g + 1; j< params.length; j++)
                if(params[g].split("=")[0].equals(params[j].split("=")[0]))
                    check = false;
            if(check){
                for(String del: deleteParams)
                    if(del.equals(params[g].split("=")[0]))
                        check = false;

                if(check) {
                    line += params[g];
                    if (g < params.length - 2)
                        line += "&";
                }
            }
        }
        return line;
    }

    public static String[] getHashTags(String string){
        String[] words = string.split(" ");
        String[] result = {"", "", ""};
        for(String word: words)
            if(result[0].length() - 1 < word.length()){
                result[2] = result[1];
                result[1] = result[0];
                result[0] = "#" + word.toLowerCase();
            }else if(result[1].length() - 1 < word.length()){
                result[2] = result[1];
                result[1] = "#" + word.toLowerCase();
            }else if(result[2].length() - 1 < word.length())
                result[2] = "#" + word.toLowerCase();
        return result;
    }
    public static int ulam(int num){
        int[] numbers = new int[num];
        numbers[0] = 1;
        numbers[1] = 2;
        for(int g = 2; g < numbers.length; g++){
            boolean check = false;
            int newEl = numbers[g - 1] + 1;
            while (!check){
                int found = 0;
                for(int j = 0; j < g; j++){
                    int score = newEl - numbers[j];
                    for(int i  = j + 1; i < g; i++)
                        if(numbers[i] == score)
                            found++;
                }
                if(found == 1) {
                    numbers[g] = newEl;
                    check = true;
                }else
                    newEl++;
            }
        }
        return numbers[numbers.length - 1];
    }

    public static String longestNonRepeatingSubstring(String string){
        String result = "";
        String out = "";

        for(char symbol: string.toCharArray())
            if(result.indexOf(symbol) == -1)
                result += symbol;
            else{
                if(out.length() < result.length())
                    out = result;
                result = "" + symbol;
            }
        if(out.length() < result.length())
            out = result;
        return out;
    }
    public static String convertToRoman(int num){
        String result = "";
        int thousand = num / 1000;
        num %= 1000;
        int hundred = num / 100;
        num %= 100;
        int ten = num / 10;
        num %= 10;
        for(int g = 0; g < thousand; g++)
            result += "M";
        if(hundred == 9)
            result += "CM";
        else if(hundred == 4)
            result += "CD";
        else{
            if(hundred >= 5){
                result += "D";
                hundred -= 5;
            }
            for(int i = 0; i < hundred; i++)
                result += "C";
        }
        if(ten == 9)
            result += "XC";
        else if(ten == 4)
            result += "XL";
        else{
            if(ten >= 5){
                result += "L";
                ten -= 5;
            }
            for(int j = 0; j < ten; j++)
                result += "X";
        }
        if(num == 9)
            result += "IX";
        else if(num == 4)
            result += "IV";
        else{
            if(num >= 5){
                result += "V";
                num -= 5;
            }
            for(int a = 0; a < num; a++)
                result += "I";
        }
        return result;
    }
    public static boolean formula(String string){
        string = " " + string + " ";
        String[] part = string.split("=");
        int answer = 0;

        for(int g = 0; g < part.length; g++){
            String[] element = part[g].split(" ");
            int sum = 0;

            if(element.length > 3) {
                if (element[2].equals("+"))
                    sum = Integer.parseInt(element[1]) + Integer.parseInt(element[3]);
                else if (element[2].equals("-"))
                    sum = Integer.parseInt(element[1]) - Integer.parseInt(element[3]);
                else if (element[2].equals("*"))
                    sum = Integer.parseInt(element[1]) * Integer.parseInt(element[3]);
                else if (element[2].equals("/"))
                    sum = Integer.parseInt(element[1]) / Integer.parseInt(element[3]);
            }else
                sum = Integer.parseInt(element[1]);
            if(g == 0)
                answer = sum;
            else
                if(answer != sum)
                    return false;
        }
        return true;
    }
    public static boolean palindromedescendant(String num){
        if(num.length() == 1)
            return true;
        while(num.length() >= 2){
            String string = "";
            boolean check = true;

            for(int g = 0; g < num.length() / 2; g++)
                if(num.charAt(g) != num.charAt(num.length() - g - 1))
                    check = false;
            if(check)
                return true;
            for(int j = 0; j < num.length(); j += 2)
                string += (Integer.parseInt("" + num.charAt(j)) + Integer.parseInt("" + num.charAt(j + 1)));
            num = string;
        }
        return false;
    }
}
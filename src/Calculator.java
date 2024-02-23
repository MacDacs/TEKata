import java.util.Scanner;

 class Roman {
    static String[] romanArray = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
            "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
            "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
            "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
            "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
            "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
            "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
            "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
            "XCVIII", "XCIX", "C"};


    public static boolean isRoman(String val) {
        for (int i = 0; i < romanArray.length; i++) {
            if (val.equals(romanArray[i])) {
                return true;
            }
        }
        return false;
    }

    public static int convertToArabian(String roman) {
        for (int i = 0; i < romanArray.length; i++) {
            if (roman.equals(romanArray[i])) {
                return i;
            }
        }
        return -1;
    }

    public static String convertToRoman(int arabian) {
        return romanArray[arabian];
    }
}
    public class Calculator {
        public static void main(String[] args) throws Exception {
            Scanner ch = new Scanner(System.in);
            System.out.println("Введите выражение");
            String g = ch.nextLine();
            System.out.print(calc(g));
        }

        public static String calc(String g) throws Exception {
            int a;
            int b;
            String oper;
            String result;
            int pres;

            String[] del = g.split("[+\\-*/]");
            if (del.length != 2) throw new Exception("Превышено допустимое число операндов");
            oper = Operand(g);
            if (oper == null) throw new Exception("Некоректное выражение");
            if (Roman.isRoman(del[0]) && Roman.isRoman(del[1])) {
                a = Roman.convertToArabian(del[0]);
                b = Roman.convertToArabian(del[1]);
                if (a > 10 || b > 10) throw new Exception("Числа должны быть от 1 до 10");
                pres = calculator(oper, a,b);
                if (pres == - 1)throw new Exception();
                result = Roman.convertToRoman(pres);
                return result;
            }
            if (!Roman.isRoman(del[0]) || !Roman.isRoman(del[1])){
                a = Integer.parseInt(del[0]);
                b = Integer.parseInt(del[1]);
                if (a > 10 || b > 10) throw new Exception();
                pres = calculator(oper,a,b);
                result = String.valueOf(pres);
                return result;
            }else throw new Exception();
        }

        static int calculator(String oper, int a, int b){
            return switch (oper) {
                case "-" -> a - b;
                case "+" -> a + b;
                case "*" -> a * b;
                default -> a / b;
            };
        }


        static String Operand(String g) {
            if (g.contains("+")) return "+";
            else if (g.contains("-")) return "-";
            else if (g.contains("/")) return "/";
            else if (g.contains("*")) return "*";
            else return null;
        }
    }


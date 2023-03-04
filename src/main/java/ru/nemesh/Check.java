package ru.nemesh;

public class Check {
    public static int getNum(String input) throws Exception {
        boolean resultNumeric = Numeric(input);

        if (resultNumeric == (true)) {
            int b = Integer.parseInt(input);
            boolean c = NegativeNumber(Integer.parseInt(input));
            if (c == true) {
                throw new NegativeException("Число должно быть положительным!!!");
            } else
                return Integer.parseInt(getChecknum(input));
//        } else {
//            if (resultNumeric == (false)) ;
//            return checkRom(a);
        }
        return 0;
    }

    static String getChecknum(String input)throws NullnumException {
        String[] mas = input.split("");
        String a = String.valueOf(mas.length);
        for (int i = 0; i < a.length(); i++) {
            if (a.equals("1")) ;
            if (a.equals("2")) ;
            if (a.equals("3")) ;
            if (a.equals("4")) ;
            if (a.equals("5")) ;
            if (a.equals("6")) ;
            if (a.equals("7")) ;
            if (a.equals("8")) ;
            if (a.equals("9")) ;
            if (a.equals("0")) {
                return a;
            } else {
                throw new NullnumException("Введите ИНН из 10 чисел");
            }
        }
        return a;
    }


    public static boolean Numeric(String a) {
        try {
            Double.parseDouble(a);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    private static boolean NegativeNumber(int a) {

        if (a < 0) {
            return true;
        } else {
            return false;
        }
    }

    public static String getHownum(String a) throws NullnumException {     //проверяем сколько чисел введено в строку
        boolean resultNum = HowmachMas(a);

        if (resultNum == (true)) {
            return a;
        } else {
            throw new NullnumException("Введите ИНН из 10 чисел");
        }
    }

    private static boolean HowmachMas(String a) {

        String[] mas = a.split("");
        int arrayLength = mas.length;
        for (int i = 0; i < a.length(); i++) {
            if (arrayLength == 10) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static String getProbel(String input) throws ProbelException {
        boolean space = containsWhiteSpace(input);
        if (space == false)
            return input;
        else
            throw new ProbelException("Числа должны быть без пробела!");
    }

    public static boolean containsWhiteSpace(String input) {
        boolean space = false;
        if (input != null) {
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == ' ') {
                    space = true;
                    return true;
                }
            }
        }
        return space;
    }
}
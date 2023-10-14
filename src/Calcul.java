class Calcul{

    public static String calc(String input) throws Exception {

        boolean isRoman = false;
        int result;
        String[] inputSplit = input.split(" ");

        if (inputSplit.length != 3){
            throw new NumberFormatException("Неверно введённое выражение.");
        }

        Integer firstNumber = 0;
        Integer secondNumber = 0;

        try {
            firstNumber = Integer.valueOf(inputSplit[0]);
            secondNumber = Integer.valueOf(inputSplit[2]);
        } catch (NumberFormatException e) {

            try {
                firstNumber = Calcul.romanToArab(inputSplit[0]);
                secondNumber = Calcul.romanToArab(inputSplit[2]);
                isRoman = true;
            } catch (NumberFormatException ex) {
                throw new NumberFormatException("Ошибка считывания цифр.");
            }
        }

        if ((firstNumber < 1) || (firstNumber > 10) || (secondNumber < 1) || (secondNumber > 10)){
            throw new NumberFormatException("Введенные числа выходят из диапазона ожидаемых. ");
        }

        String sign = inputSplit[1];
        switch (sign) {
            case "+" -> result = firstNumber+secondNumber;
            case "-" -> result = firstNumber-secondNumber;
            case "*" -> result = firstNumber*secondNumber;
            case "/" -> result = firstNumber/secondNumber;
            default -> {
                throw new ArithmeticException("Неверно введен арифметический знак.");
            }
        }


        if (isRoman){

            if(result < 1){
                throw new Exception("Результат меньше 1, невозможно конвертировать в римские.");
            } else {
                return Calcul.arabToRome(result);
            }
        } else {
            return Integer.toString(result);
        }


    }

    public static Integer romanToArab(String romanInput){
        int result = 0;
        int[] arab = {10, 9, 5, 4, 1};
        String[] roman = {"X", "IX", "V", "IV", "I"};

        for (int i = 0; i < arab.length; i++ ) {

            while (romanInput.indexOf(roman[i]) == 0) {
                result += arab[i];
                romanInput = romanInput.substring(roman[i].length());
            }
        }

        return result;
    }

    static String arabToRome(int arabInput){
        String result = "";
        int value = 0;
        int[] arab = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < arab.length; i++){

            value = arabInput / arab[i];
            for (int j = 0; j < value; j++){
                result = result.concat(roman[i]);
            }
            arabInput = arabInput % arab[i];
        }
        return result;
    }
}
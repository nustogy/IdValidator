import java.util.HashMap;
import java.util.Map;

public class PolishIdValidator implements IdValidator {

    public PolishIdValidator() {
    }

    @Override
    public boolean validate(String input) {
        if (!formatChecker(input))
            return false;

        Map<Character, Integer> lettersValue = new HashMap<>();
        int counter = 10;
        for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
            lettersValue.put(alphabet, counter);
            counter++;
        }

        String[] toCheck = input.toUpperCase().split("");

        int[] toCheckValuesArr = new int[toCheck.length];

        for (int i = 0; i <3 ; i++) {

            toCheckValuesArr[i] = lettersValue.get(toCheck[i].charAt(0));
        }

        for (int i = 3; i < 9; i++) {
            int number = Integer.parseInt(toCheck[i]);
            toCheckValuesArr[i] = number;
        }


        int[] multipliers = {7, 3, 1, 9, 7, 3, 1, 7, 3};

        int controlSum =0;

        for (int i = 0; i <toCheckValuesArr.length ; i++) {

            controlSum += toCheckValuesArr[i]*multipliers[i];

        }

        return controlSum%10==0;

    }

    private boolean formatChecker(String input){

        return input.toUpperCase().matches("[A-Z]{3}\\d{6}");
    }

}

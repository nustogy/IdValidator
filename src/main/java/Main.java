import Validator.PolishIdValidator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        PolishIdValidator polishIdValidator = new PolishIdValidator();
        System.out.println("To check put ID number:");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(polishIdValidator.validate(input));

    }
}


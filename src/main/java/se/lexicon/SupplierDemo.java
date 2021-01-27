package se.lexicon;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.function.Supplier;

public class SupplierDemo {

    public static void main(String[] args) {
        Supplier<Double> randomValue = () -> Math.random();
        System.out.println(randomValue.get());

        Supplier<LocalDate> sysDate = () -> LocalDate.now();

        System.out.println("sysDate.get() = " + sysDate.get());

        System.out.println("Enter a Number: ");
        System.out.println(decimal.get());
    }


    public static Scanner scanner= new Scanner(System.in);

    public static Supplier<Double> decimal = () -> {
        double number = 0;
        boolean valid = false;
        while (!valid){
            try{
                number = Double.parseDouble(scanner.nextLine());
                valid = true;
            }catch (NumberFormatException n){
                System.out.println("Number is not valid");
            }

        }
        return number;
    };

}

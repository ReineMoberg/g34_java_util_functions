package se.lexicon;

import java.util.Random;
import java.util.function.IntUnaryOperator;

public class MethodReferenceExample {

    public static int getRandomInt(int max){
        return new Random().nextInt(max + 1) + 1;  // 1 to max
    }

    public static void main(String[] args) {
        // method references in static method
        IntUnaryOperator opM= MethodReferenceExample::getRandomInt;
        // invoke method using lambda expression
        IntUnaryOperator opL = num -> MethodReferenceExample.getRandomInt(num);

        System.out.println(opM.applyAsInt(200));
        System.out.println(opL.applyAsInt(200));
    }


}

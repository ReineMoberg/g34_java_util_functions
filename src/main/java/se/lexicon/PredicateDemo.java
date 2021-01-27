package se.lexicon;

import java.time.LocalDate;
import java.util.function.Predicate;

public class PredicateDemo {
    /*
    Takes any object as an argument and return a boolean
    Use cases: if statements, filtering Collection and Stream
    Single Abstract method: boolean test(T t);
    Predicate<T>
     */


    public static void main(String[] args) {
        Predicate<Integer> positiveInteger = n -> n > 0;
        Predicate<Integer> greaterThanTen = n -> n > 10;
        Predicate<Integer> lowerThanTwenty = (integer) -> integer < 20;

        boolean result = positiveInteger.test(1200);
        System.out.println("positiveInteger Test = " + result);
        System.out.println(greaterThanTen.test(22));

        Predicate<Person> bornInALeapYear = person -> person.getBirthDate().isLeapYear();
        Predicate<Person> firstNameLengthMaxCheck = p -> p.getFirstName().length() <= 20;
        System.out.println("----------------------------");
        Person testPerson = new Person(
                "Test",
                "Test",
                LocalDate.of(1900, 9, 11),
                false
        );

        System.out.println(bornInALeapYear.test(testPerson));
        System.out.println(firstNameLengthMaxCheck.test(testPerson));

        // and(): return a composed predicate
        // predicate chaining
        boolean testAndResult = greaterThanTen.and(lowerThanTwenty).test(15);
        System.out.println("testAndResult = " + testAndResult);
        // negate(): returns  predicate that represents the logical negation of this predicate
        boolean negateOrNotOfResult = greaterThanTen.and(lowerThanTwenty).negate().test(15);
        System.out.println("negateOrNotOfResult = " + negateOrNotOfResult);


    }
}

package se.lexicon;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionDemo {

    public static void main(String[] args) {
        String[] strings = {"I","love","Java"};
        Function<String[],String> arrayToString = array -> {
            String target = "";
            for (String s : array){
                target+= s + " ";
            }
            return target;
        };
        System.out.println(arrayToString.apply(strings));

        // ex2
        Function<Person, String> extractFullName = person -> person.getFirstName() +" "+ person.getLastName();


        List<Person> personList= new ArrayList<>();
        personList.add(new Person("Test1","Testsson1", LocalDate.parse("2000-10-10"),false));
        personList.add(new Person("Test2","Testsson2", LocalDate.parse("2001-10-10"),false));
        personList.add(new Person("Test3","Testsson3", LocalDate.parse("2002-10-10"),false));

        /*for (Person p: personList){
            String fullName = extractFullName.apply(p);
            System.out.println("fullName = " + fullName);
        }
         */

        List<String> result = extractFN(personList,extractFullName);
        result.forEach(s -> System.out.println(s));

    }

    public static  List<String> extractFN(List<Person> list,Function<Person,String> extract){
        List<String> names = new ArrayList<>();
        for (Person personFN: list) {
            names.add(extract.apply(personFN));
        }
        return names;
    }
}

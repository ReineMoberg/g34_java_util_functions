package se.lexicon;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

    /*
    Takes any object and return nothing (void)
    use cases: when we want to do void things - when it is not needed to return anu value - often used in logging
    Abstract Method: void accept(T t);
     */

    public static void main(String[] args) {
        Consumer<String> printMessage = s -> System.out.println(s);
        printMessage.accept("Hello String consumer");

        Consumer<Person> printFullName = person -> System.out.println(person.getFirstName() + " " + person.getLastName());
        Consumer<Person> personInformation = person -> System.out.println(person.toString());

        Person testPerson = new Person("Test","Testsson", LocalDate.parse("2000-10-10"),false);
        printFullName.accept(testPerson);
        personInformation.accept(testPerson);

        Consumer<List<Person>> activePerson = list -> {
            for (int i = 0; i< list.size(); i++){
                Person person= list.get(i);
                person.setActive(true);
                list.add(i,person);
            }
        };


        List<Person> personList= new ArrayList<>();
        personList.add(new Person("Test1","Testsson1", LocalDate.parse("2000-10-10"),false));
        personList.add(new Person("Test2","Testsson2", LocalDate.parse("2001-10-10"),false));
        personList.add(new Person("Test3","Testsson3", LocalDate.parse("2002-10-10"),false));

        /*for (Person p: personList){
            System.out.println(p.toString());
        }
         */
        System.out.println("----------------------");
        personList.forEach(p -> p.setActive(true));
        personList.forEach(personInformation);
    }
}

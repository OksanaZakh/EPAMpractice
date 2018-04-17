package Stream.PersonStream;

import java.util.List;
import java.util.stream.Collectors;

public class PersonStream {
    private List<Person> people;

    public PersonStream() {
        this.people = PersonsGenerator.generatePeople(20);
    }

    public void run() {
        System.out.println("List of random people:");
        System.out.println(people);
        System.out.println("List of reservists:");
        createListOfReservists();
        System.out.println("Average age of women:");
        calculateFemaleAveAge();
        calculateFemaleAveAgeVersion2();

    }

    private void createListOfReservists() {
        people.stream().
                filter(person -> (person.getMale() == Person.Male.male) && (person.getAge() > 18 && person.getAge() < 60))
                .forEach(System.out::println);
    }

    private void calculateFemaleAveAge() {
        List<Integer> ages = people.stream().filter(person -> (person.getMale() == Person.Male.female)).map(Person::getAge).
                collect(Collectors.toList());
        int aveAge = (ages.stream().reduce((a, b) -> (a + b))).get() / ages.size();
        System.out.println(aveAge);
    }

    //incorrect
    private void calculateFemaleAveAgeVersion2() {
        int aveAge = people.stream().filter(person -> (person.getMale() == Person.Male.female)).map(Person::getAge).
                reduce((a, b) -> ((a + b) / 2)).get();
        System.out.println(aveAge);

    }

}

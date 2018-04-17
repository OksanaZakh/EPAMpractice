package Stream.PersonStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonsGenerator {

    private static final String [] FEMALE_NAMES= {"Ann", "Emma", "Olivia", "Sophia", "Ava", "Isabella", "Mia", "Abigail",
            "Emily", "Charlotte", "Ella", "Victoria", "Lily", "Allison", "Gabriella"};

    private static final String [] MALE_NAMES= {"James", "John", "Robert", "Michael", "William", "David", "Richard", "Joseph",
            "Thomas", "Charles", "Christopher", "Daniel", "Matthew", "Anthony", "Bob"};


    public static List<Person> generatePeople(int numPerson) {
        Random random = new Random();
        List<Person> people = new ArrayList<>();
        Person person = null;
        for (int i = 0; i < numPerson; i++) {
            person = new Person();
            int randomMail = random.nextInt(2);
            Person.Male male = null;
            String name="";
            int age=random.nextInt(80);
            if (randomMail == 1) {
                male = Person.Male.male;
                name=MALE_NAMES[random.nextInt(15)];
            }
            else {
                male = Person.Male.female;
                name=FEMALE_NAMES[random.nextInt(15)];
            }
            person.setMale(male);
            person.setName(name);
            person.setAge(age);
            people.add(person);
        }
        return people;
    }
}

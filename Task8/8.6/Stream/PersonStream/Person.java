package Stream.PersonStream;

public class Person {
    private String name;
    private int age;
    private Male male;

    enum Male{male, female}

    public Person(String name, int age, Male male) {
        this.name = name;
        this.age = age;
        this.male = male;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Male getMale() {
        return male;
    }

    public void setMale(Male male) {
        this.male = male;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", male=" + male +
                '}';
    }
}

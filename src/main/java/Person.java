import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Person {

    public Sex getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    private final Sex sex;
    private final int age;
    private final String name;

    public Person(String name, int age, Sex sex) {
        this.sex = sex;
        this.age = age;
        this.name = name;
    }

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Вася", 16, Sex.MALE),
                new Person("Петя", 23, Sex.MALE),
                new Person("Олена", 42, Sex.FEMALE),
                new Person( "Іван Іванович", 69, Sex.MALE));

    }

    public static List<Person> selectOnlyWomen(List<Person> people) {
        return people.stream().filter(p->p.getAge() > 18 && p.getAge() < 60 && p.getSex()==Sex.FEMALE).collect(Collectors.toList());
    }

    public static double averageMenAge(List<Person> people) {
        return people.stream().filter(p->p.getSex()==Sex.MALE).mapToDouble(Person::getAge).average().getAsDouble();
    }

    public static long countWorkingPeople(List<Person> people) {
        return people.stream().filter(p -> {
                    if(p.getSex()==Sex.MALE) {
                        return p.getAge() < 60;
                    } else {
                        return p.getAge() < 55;
                    }
                }).count();
    }

}

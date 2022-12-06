
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void shouldReturnOnlyWomen(){
        List<Person> people = List.of(
                new Person("Вася", 16, Sex.MALE),
                new Person("Петя", 23, Sex.MALE),
                new Person("Олена", 42, Sex.FEMALE),
                new Person( "Іван Іванович", 69, Sex.MALE));

        List<Person> women = Person.selectOnlyWomen(people);

        assertTrue(women.stream().allMatch(p->p.getSex()==Sex.FEMALE));


    }

    @Test
    public void shouldCountAverageMenAge(){
        List<Person> people = List.of(
                new Person("Вася", 16, Sex.MALE),
                new Person("Петя", 23, Sex.MALE),
                new Person("Олена", 42, Sex.FEMALE),
                new Person( "Іван Іванович", 69, Sex.MALE));

        double age = Person.averageMenAge(people);

        assertEquals(36.0, age);


    }

    @Test
    public void shouldCountWorkingPeople(){
        List<Person> people = List.of(
                new Person("Вася", 16, Sex.MALE),
                new Person("Петя", 23, Sex.MALE),
                new Person("Олена", 42, Sex.FEMALE),
                new Person( "Іван Іванович", 69, Sex.MALE));

        double numberOfWorkPeople = Person.countWorkingPeople(people);

        assertEquals(3, numberOfWorkPeople);


    }





}


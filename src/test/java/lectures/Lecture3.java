package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import beans.Person;
import com.google.common.collect.ImmutableList;
import java.util.Comparator;
import java.util.List;

import mockdata.MockData;
import org.junit.Test;

public class Lecture3 {

  @Test
  public void min() throws Exception {
    final List<Integer> numbers = ImmutableList.of(8, 66, 3, 100, 23, 93, 99);
    int min = numbers.stream().min((number1, number2) -> number1 > number2 ? 1 : -1).get();
    System.out.println("Minimum is " + min);

    int minA = numbers.stream().min(Comparator.naturalOrder()).get();
    System.out.println("Minimum is " + minA);

    int minB = numbers.stream().min(Comparator.comparing(Integer::valueOf)).get();
    System.out.println("Minimum is " + minB);

    List<Person> people = MockData.getPeople();
    Person person = people.stream().min(Comparator.comparing(Person::getAge)).get();
    System.out.println(person);
  }

  @Test
  public void max() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);
    int max = numbers.stream().max((num1,num2) -> num1 > num2 ? 1 : -1).get();
    System.out.println("Maximum is " + max);

    max = numbers.stream().max(Comparator.naturalOrder()).get();
    System.out.println("Maximum is " + max);

    max = numbers.stream().max(Comparator.comparing(Integer::valueOf)).get();
    System.out.println("Maximum is " + max);

    List<Person> people = MockData.getPeople();
    Person person = people.stream().max(Comparator.comparing(Person::getAge)).get();
    System.out.println("Maximum is " + person);

  }
}

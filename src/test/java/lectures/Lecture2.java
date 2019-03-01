package lectures;

import beans.Person;
import java.util.List;
import java.util.stream.IntStream;
import mockdata.MockData;
import org.junit.Test;

public class Lecture2 {

  @Test
  public void range() throws Exception {}

  @Test
  public void rangeIteratingLists() throws Exception {
    List<Person> people = MockData.getPeople();

    people.forEach(System.out::println);

    System.out.println("\n********** ONE ***************\n");

    people.stream().forEach(System.out::println);

    System.out.println("\n***********  TWO **************\n");

    people.stream().forEach(person -> System.out.println(person));

    System.out.println("\n***********  THREE **************\n");

    IntStream.range(0, people.size())
        .forEach(
            index -> {
              Person person = people.get(index);
              System.out.println(person);
            });

    System.out.println("\n***********  FOUR **************\n");

    IntStream.range(0, people.size()).forEach(System.out::println);
  }

  @Test
  public void intStreamIterate() throws Exception {
    IntStream.iterate(0, operand -> operand + 1)
        .filter(number -> number % 2 == 0)
        .limit(20)
        .forEach(System.out::println);
  }
}

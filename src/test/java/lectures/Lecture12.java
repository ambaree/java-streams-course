package lectures;

import beans.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture12 {
  @Test
  public void understandingCollect() throws Exception {
    List<String> emails = MockData.getPeople()
        .stream()
        .map(Person::getEmail)
        .collect(Collectors.toList());

    emails.forEach(System.out::println);
  }


  @Test
  public void understandingCollectInWay1() throws Exception {
    List<String> emails = MockData.getPeople()
            .stream()
            .map(Person::getEmail)
            .collect(() -> new ArrayList<String>(),  (list, element) -> list.add(element), (list1, list2) -> list1.addAll(list2));

    emails.forEach(System.out::println);
  }

  @Test
  public void understandingCollectInWay2() throws Exception {
    List<String> emails = MockData.getPeople()
            .stream()
            .map(Person::getEmail)
            .collect(ArrayList::new, ArrayList::add, ArrayList::addAll); //alt + enter to get method references

    emails.forEach(System.out::println);
  }
}

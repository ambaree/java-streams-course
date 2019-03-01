package lectures;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import com.google.common.collect.ImmutableList;

import beans.Person;
import mockdata.MockData;


public class Lecture1 {

  @Test
  public void imperativeApproach() throws IOException {
    int limit = 10;
    int counter = 0;
    List<Person> people = MockData.getPeople();
    List<Person> peopleAgedLessThanEighteen = new ArrayList<Person>();
    List<Person> peopleFirstTen = people.subList(0,10);
    for(Person person : people){
      if(person.getAge() <= 18){
        peopleAgedLessThanEighteen.add(person);
        counter ++;
//        if(counter >= limit){
//          break;
//        }
      }
    }

    System.out.println("Under 18 People size is " + peopleAgedLessThanEighteen.size());
    System.out.println("First ten people are " + peopleFirstTen.size());

    System.out.println("***************************");

    List<Person> youngPeople = people.stream().filter(person -> person.getAge() <= 18).collect(Collectors.toList());
    youngPeople.stream().forEach(person -> System.out.println(person.getAge()));
    System.out.println(youngPeople.stream().count());

    // 1. Find people aged less or equal 18
    // 2. Then change implementation to find first 10 people

  }

  @Test
  public void declarativeApproachUsingStreams() throws Exception {
    ImmutableList<Person> people = MockData.getPeople();

  }
}

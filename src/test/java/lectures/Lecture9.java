package lectures;


import beans.Person;
import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.Optional;

import mockdata.MockData;
import org.junit.Test;

public class Lecture9 {

  @Test
  public void reduce() throws Exception {
    Integer[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};
    int sum = Arrays.stream(integers).reduce(0, Integer::sum);
    int sum1 = Arrays.stream(integers).reduce(Integer::sum).get();
    int sum2 = Arrays.stream(integers).reduce(0, (a, b) -> a+b);

    System.out.println(sum + " : " + sum1 + " : " + sum2);
  }


  @Test
  public void getLastElement() throws Exception {
    Person lastElement = MockData.getPeople().stream().reduce((a, b) -> b).get();
    System.out.println(lastElement);
  }

}


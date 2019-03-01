package lectures;


import beans.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.Test;

public class Lecture8 {

  @Test
  public void simpleGrouping() throws Exception {
    Map<String, List<Car>> redCars = MockData.getCars().stream()
            .filter(car -> car.getColor().equalsIgnoreCase("Red"))
            .limit(30)
            .collect(Collectors.groupingBy(Car::getMake));

    redCars.forEach((companyName, cars) -> {
      System.out.println(companyName + " : " );
      cars.forEach(System.out::println);
    });
  }

  @Test
  public void groupingAndCounting() throws Exception {
    ArrayList<String> names = Lists
        .newArrayList(
            "John",
            "John",
            "Mariam",
            "Alex",
            "Mohammado",
            "Mohammado",
            "Vincent",
            "Alex",
            "Alex"
        );
    Map<String, List<String>> namesCollection = names.stream().collect(Collectors.groupingBy(Function.identity()));

    Map<String, Long> count = names.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    namesCollection.forEach(
        (name, nameList) -> {
          System.out.println(name + " : ");
          nameList.forEach(System.out::println);
        });

    count.forEach((name, nameCount) -> System.out.println(name + " : " + nameCount));
  }

}
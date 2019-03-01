package lectures;

import beans.Car;
import mockdata.MockData;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;

public class Lecture7 {

  private Predicate<Car> predicate = car -> car.getMake().equalsIgnoreCase("Ford");

  @Test
  public void count() throws Exception {
    long count = MockData.getCars().stream().filter(predicate).count();
    System.out.println("count is " + count);
  }

  @Test
  public void min() throws Exception {
    final double min =
        MockData.getCars()
            .stream()
            .filter(predicate)
            .mapToDouble(Car::getPrice)
            .min()
            .orElseThrow(() -> new IllegalStateException("stream is empty"));
    System.out.println("min is " + min);
  }

  @Test
  public void max() throws Exception {
    double max =
        MockData.getCars().stream().filter(predicate).mapToDouble(Car::getPrice).max().orElse(0);
    System.out.println("max is " + max);
  }

  @Test
  public void average() throws Exception {
    List<Car> cars = MockData.getCars();
    double avg = cars.stream().mapToDouble(Car::getPrice).average().orElse(0);
    System.out.println("avg is " + avg);
  }

  @Test
  public void sum() throws Exception {
    List<Car> cars = MockData.getCars();
    double sum = cars.stream().mapToDouble(Car::getPrice).sum();
    BigDecimal bigDecimalSum = BigDecimal.valueOf(sum);
    System.out.println(sum);
    System.out.println("sum is " + bigDecimalSum);
  }

  @Test
  public void statistics() throws Exception {
    List<Car> cars = MockData.getCars();
    DoubleSummaryStatistics statistics =
        cars.stream().mapToDouble(Car::getPrice).summaryStatistics();
    System.out.println(statistics);
    System.out.println("avg is " + statistics.getAverage());
    System.out.println("count is " + statistics.getCount());
    System.out.println("max is " + statistics.getMax());
    System.out.println("min is " + statistics.getMin());
    System.out.println(statistics.getSum());
    System.out.println("sum is " + BigDecimal.valueOf(statistics.getSum()));
  }
}

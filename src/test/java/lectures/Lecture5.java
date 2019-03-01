package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.cache.RemovalListener;
import com.google.common.collect.ImmutableList;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.junit.Test;

public class Lecture5 {

  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();

    Predicate<Car> carsLessThan20000 = car -> car.getPrice() < 20000;
    Predicate<Car> carsMoreThan50000 = car -> car.getPrice() > 50000;
    BiPredicate<Car, Integer> carsLessThanSomevalue =
        (car, someValue) -> car.getPrice() < someValue;

    Car max =
        cars.stream().filter(carsLessThan20000).max(Comparator.comparing(Car::getPrice)).get();
    Car cheapHighEndCar =
        cars.stream().filter(carsMoreThan50000).min(Comparator.comparing(Car::getPrice)).get();
    Car CarLessThanLakh =
        cars.stream()
            .filter(car -> carsLessThanSomevalue.test(car, 50000))
            .max(Comparator.comparing(Car::getPrice))
            .get();

    System.out.println(max);
    System.out.println(cheapHighEndCar);
    System.out.println(CarLessThanLakh);
  }

  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data type to another
    List<Person> people = MockData.getPeople();

    Function<Person, PersonDTO> getDto =
        person -> new PersonDTO(person.getId(), person.getFirstName(), person.getAge());

    List<PersonDTO> toddlers =
        people
            .stream()
            .filter(person -> person.getAge() <= 1)
            .map(getDto)
            .collect(Collectors.toList());
    System.out.println(toddlers.size());
    toddlers.forEach(System.out::println);

    List<PersonDTO> masters =
        people
            .stream()
            .filter(person -> person.getAge() <= 8 && person.getAge() > 3)
            .map(PersonDTO::map)
            .collect(Collectors.toList());
    System.out.println(masters.size());
    masters.forEach(System.out::println);
  }

  @Test
  public void averageCarPrice() throws Exception {
    // calculate average of car prices
    ImmutableList<Car> cars = MockData.getCars();
    List<Double> collect = cars.stream().map(car -> car.getPrice()).collect(Collectors.toList());
    final Double averageInt = collect.stream().mapToInt(d -> d.intValue()).average().getAsDouble();
    System.out.println(averageInt);

    Double average = cars.stream().mapToDouble(car -> car.getPrice()).average().orElse(0);
    System.out.println(average);
  }

  @Test
  public void test() throws Exception {
    MockData.getCars().stream().map(car -> car.getMake()).distinct().forEach(System.out::println);
  }
}

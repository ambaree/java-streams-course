package lectures;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture11 {

  @Test
  public void joiningStrings() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");
    String concatednatedString = names.stream().reduce(String::concat).get();
    System.out.println(concatednatedString);

    String join = names.stream().reduce((a, b) -> a.concat(",").concat(b)).get();
    System.out.println(join);
  }

  @Test
  public void joiningStringsWithStream() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");
    final String join = names.stream().collect(Collectors.joining(", ", " starting with : ", " ended"));
    System.out.println(join);
  }
}

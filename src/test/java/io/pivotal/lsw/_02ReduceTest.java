package io.pivotal.lsw;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class _02ReduceTest {

    @Test
    public void reduceIntegers() throws Exception {
        List<Integer> numbers = asList(1, 2, 3, 4, 5);
        int sum = 0;
        for (int x : numbers) {
            sum += x;
        }
        assertThat(sum).isEqualTo(15);

        //todo refactor into reduce stream
        assertThat(numbers.stream().reduce(0, (acc, m) -> acc + m)).isEqualTo(15);
    }

    @Data
    @AllArgsConstructor
    class Person {
        String name;
        int age;
    }

    @Test
    public void mapReduce() throws Exception {
        List<Person> people = asList(new Person("joe", 18), new Person("mary", 31), new Person("anne", 32));
        int sum = 0;
        for (Person x : people) {
            sum += x.age;
        }
        int avg = sum / people.size();
        assertThat(avg).isEqualTo(27);

        //todo refactor into map / reduce stream
        avg = people.stream().map(person -> person.age).reduce(0, (acc, n) -> acc + n) / people.size();
        assertThat(avg).isEqualTo(27);
    }

    @Test
    public void specializedMapReduce() throws Exception {
        List<Person> people = asList(new Person("joe", 18), new Person("mary", 31), new Person("anne", 32));
        int sum = 0;
        for (Person x : people) {
            sum += x.age;
        }
        int avg = sum / people.size();
        assertThat(avg).isEqualTo(27);

        //todo refactor into stream mapToInt / sum
        avg = people.stream().mapToInt(person -> person.age).sum() / people.size();
        assertThat(avg).isEqualTo(27);
    }
}

package io.pivotal.lsw;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example3Test {

    @Test
    public void map() {
        List<Integer> numbers = Arrays.asList(1, -2, -4, 2, 3);
        List<Integer> powerOfTwo = numbers.stream().map(n -> n * n).collect(Collectors.toList());
        System.out.println("powerOfTwo = " + powerOfTwo);
    }

    @Test
    public void reduce() {
        List<Integer> numbers = Arrays.asList(1, 1, 2, 9, 3);
        Integer sum = numbers.stream().reduce(0, (n1, n2) -> n1 + n2);
        System.out.println("sum = " + sum);
    }

    @Test
    public void filter() {
        List<String> names = Arrays.asList("Florence", "Bernadette", "John", "Mike", "Ann", "Paul", "Sarah");
        Stream<String> stringStream = names.stream().filter(n -> n.length() > 4);
        System.out.println("stringStream = " + stringStream.collect(Collectors.toList()));
    }

    class Person {
        String name;
        String residence;

        Person(String name, String residence) {
            this.name = name;
            this.residence = residence;
        }

        public String toString() {
            return name;
        }
    }

    @Test
    public void groupBy() {
        List<Person> people = Arrays.asList(new Person("John", "NYC"), new Person("John", "Sydney"), new Person("Marie", "NYC"));
        Map<String, List<Person>> map = people.stream().collect(Collectors.groupingBy(p -> p.residence));
        List<Person> nyc = map.get("NYC");
        System.out.println("nyc = " + nyc);
    }
}
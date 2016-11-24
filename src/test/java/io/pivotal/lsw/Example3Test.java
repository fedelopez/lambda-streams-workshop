package io.pivotal.lsw;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class Example3Test {

    @Test
    public void map() {
        List<Integer> numbers = asList(1, -2, -4, 2, 3);
        List<Integer> powerOfTwo = numbers.stream().map(n -> n * n).collect(Collectors.toList());
        System.out.println("powerOfTwo = " + powerOfTwo);
    }

    @Test
    public void reduce() {
        List<Integer> numbers = asList(1, 1, 2, 9, 3);
        Integer sum = numbers.stream().reduce(0, (n1, n2) -> n1 + n2);
        System.out.println("sum = " + sum);
    }

    @Test
    public void filter() {
        List<String> names = asList("Florence", "Bernadette", "John", "Mike", "Ann", "Paul", "Sarah");
        List<String> result = names.stream().filter(n -> n.length() > 4).collect(Collectors.toList());
        System.out.println("filter = " + result);
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
        List<Person> people = asList(new Person("John", "NYC"), new Person("John", "Sydney"), new Person("Marie", "NYC"));
        Map<String, List<Person>> map = people.stream().collect(Collectors.groupingBy(p -> p.residence));
        List<Person> nyc = map.get("NYC");
        System.out.println("nyc residents = " + nyc);
    }

    class Developer {
        Set<String> languages;

        Developer(String... languages) {
            this.languages = new HashSet<>();
            this.languages.addAll(asList(languages));
        }
    }

    @Test
    public void flatMap() throws Exception {
        List<Developer> developers = asList(new Developer("Java", "Ruby"), new Developer("JavaScript"));
        List<String> languages = developers
                .stream()
                .map(developer -> developer.languages)
                .flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println("languages = " + languages);
    }
}
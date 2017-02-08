package io.pivotal.lsw;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class _01MapTest {

    @Test
    public void mapIntegers() throws Exception {
        List<Integer> numbers = asList(1, 2, 3, 4, 5);
        List<Integer> squares = _01Map.squares(numbers);
        assertThat(squares).isEqualTo(Arrays.asList(1, 4, 9, 16, 25));

        squares = _01Map.squaresStream(numbers);
        assertThat(squares).isEqualTo(Arrays.asList(1, 4, 9, 16, 25));
    }

    @Data
    @AllArgsConstructor
    class Person {
        String name;
    }

    @Test
    public void mapObject() throws Exception {
        List<Person> people = asList(new Person("steve"), new Person("elon"), new Person("bill"));
        //todo map names into string list
        List<String> strings = people.stream().map(person -> person.getName()).collect(Collectors.toList());
        assertThat(strings).containsOnly("steve", "elon", "bill");
    }

    @Data
    class Hacker {
        Set<String> languages = new HashSet<>();

        Hacker(String... languages) {
            this.languages.addAll(Arrays.asList(languages));
        }
    }

    @Test
    public void flatMap() throws Exception {
        List<Hacker> hackers = asList(new Hacker("Java", "Ruby"), new Hacker("JavaScript"));
        List<String> languages = hackers
                .stream()
                .flatMap(hacker -> hacker.languages.stream().map(String::toUpperCase)).collect(Collectors.toList());
        System.out.println("languages = " + languages);
    }
}

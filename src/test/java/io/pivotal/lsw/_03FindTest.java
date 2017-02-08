package io.pivotal.lsw;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * @author fede
 */
public class _03FindTest {

    @Test
    public void filter() {
        List<String> names = asList("Florence", "Bernadette", "John", "Mike", "Ann", "Paul", "Sarah");
        List<String> result = new ArrayList<>();
        for (String name : names) {
            if (name.length() > 4) {
                result.add(name);
            }
        }
        System.out.println("result = " + result);

        //todo refactor using stream filter
        result = names.stream().filter(n -> n.length() > 4).collect(Collectors.toList());
        System.out.println("filter = " + result);
    }

    @Test
    public void findFirst() {
        List<String> names = asList("Florence", "Bernadette", "John", "Mike", "Ann", "Paul", "Sarah");
        boolean result = false;
        for (String name : names) {
            if (name.equals("John")) {
                result = true;
            }
        }
        System.out.println("result = " + result);

        //todo refactor using stream filter and findFirst
        Optional<String> optional = names.stream().filter(n -> n.equals("John")).findFirst();
        System.out.println("result = " + optional.isPresent());
    }

    @Test
    public void anyMatch() {
        List<String> names = asList("Florence", "John", "Mike", "Ann", "Bernadette", "Paul", "Sarah");
        //todo stream anyMatch: is there any name with more than 8 characters ?
        System.out.println(names.stream().anyMatch(name -> name.length() > 8));
    }
}

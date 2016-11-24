package io.pivotal.lsw;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example4Test {

    @Test
    public void lazyIteration() throws Exception {
        String fileName = "/books.txt";
        Stream<String> stream = Files.lines(Paths.get(getClass().getResource(fileName).toURI()));
        long res = stream
                .map(String::toLowerCase)
                .filter(line -> line.contains("have"))
                .collect(Collectors.counting());
        System.out.println("res = " + res);
    }
}
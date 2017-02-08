package io.pivotal.lsw;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class _06LazyIterationTest {

    @Test
    public void lazyIteration() throws Exception {
        String fileName = "/books.txt";
        Stream<String> stream = Files.lines(Paths.get(getClass().getResource(fileName).toURI()));
        long res = stream
                .map(String::toLowerCase)
                .filter(line -> line.contains("have"))
                .count();
        System.out.println("occurrences = " + res);
    }
}
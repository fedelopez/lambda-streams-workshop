package io.pivotal.lsw;

import com.github.javafaker.Book;
import com.github.javafaker.Faker;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

class _06LazyIteration {

    public static void main(String[] args) throws Exception {
        Book faker = new Faker().book();
        Path path = Paths.get(_06LazyIteration.class.getResource("/books.txt").toURI());
        for (int i = 0; i < 200_000; i++) {
            String fact = faker.title() + "\n";
            Files.write(path, fact.getBytes(), StandardOpenOption.APPEND);
        }
    }
}

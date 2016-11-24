package io.pivotal.lsw;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Example1Test {

    @Test
    public void runnable() {
        Example1.run(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        });
    }

    @Test
    public void runnableLambda() {
        Runnable runnable = () -> System.out.println("Hello World!");
        Example1.run(runnable);
    }

    class Pet {
        String name;

        Pet(String name) {
            this.name = name;
        }

        public String toString() {
            return name;
        }
    }

    @Test
    public void compare() {
        List<Pet> pets = Arrays.asList(new Pet("Daisy"), new Pet("Max"), new Pet("Lucy"), new Pet("Buddy"));
        Comparator<Pet> comparator = new Comparator<Pet>() {
            @Override
            public int compare(Pet p1, Pet p2) {
                return p1.name.compareTo(p2.name);
            }
        };
        pets.sort(comparator);
        System.out.println("pets = " + pets);
    }

    @Test
    public void compareLambda() {
        List<Pet> pets = Arrays.asList(new Pet("Daisy"), new Pet("Max"), new Pet("Lucy"), new Pet("Buddy"));
        Comparator<Pet> comparator = Comparator.comparing(p -> p.name);
        pets.sort(comparator);
        System.out.println("pets = " + pets);
    }
}
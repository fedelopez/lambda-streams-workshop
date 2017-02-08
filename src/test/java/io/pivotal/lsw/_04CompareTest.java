package io.pivotal.lsw;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class _04CompareTest {

    @Data
    @AllArgsConstructor
    class Pet {
        String name;
    }

    @Test
    public void compare() {
        List<Pet> pets = Arrays.asList(new Pet("Daisy"), new Pet("Max"), new Pet("Lucy"), new Pet("Buddy"));
        //todo sort list using comparator lambda
        System.out.println("pets = " + pets);
    }

    @Test
    public void comparingShortcut() {
        List<Pet> pets = Arrays.asList(new Pet("Daisy"), new Pet("Max"), new Pet("Lucy"), new Pet("Buddy"));
        //todo sort list using Comparator.comparing lambda
        System.out.println("pets = " + pets);
    }
}

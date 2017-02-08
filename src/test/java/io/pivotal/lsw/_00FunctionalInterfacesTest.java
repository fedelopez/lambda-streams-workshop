package io.pivotal.lsw;

import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class _00FunctionalInterfacesTest {

    interface StringValidator {
        boolean check(String value);
    }

    @Test
    public void isUpperCase() {
        StringValidator validator = value -> value.toUpperCase().equals(value);
        boolean isUpperCase = validator.check("HELLO");
        System.out.println("result = " + isUpperCase);
    }

    @Test
    public void isUpperCaseUsingPredicates() {
        Predicate<String> predicate = value -> value.toUpperCase().equals(value);
        boolean isUpperCase = predicate.test("HELLO");
        System.out.println("result = " + isUpperCase);
    }

    @Test
    public void isUpperCaseUsingPredicateComposition() {
        Predicate<String> predicate1 = value -> value.toUpperCase().equals(value);
        Predicate<String> predicate2 = value -> value.contains("HE");
        System.out.println("and = " + predicate1.and(predicate2).test("HELLO"));
    }

    @Test
    public void isUpperCaseUsingFunction() {
        Function<String, Boolean> function = value -> value.contains("hello");
        Boolean result = function.apply("hello world");
        System.out.println("result = " + result);
    }

    @Test
    public void biFunction() {
        BiFunction<Double, Double, Double> pythagoras = (x, y) -> Math.sqrt(x * x + y * y);
        Double result = pythagoras.apply(3.0, 4.0);
        System.out.println("result = " + result);
    }

    @Test
    public void binaryOperator() throws Exception {
        BinaryOperator<Double> binaryOperator = (x, y) -> Math.sqrt(x * x + y * y);
        Double result = binaryOperator.apply(3.0, 4.0);
        System.out.println("result = " + result);
    }
}
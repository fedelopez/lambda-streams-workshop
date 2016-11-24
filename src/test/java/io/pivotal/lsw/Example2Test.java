package io.pivotal.lsw;

import io.pivotal.lsw.Example2.StringValidator;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.math.BigDecimal.ROUND_UNNECESSARY;
import static java.math.RoundingMode.*;

public class Example2Test {

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
    public void function() {
        Function<BigDecimal, BigDecimal> ausToEur = x -> x.multiply(new BigDecimal("0.698032")).setScale(2, HALF_UP);
        System.out.println("ausToEur = " + ausToEur.apply(new BigDecimal(56)));
    }

    @Test
    public void binaryOperator() throws Exception {
        BinaryOperator<Integer> binaryOperator = (n1, n2) -> n1 + n2;
        Integer sum = binaryOperator.apply(1, 2);
        System.out.println("apply = " + sum);
    }
}
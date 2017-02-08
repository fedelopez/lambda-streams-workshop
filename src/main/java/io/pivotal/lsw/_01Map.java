package io.pivotal.lsw;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class _01Map {

    static List<Integer> squares(List<Integer> numbers) {
        List<Integer> squares = new ArrayList<>();
        for (int x : numbers) {
            squares.add(x * x);
        }
        return squares;
    }

    static List<Integer> squaresStream(List<Integer> numbers) {
        //todo refactor squares method into stream map
        return numbers.stream().map(n -> n * n).collect(Collectors.toList());
    }

}

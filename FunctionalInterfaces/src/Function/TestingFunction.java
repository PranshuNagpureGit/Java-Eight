package Function;

import java.util.function.Function;

/*
* Function takes one parameter as input and returns one parameter as output
* Supports two default methods in which output of one function becomes input to other function
* 1. Compose - The innermost function is applied first
* 2. andThen - The outermost function is applied first
* */
public class TestingFunction {

    public static void main(String[] args) {

        Function<String,Integer> lengthFunction = str -> str.length();
        System.out.println(lengthFunction.apply("ABCDEF"));

        Function<Integer,Integer> incrementFunction = num -> num + 10;
        Function<Integer,Integer> multiplyFunction = num -> num * 2;

        int composeResult = incrementFunction.compose(multiplyFunction).compose(lengthFunction).apply("ABCDEF");
        System.out.println(composeResult);

        int andThenResult = lengthFunction.andThen(multiplyFunction).andThen(incrementFunction).apply("ABCDEF");
        System.out.println(andThenResult);

    }
}

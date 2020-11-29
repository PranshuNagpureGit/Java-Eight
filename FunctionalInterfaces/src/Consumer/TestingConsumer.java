package Consumer;

import java.util.function.Consumer;

/*
* Consumer takes in a parameter but do not produce anything
* It also has anThen default method for chaining
* */
public class TestingConsumer {

    public static void main(String[] args) {
        Consumer<Integer> consumer1 = a -> System.out.println(String.format("The square of %d is %d",a , a*a));
        Consumer<Integer> consumer2 = a -> System.out.println(String.format("The cube of %d is %d",a , a*a*a));

        consumer1.andThen(consumer2).accept(2);
    }
}

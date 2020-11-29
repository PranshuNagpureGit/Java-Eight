package Supplier;

import java.util.function.Supplier;

/*
* This functional interface takes 0 arguments and returns a value
* */
public class TestingSupplier {

    public static void main(String[] args) {

        Supplier<Integer> supplier = () -> 3;
        System.out.println(supplier.get());

    }
}

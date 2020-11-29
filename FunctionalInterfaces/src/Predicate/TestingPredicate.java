package Predicate;

import java.util.function.Predicate;
/*
 * Predicate takes 1 argument and returns a boolean . Also predicate has following methods.
 * BiPredicate takes 2 argument and returns a boolean.
 * 1. and
 * 2. or
 * 3. negate
 * 4. isEqual  -> static method
 *
 *
 * */
public class TestingPredicate {

    public static void main(String[] args) {
        Person p1 = new Person(61, "Name1");

        Predicate<Person> lessThan60 = p -> p.getAge()<60;
        Predicate<Person> greaterThan18 = p->p.getAge()>18;

        System.out.println(isPersonEligibleForDiscount(p1, lessThan60.and(greaterThan18)));
        System.out.println(isPersonEligibleForDiscount(p1, lessThan60.or(greaterThan18)));
        System.out.println(isPersonEligibleForDiscount(p1, lessThan60.negate()));

        Predicate<String> predicate = Predicate.isEqual("Pranshu");
        System.out.println(predicate.test(p1.getName()));


    }

    private static boolean isPersonEligibleForDiscount(Person person, Predicate<Person> predicate) {
        return predicate.test(person);
    }
}


class Person {
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

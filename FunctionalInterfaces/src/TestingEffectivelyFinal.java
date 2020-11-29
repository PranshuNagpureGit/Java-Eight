import java.util.function.Supplier;
/*
* If a lambda expression captures a local variable then the variable should be either final or effectively final.
* A non-final, local variable whose value is never changed after initialization is known as effectively final.
* Note that value of local variable should not change even after using it in lambda
*
* Before Java 8, we cannot use a non-final, local variable in an anonymous class.
* If you need to access a local variable in an anonymous class, then it should be declared as final.
* This restriction is relaxed in Java 8.Now, the compiler, itself can check if the value of a variable is not changed after the assignment.
* Then, it is effectively final.
*
*
* Why should local variables be final or effectively final?
*  When a local variable is used in a lambda expression, the lambda makes a copy of that variable.
*  This occurs because the scope of a lambda expression is only until the method is in the stack.
*  If the lambda does not make a copy of the variable, then the variable is lost after the method is removed from the stack.
*  Now, if the variable is not final or effectively final, it is possible that the value of the variable is changed after using it in the lambda as shown below.
*
* */
public class TestingEffectivelyFinal {

    public static void main(String[] args) {
        int i = 7;
        Integer i1 = 7;
        Sample sample = new Sample();

        /*Scenario 1*/
            Supplier<Integer> supplier1 = () -> sample.value;
            Supplier<Integer> supplier2 = () -> i+2;

        /*  Scenario-2
            Supplier<Integer> supplier1 = () -> sample.value;
            Supplier<Integer> supplier2 = () -> i+2;
            i++;  // Cannot do this. Will give compilation error at supplier-2\\
        */

        /*  Scenario-3
            Supplier<Integer> supplier3 = () -> { i++; return 10; }; // Cannot re-assign local variable inside lambda
         */

         /* Scenario-4
            i++;
            Supplier<Integer> supplier4 = () -> i+10; // Variable was re-assigned after initialization, hence its not effectively final
        */

        /* Scenario-5
            Supplier<Integer> supplier3 = () -> { sample = new Sample(); return 10; }; // Cannot re-assign local variable inside lambda
        */

        /* Scenario-6
            sample = new Sample();
            Supplier<Integer> supplier4 = () -> sample.value; // Variable was re-assigned after initialization, hence its not effectively final
         */

        /*Scenario-7 */
        sample.value = 10;
        Supplier<Integer> supplier7 = () -> sample.value; // We can modify but not re-assign

        /*Scenario-8
            Supplier<Integer> supplier8 = () -> i1++; // Integer is immutable , hence i++ is re-assigning so cannot do.
         */



    }

}


class Sample {
    int value;

}
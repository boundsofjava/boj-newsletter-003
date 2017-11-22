package com.boundsofjava.newsletter.introducingcombinators;

import java.math.BigDecimal;
import java.util.function.Function;

class AroundExample {

    void demo() {
        System.out.println("----------------------------------");
        System.out.println("Starting AROUND combinator demo...");
        System.out.println("----------------------------------");

        Function<BigDecimal, String> addTaxDecorated =
                Around.decorate(this::addTax).with(this::around);

        String result = addTaxDecorated.apply(new BigDecimal("10000"));

        System.out.println("Done - Result is " + result);
        System.out.println();
    }

    private String addTax(BigDecimal amount) {
        System.out.println("Adding heavy taxes to poor citizen...");
        return "$" + amount.multiply(new BigDecimal("1.22"));
    }

    private void around(Around.Executable<String> function, BigDecimal argument) {
        System.out.println("BEFORE: Argument is " + argument);
        String result = function.execute(); // original function executed here!
        System.out.println("AFTER: Result is " + result);
    }
}

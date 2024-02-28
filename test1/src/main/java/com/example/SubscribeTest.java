package com.example;

import reactor.core.publisher.Flux;

public class SubscribeTest {
    public static void main(String[] args) {
        Flux<Integer> ints = Flux.range(1, 3);
        ints.subscribe();

        ints.subscribe(System.out::println);

        ///////

        Flux<Integer> ints2 = Flux.range(1, 4)
                .map(i -> {
                    if (i <= 3) return i;
                    throw new RuntimeException("Got to 4");
                });

//        ints2.subscribe();
//
//        ints2.subscribe(System.out::println);

        ints2.subscribe(System.out::println,
                error -> System.err.println("Error: " + error));

        ////////
        Flux<Integer> ints3 = Flux.range(1, 4);
        ints3.subscribe(System.out::println,
                error -> System.err.println("Error " + error),
                () -> System.out.println("Done"));
    }
}

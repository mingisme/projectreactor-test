package com.example.basesubscriber;

import reactor.core.publisher.Flux;

public class SubscriberTest {
    public static void main(String[] args) {
        SampleSubscriber<Integer> ss = new SampleSubscriber<>();
        Flux<Integer> ints = Flux.range(1, 4);
        ints.subscribe(ss);
    }
}

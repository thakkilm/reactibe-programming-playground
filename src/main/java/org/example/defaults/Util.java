package org.example.defaults;

import org.reactivestreams.Subscriber;
import reactor.core.publisher.Mono;

public class Util {

    public static <T> Subscriber<T> subscriber(){
        return new DefaultSubscriber<>("");
    }

    public static <T> Subscriber<T> subscriber(String name){
        return new DefaultSubscriber<>(name);
    }

    public static void main(String[] args) {
        var mono= Mono.just(1);
        mono.subscribe(subscriber());
        mono.subscribe(subscriber("one"));
        mono.subscribe(subscriber("two"));
    }
}

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

}

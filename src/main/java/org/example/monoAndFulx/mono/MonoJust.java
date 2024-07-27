package org.example.monoAndFulx.mono;

import org.example.basics.subscrber.SubscriberImpl;
import reactor.core.publisher.Mono;

public class MonoJust {

    public static void main(String[] args) {
        var mono= Mono.just("Mahesh");
        SubscriberImpl subscriber=new SubscriberImpl();
        mono.subscribe(subscriber);
        subscriber.getSubscription().request(2);
    }
}

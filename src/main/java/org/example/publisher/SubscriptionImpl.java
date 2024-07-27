package org.example.publisher;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubscriptionImpl  implements Subscription {

    private static  final Logger log= LoggerFactory.getLogger(SubscriptionImpl.class);
    private  Subscriber<? super String> subscriber;

    private static final int MAX_COUNT=10;
    private final Faker faker;
    private boolean isCompleted;

    private int count=0;

    public SubscriptionImpl(Subscriber<? super String> subscriber) {
        this.subscriber=subscriber;
        this.faker = Faker.instance();
    }

    @Override
    public void request(long requested) {
        if(isCompleted){
            return;
        }
        log.info("subscriber called for {} times",requested);
        if(requested>MAX_COUNT){
            this.subscriber.onError(new RuntimeException("Validation failed"));
            isCompleted=true;
            return;
        }
        for(int i=0;i<requested && count<MAX_COUNT;i++){
            count++;
            this.subscriber.onNext(this.faker.internet().emailAddress());
        }
        if(count==MAX_COUNT){
            log.info("no more date to produce");
            this.subscriber.onComplete();
            this.isCompleted=true;
        }

    }

    @Override
    public void cancel() {
            log.info("subscriber has cancelled");
            isCompleted=true;
    }
}

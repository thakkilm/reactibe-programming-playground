package org.example;

import org.example.publisher.PublisherImpl;
import org.example.publisher.SubscriptionImpl;
import org.example.subscrber.SubscriberImpl;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public class Demo {

    public static void main(String[] args) {

    }
    public void demo1(){
        PublisherImpl publisher=new PublisherImpl();
        SubscriberImpl subscriber=new SubscriberImpl();
        publisher.subscribe(subscriber);
    }

    public void demo2(){
        PublisherImpl publisher=new PublisherImpl();
        SubscriberImpl subscriber=new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
    }
}

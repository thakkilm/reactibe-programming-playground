package org.example.monoAndFulx.mono;

import org.example.defaults.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;

public class MonoDefer {
    private static final Logger log= LoggerFactory.getLogger(MonoDefer.class);

    public static void main(String[] args) {

        //without defer function creation of publisher can be avoided when there is no call to the subscriber
//       Mono.defer(MonoDefer::createPublisher);
//               .subscribe(Util.subscriber());

        //If we run this publisher creation will be happening we  cannot avoid it
        createPublisher();
    }

    public static Mono<Integer> createPublisher(){
       log.info("creating publisher");
        List<Integer> list=List.of(1,2,3);
        return Mono.fromSupplier(()->sum(list));
    }

    public static int sum(List<Integer> list){
        log.info("Executing the method");
        return list.stream().mapToInt(a->a).sum();
    }
}

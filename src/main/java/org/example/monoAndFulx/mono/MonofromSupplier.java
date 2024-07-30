package org.example.monoAndFulx.mono;

import org.example.defaults.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;

public class MonofromSupplier {
    public static final Logger log= LoggerFactory.getLogger(MonofromSupplier.class);

    public static void main(String[] args) {

        //From the below, even though we are not calling the subscribe method the sum method will get executed without delaying
        Mono.just(sum(List.of(1,2,3))).subscribe(Util.subscriber("Mahesh"));

        //Unless until the subscriber is initialized we will not see the sum method executed and will delay the execution
        Mono.fromSupplier(()->sum(List.of(1,2,3))).subscribe(Util.subscriber("Mahesh"));


    }

    public static int sum(List<Integer> list){
        log.info("finding sum for {}",list);
        return list.stream().mapToInt(a->a).sum();
    }
}

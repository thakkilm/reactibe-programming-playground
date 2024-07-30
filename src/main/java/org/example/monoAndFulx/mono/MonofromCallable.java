package org.example.monoAndFulx.mono;

import org.example.defaults.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;

public class MonofromCallable {
    public static final Logger log= LoggerFactory.getLogger(MonofromCallable.class);

    public static void main(String[] args) {

        //The callable and fromSupplier methods does the same operation, only difference is that the supplier
        //does not have inbuilt throws exception whereas callable has throws exception in its method signature
        Mono.fromCallable(()-> sum(List.of(2,3,4))).subscribe(Util.subscriber());
        //Unless until the subscriber is initialized we will not see the sum method executed and will delay the execution
        Mono.fromSupplier(()-> {
            try {
                return sum(List.of(1,2,3));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).subscribe(Util.subscriber("Mahesh"));


    }

    public static int sum(List<Integer> list) throws Exception{
        log.info("finding sum for {}",list);
        return list.stream().mapToInt(a->a).sum();
    }
}

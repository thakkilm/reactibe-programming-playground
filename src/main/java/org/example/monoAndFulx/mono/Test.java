package org.example.monoAndFulx.mono;

import org.example.defaults.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class Test {

    private static final Logger log= LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        test().subscribe(Util.subscriber());
    }
    private static Mono<String> test(){
        log.info("Creating the publisher");
        return Mono.fromSupplier(()->{
           log.info("generating name");
           return Util.faker.name().firstName();
        });
    }
}

package org.example.monoAndFulx.mono;

import org.example.defaults.Util;
import reactor.core.publisher.Mono;

public class MonoEmptyError {

    public static void main(String[] args) {

        //Prints Mahesh
        getUserName(1).subscribe(Util.subscriber("One"));

        //Received null value and prints nothing
        getUserName(2).subscribe(Util.subscriber());

        getUserName(1).subscribe(s-> System.out.println(s));

        //Throws error
        getUserName(3).subscribe(Util.subscriber());
    }

    public static Mono<String> getUserName(int id){
        return switch (id){
            case 1-> Mono.just("Mahesh");
            case 2->Mono.empty();
            default -> Mono.error(new RuntimeException("invalid Argument Error"));
        };

    }
}

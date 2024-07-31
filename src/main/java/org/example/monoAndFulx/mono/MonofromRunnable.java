package org.example.monoAndFulx.mono;

import com.github.javafaker.Faker;
import org.example.defaults.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;

public class MonofromRunnable {
    public static final Logger log= LoggerFactory.getLogger(MonofromRunnable.class);



    public static void main(String[] args) {

        //formRunnable is used to call empty value it is kind of replacement for Mono.empty() which returns nothing
      getProductName(1).subscribe(Util.subscriber());

    }

   private static Mono<String> getProductName(int productId){
        if(productId==1){
            return Mono.fromSupplier(()->Util.faker.commerce().productName());
        }
        return Mono.fromRunnable(()->notifyBusiness(productId));
   }
   private static void notifyBusiness(int productId){
        log.info("No product found for the id {}",productId);
   }
}

package com.traccialo.producerservice;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import java.util.function.Consumer;

@Slf4j
@Component
public class ValuesConsumer {

    @Bean
    public Consumer<String> onReceive() {
        return (message) -> {
          log.info("Received the value {} in Consumer", message);
        };
    }
}
package com.traccialo.producerservice;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ValueController {

    private StreamBridge streamBridge;

    public ValueController(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @GetMapping("values/{value}")
    public ResponseEntity<String> values(@PathVariable String value) {
    	for(int i=0; i<10000;i++) {
    		  log.info("Sending value {} to topic", i);
    	        streamBridge.send("values-topic", i);
    	}
        return ResponseEntity.ok("ok");
    }
}
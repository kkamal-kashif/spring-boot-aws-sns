package com.kk.rest;

import com.kk.service.SNSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SNSController {

    @Autowired
    private SNSService service;

    @PostMapping(path = "/publish")
    public ResponseEntity<String> publishMail(@RequestBody List<String> payload) {

        service.pubTopic(payload.get(0), payload.get(1));
        return new ResponseEntity<>("Message published", HttpStatus.OK);
    }
}

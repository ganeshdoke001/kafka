package com.codeq.producer.controller;

import com.codeq.producer.handler.WikiMediaHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1")
public class MessageController {

    @Autowired (required=true)
    private WikiMediaHandler wikiMediaHandler;
    @PostMapping (path = "/send")
    public ResponseEntity<String >send(){
        wikiMediaHandler.send("wikimedia_recentChange","Ganesh");
    return ResponseEntity.status(HttpStatus.CREATED).body("Ganesh");
    }
}

package com.core.pilot.port;


import com.core.pilot.adapter.model.FirstDocument;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class FirstController {

    private static final Logger log = LoggerFactory.getLogger(FirstController.class);

    @Autowired
    DocumentServiceI documentServiceI;

    @GetMapping("/test")
    public String firstGet(){
        log.info("received request on firstGet");
        return "test";
    }

    @GetMapping("/getAllFirstDocument")
    public List<FirstDocument> getAllFirstDocument(){
        log.info("received request on getAllFirstDocument");
        return documentServiceI.getAllFirstDocuments();
    }

    @PostMapping("/createFirstDocument")
    public FirstDocument createFirstDocument(@RequestBody FirstDocument firstDocument){
        log.info("received request on createFirstDocument");
        return documentServiceI.createFirstDocument(firstDocument);
    }
}

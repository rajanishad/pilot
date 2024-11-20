package com.core.pilot.port;


import com.core.pilot.adapter.model.FirstDocument;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class FirstController {


    @Autowired
    DocumentServiceI documentServiceI;

    @GetMapping("/test")
    public String firstGet(HttpServletRequest httpServletRequest){
        log.info("received request on firstGet");
        return "test"+httpServletRequest.getSession().getId();
    }



    @GetMapping("/test2")
//    @PreAuthorize("hasRole('allow_test')")
    public String firstGet2(){
        log.info("received request on firstGet2");
        return "test";
    }

    @GetMapping("/getAllFirstDocument")
    public List<FirstDocument> getAllFirstDocument(){
        log.info("received request on getAllFirstDocument");
        return documentServiceI.getAllFirstDocuments();
    }
    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest httpServletRequest){
        return (CsrfToken) httpServletRequest.getAttribute("_csrf");
    }

    @PostMapping("/createFirstDocument")
    public FirstDocument createFirstDocument(@RequestBody FirstDocument firstDocument){
        log.info("received request on createFirstDocument");
        return documentServiceI.createFirstDocument(firstDocument);
    }
}

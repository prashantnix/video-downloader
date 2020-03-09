package com.brokencodes.vd.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;

@RestController
@RequestMapping("/api/p/experiments")
public class ExperimentsApi {

    @Autowired
    public String a(String s) {
        return null;
    }

    @GetMapping("/hello")
    public String sayHi() {
        return "Hello World";
    }

    @GetMapping("/hello/{name}")
    public String sayHi(@PathVariable String name) {
        return MessageFormat.format("Hello {0}!", name);
    }

}

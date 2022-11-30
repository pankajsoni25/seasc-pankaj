package com.ups.seas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/seas/{empid}")
    public String pathTest(@PathVariable String empid){
        return "Hello : "+ empid;
    }

    
}

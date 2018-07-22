package com.jib;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping("/test")
    public boolean callback(@RequestParam("url") String url) {
        System.out.println(url);
        return true;
    }


}

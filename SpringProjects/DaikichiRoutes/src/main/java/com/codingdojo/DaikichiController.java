package com.codingdojo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DaikichiController {
    @RequestMapping("/daikichi")
    public String hello() {
            return "Welcome!";
    }
    
    @RequestMapping("/daikichi/today")
    public String today() {
            return "Today you will find lunck in all your endeavors!";
    }
    
    @RequestMapping("/daikichi/tommorow")
    public String tommorow() {
            return "Tommorow, an opportunity will arise, so be sure to be open to new ideas!";
    }
}

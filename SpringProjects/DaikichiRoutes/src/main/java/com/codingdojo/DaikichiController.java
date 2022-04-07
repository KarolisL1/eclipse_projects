package com.codingdojo;

import org.springframework.web.bind.annotation.PathVariable;
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
    
    @RequestMapping("/m/daikichi/travel/{city}")
    public String showLesson(@PathVariable("city") String city){
    	return "Congratulations! You will soon travel to " + city;
    }
    
    @RequestMapping("/m/daikichi/lotto/{number}")
    public String showLesson(@PathVariable("number") Integer number){
    	if(number % 2 == 0) {
    		return "You will take a grand journey in the near future, but be weary of tempting offers";
    	}
    	return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends";
    }
}

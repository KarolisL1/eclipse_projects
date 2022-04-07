package com.codingdojo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHumanController {
    @RequestMapping("/")
    public String index(@RequestParam(value="name", required = false) String searchQuery,
    		@RequestParam(value="last_name", required = false) String last) {
    	if(searchQuery == null) {
    		return "Hello human";
    	}
    	else {
    		return "Hello: " + searchQuery + " " + last;
    	}
    }
}

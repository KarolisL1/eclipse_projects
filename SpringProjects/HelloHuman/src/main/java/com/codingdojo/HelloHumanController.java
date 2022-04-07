package com.codingdojo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHumanController {
    @RequestMapping("/")
    public String index(@RequestParam(value="q", required = false) String searchQuery) {
    	if(searchQuery == null) {
    		return "Hello human";
    	}
    	else {
    		return "Hello: " + searchQuery;
    	}
    }
}
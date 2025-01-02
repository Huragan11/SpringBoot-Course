package huragan11.springbootcourse_section1.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }
}
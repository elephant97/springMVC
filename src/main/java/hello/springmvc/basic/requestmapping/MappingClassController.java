package hello.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {

    @GetMapping
    public String user(){
        return "get users";
    }

    @PostMapping
    public String addUser(){
        return "add users";
    }

    @GetMapping("/{userId}")
    public String findUsers(@PathVariable String userId){
        return "get userId="+userId;
    }

    @PatchMapping("/{userId}")
    public String updateUser(@PathVariable String userId){
        return "update userId="+userId;
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId){
        return "delete userId="+userId;
    }
}

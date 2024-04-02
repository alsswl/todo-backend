package backend.likelion.todos.todo;

import jdk.jfr.Registered;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/user")
    public String getUserInfo(User user){
        return "사용자 ID : " + user.getId() + ", 이름 : " + user.getName();
    }
}

package application.resources;


import application.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

    @GetMapping
    public ResponseEntity<User> findAllUsers() {
        User u = new User(1L, "Maria", "maria@gmail.com", "99999", "123456");
        return ResponseEntity.ok().body(u);
    }
}
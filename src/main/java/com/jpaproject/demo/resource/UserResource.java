package com.jpaproject.demo.resource;

import com.jpaproject.demo.model.User;
import com.jpaproject.demo.repositories.UserRepository;
import com.jpaproject.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController //controlador REST que responde no caminho /users
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() { //tipo especifico do spring que retorna respostas de requisicoes web
        List<User> list = userService.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id) {
        User obj = userService.findById(id);

        return ResponseEntity.ok().body(obj);
    }
    
}

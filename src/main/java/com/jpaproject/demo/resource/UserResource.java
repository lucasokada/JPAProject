package com.jpaproject.demo.resource;

import com.jpaproject.demo.model.entities.User;
import com.jpaproject.demo.services.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //controlador REST que responde no caminho /users
@RequestMapping(value = "/users", method = RequestMethod.POST)
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

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj) {
        obj = userService.insert(obj);

        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "{/id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        userService.delete(id);

        return ResponseEntity.noContent().build();//resposta sem corpo/conteudo
    }

    @PutMapping(value = "{/id}")
    public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody User obj) {
        obj = userService.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}

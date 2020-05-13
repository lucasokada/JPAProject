package com.jpaproject.demo.services;

import com.jpaproject.demo.model.entities.User;
import com.jpaproject.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> findAll() {
        List<User> userList = userRepository.findAll();

        return userList;
    }

    public User findById(Integer id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.get();
    }

    public User insert(User obj) { //insere banco de dados
        return userRepository.save(obj);
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    public User update(Integer id, User obj) {
        User entity = userRepository.getOne(id);//instancia o usuario sem operar o banco de dados
        updateData(entity, obj);
        return userRepository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}

package com.jpaproject.demo.services;

import com.jpaproject.demo.model.entities.User;
import com.jpaproject.demo.repositories.UserRepository;
import com.jpaproject.demo.services.exceptions.DatabaseException;
import com.jpaproject.demo.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id)); /*tenta dar o get. Se nao houver usuario,
                                                                        lança uma excessao*/
    }

    public User insert(User obj) { //insere banco de dados
        return userRepository.save(obj);
    }

    public void delete(Integer id) {
        try {
            userRepository.deleteById(id);
        }catch(EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }catch(DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Integer id, User obj) {

        try {
            User entity = userRepository.getOne(id);//instancia o usuario sem operar o banco de dados
            updateData(entity, obj);
            return userRepository.save(entity);
        }catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}

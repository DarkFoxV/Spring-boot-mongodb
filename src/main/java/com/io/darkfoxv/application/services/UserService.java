package com.io.darkfoxv.application.services;

import com.io.darkfoxv.application.domain.User;
import com.io.darkfoxv.application.dto.UserDTO;
import com.io.darkfoxv.application.repository.UserRepository;
import com.io.darkfoxv.application.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj) {
        return userRepository.insert(obj);
    }

    public User fromDYO (UserDTO obj){
        return new User(obj.getId(), obj.getName(), obj.getEmail());
    }
}

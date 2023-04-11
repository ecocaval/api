package com.example.api.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.api.dto.UserDto;
import com.example.api.model.User;
import com.example.api.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public User findById(UUID id) {
        return userRepository.findById(id)
                .orElse(null);

    }

    public void createUser(UserDto req) {
        userRepository.save(new User(req));
    }

    public void updateUser(UUID id, UserDto req) {
        userRepository.findById(id).map(user -> {

            user.setName(req.name());
            user.setLastName(req.lastName());
            user.setEmail(req.email());
            user.setBirthDate(req.birthDate());
            user.setPhone(req.phone());

            return userRepository.save(user);
        });
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

}

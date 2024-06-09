package com.example.Pathfinder.service;

import com.example.Pathfinder.model.User;
import com.example.Pathfinder.repo.UserRepository;
import com.example.Pathfinder.service.DTO.UserRegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    private UserRepository userRepo;

    public boolean isUnique(String username ,String password ,String confirmPassword) {

        User user = userRepo.findByUsername(username);

        if (user != null && confirmPassword.equals(password)) {
            return false;
        }else {
            return true;
        }
    }
}

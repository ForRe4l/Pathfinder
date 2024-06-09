package com.example.Pathfinder.service;

import com.example.Pathfinder.model.User;
import com.example.Pathfinder.repo.UserRepository;
import com.example.Pathfinder.service.DTO.UserLoginDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepo;


    public boolean checkCredentials(String username, String password) {
        User user = userRepo.findByUsername(username);

        return user != null && user.getPassword().equals(password);
    }

}

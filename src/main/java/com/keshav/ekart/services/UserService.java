package com.keshav.ekart.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keshav.ekart.model.User;
import com.keshav.ekart.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> getAllUser() {
        return repo.findAll();
    }
    
    public User addUser(User user) {
        return repo.save(user);
    }
    
    public Optional<User> getUserById(Long id) {
        return repo.findById(id); //.orElseThrow(null);
    }
    
    public User updateUserDetails(Long id, User newUser) {
        User user = repo.findById(id).orElse(null);
        user.setName(newUser.getName());
        user.setAddress(newUser.getAddress());
        user.setIsAdmin(newUser.getIsAdmin());
        user.setEmail(newUser.getEmail());
        user.setPassword(newUser.getPassword());
        repo.save(user);
        return user;
    }
    
    public void deleteUserbyId(Long id) {
       repo.deleteById(id);
    }
    
}

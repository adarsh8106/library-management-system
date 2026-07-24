package com.adarsh.libraryms.service;

import com.adarsh.libraryms.entity.User;
import com.adarsh.libraryms.exception.UserNotFoundException;
import com.adarsh.libraryms.repository.UserRepository;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private  UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User addUser(User user) { user.setPassword(passwordEncoder.encode(user.getPassword()));
         return repository.save(user);
    }

    public List<User> addUsers(List<User> users) {
        return repository.saveAll(users);
    }

    public List<User> getAllUsers() {
        return (List<User>) repository.findAll();
    }

    public User getUserById(Integer id) {
        return repository.findById(id).orElseThrow(()-> new UserNotFoundException(
                "User not found with id " + id));
    }

    public Optional<User> getUserByEmail(String email) {
        Optional<User> users= repository.findByEmail(email);
        if(users.isEmpty()){
            throw new UserNotFoundException("User not found with email " + email);
        }
        return users;
    }

    public User updateUser(Integer id, User user) {

        User existingUser = repository.findById(id).orElse(null);

        if (existingUser == null) {
            return null;
        }

        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPhone(user.getPhone());

        if(user.getPassword() != null && !user.getPassword().isBlank()){
            existingUser.setPassword(
                    passwordEncoder.encode(user.getPassword())
            );
        }

        existingUser.setRole(user.getRole());

        return repository.save(existingUser);
    }

    public String deleteUser(Integer id) {

        if (!repository.existsById(id)) {
            return "User not found";
        }

        repository.deleteById(id);

        return "User deleted successfully";
    }
}
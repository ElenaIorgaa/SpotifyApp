package com.spotify.project.services;

import com.spotify.project.models.User;
import com.spotify.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> getAllRoles() {
        List<User> users = repository.findAll();
        if (users.size() > 0)
            return users;
        else
            return new ArrayList<>();
    }

    public User createOrUpdate(User user)
    {
        List<User> users = getAllRoles();
        for(User u : users)
        {
            if(u.getUsername().equals(user.getUsername()))
            {
                user.setId(u.getId());
            }
        }
        user = repository.save(user);
        return user;
    }
    public Optional<User> getUserById(int id)
    {
        return repository.findById(id);
    }
    public void deleteUserById(int id)
    {
        repository.deleteById(id);
    }
}

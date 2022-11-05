package com.commercial.api.account.repository;

import com.commercial.api.account.model.User;
import com.commercial.api.account.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;

    public List<User> findAll(){
        return userCrudRepository.findAll();
    }

    public Optional<User> findById(Long id){
        return userCrudRepository.findById(id);
    }

    public Optional<User> findByUsername(String username){
        return userCrudRepository.findByUsername(username);
    }

    public User save(User user){
        return userCrudRepository.save(user);
    }

    public void  deleteById(Long id){
        userCrudRepository.deleteById(id);
    }

    public void deleteByUsername(String username){
        userCrudRepository.deleteByUsername(username);
    }
}

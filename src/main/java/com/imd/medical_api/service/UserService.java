package com.imd.medical_api.service;

import com.imd.medical_api.domain.user.UserCreateDTO;
import com.imd.medical_api.domain.user.UserUpdateDTO;
import com.imd.medical_api.model.User;
import com.imd.medical_api.model.User;
import com.imd.medical_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        return userRepository.findById(id).isPresent() ? userRepository.findById(id).get() : null;
    }

    public User create(UserCreateDTO userCreateDTO) {
        var user = new User(userCreateDTO);
        return userRepository.save(user);
    }

    public User update(UserUpdateDTO userUpdateDTO) {
        var user = userRepository.getReferenceById(userUpdateDTO.id());
        user.update(userUpdateDTO);
        return user;
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }
}

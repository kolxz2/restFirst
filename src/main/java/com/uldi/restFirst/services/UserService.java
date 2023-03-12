package com.uldi.restFirst.services;

import com.uldi.restFirst.entity.UserEntity;
import com.uldi.restFirst.exeprions.NotUserByIdException;
import com.uldi.restFirst.exeprions.UserAlreadyExistException;
import com.uldi.restFirst.models.UserModel;
import com.uldi.restFirst.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    public UserEntity reistration(UserEntity user) throws UserAlreadyExistException {
        if(userRepo.findByUsername(user.getUsername()) != null){
            throw new UserAlreadyExistException("User exist");
        }
        if(user.getUsername() == null || user.getPassword() == null){
            throw new UserAlreadyExistException("User exist");
        }
        return userRepo.save(user); // return -> UserEntity with Id
    }

    public UserModel getUserById(Long id) throws NotUserByIdException {
        try{
            UserEntity userEntity = userRepo.findById(id).get();
            return UserModel.entityToModel(userEntity);
        } catch (Exception e){
            throw new NotUserByIdException("User not found");
        }
    }
    public Long deleteUserById(Long id) throws NotUserByIdException {
        try{
            userRepo.deleteById(id);
            return id;
        } catch (Exception e){
            throw new NotUserByIdException("User not found");
        }
    }
}

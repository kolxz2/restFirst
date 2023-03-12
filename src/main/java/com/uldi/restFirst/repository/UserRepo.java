package com.uldi.restFirst.repository;

import com.uldi.restFirst.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long>  {
    UserEntity findByUsername(String username);
}

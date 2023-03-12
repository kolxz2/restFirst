package com.uldi.restFirst.repository;

import com.uldi.restFirst.entity.ToDoTaskEntity;
import org.springframework.data.repository.CrudRepository;

public interface TasksRepo extends CrudRepository<ToDoTaskEntity, Long>{
    public ToDoTaskEntity findByUserId(Long index);
}

package com.uldi.restFirst.services;

import com.uldi.restFirst.entity.ToDoTaskEntity;
import com.uldi.restFirst.exeprions.NotUserByIdException;
import com.uldi.restFirst.repository.TasksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ToDoTaskService {

    @Autowired
    private TasksRepo taskRepo;

    public ToDoTaskEntity getAllTasks(Long userIndex) throws NotUserByIdException {
        try{
            return taskRepo.findByUserId(userIndex);
        } catch (Exception e){
            throw new NotUserByIdException("Can't find user id");
        }
    }

    public ToDoTaskEntity addTasks(ToDoTaskEntity toDoTaskEntity) throws NotUserByIdException {
        try{
            return taskRepo.save(toDoTaskEntity);
        } catch (Exception e){
            throw new NotUserByIdException("Can't find user id");
        }
    }
}

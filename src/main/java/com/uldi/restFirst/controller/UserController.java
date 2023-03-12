package com.uldi.restFirst.controller;

import com.uldi.restFirst.entity.ToDoTaskEntity;
import com.uldi.restFirst.entity.UserEntity;
import com.uldi.restFirst.exeprions.NotUserByIdException;
import com.uldi.restFirst.exeprions.UserAlreadyExistException;
import com.uldi.restFirst.repository.UserRepo;
import com.uldi.restFirst.services.ToDoTaskService;
import com.uldi.restFirst.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController{

    @Autowired
    private UserService userService;

    @Autowired
    private ToDoTaskService toDoTaskService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user){
            try{
                userService.reistration(user);
                return  ResponseEntity.ok("User added");
            }catch (UserAlreadyExistException e){
                return ResponseEntity.badRequest().body(e.getMessage());
            }
            catch (Exception e){
                return ResponseEntity.badRequest().body("Server failed");
            }
    }

    @GetMapping
    public ResponseEntity getUsers(@RequestParam Long id){
        try{
            return  ResponseEntity.ok(userService.getUserById(id));
        }catch (NotUserByIdException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Server failed");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try{
            return  ResponseEntity.ok(userService.deleteUserById(id));
        }catch (NotUserByIdException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Server failed");
        }
    }

    @PostMapping("/task")
    public ResponseEntity addToDoTask(@RequestBody ToDoTaskEntity task){
        try{
            return ResponseEntity.ok(toDoTaskService.addTasks(task));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Server failed");
        }
    }


/*    @GetMapping("/{id}/tasks")
    public ResponseEntity getUsersTasks(@RequestParam Long id){
        try{
            return  ResponseEntity.ok(toDoTaskService.getAllTasks(id));
        }catch (NotUserByIdException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Server failed");
        }
    }*/
}
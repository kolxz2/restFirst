package com.uldi.restFirst.models;

import com.uldi.restFirst.entity.UserEntity;

public class UserModel {

    private String name;
    private Long id;

    public static UserModel entityToModel(UserEntity entity){
        UserModel model = new UserModel();
        model.setName(entity.getUsername());
        model.setId(entity.getId());
        return model;
    }

    public UserModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

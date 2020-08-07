package com.example.forumdisigin.data.model;

import com.example.forumdisigin.data.model.dto.UserDto;
import com.example.forumdisigin.data.model.httpmanager.HttpManager;
import com.example.forumdisigin.data.model.httpmanager.UserManager;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.junit.Test;

public class HttpManagerTest {

    @Test
    public void tryMethod() throws JsonProcessingException, ClassNotFoundException {

        UserManager manager = new UserManager();

 //       UserDto userDto = manager.getAll().stream().findFirst().orElse(new UserDto());
        UserDto userDto = manager.getById(4L);
        System.out.println("username " + userDto.getLogin() + " email " + userDto.getEmail());


    }
}
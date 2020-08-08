package com.example.forumdisigin.data.model;

import android.app.Application;
import android.content.res.Resources;
import android.provider.Settings;

import com.example.forumdisigin.R;
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


        UserDto userDto = manager.getById(7L);
        System.out.println("username: " + userDto.getLogin() + "; email: " + userDto.getEmail() + "; id: " + userDto.getId());

        userDto.setEmail("mailmymail@gmail.com");
        userDto.setLogin("vasya322");
        userDto.setPassword("notvasyaincase");
        System.out.println(manager.add(userDto));

    }
}
package com.example.forumdisigin.data.model.httpmanager;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.forumdisigin.data.model.dto.AbstractDto;
import com.example.forumdisigin.data.model.dto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class HttpManager<T extends AbstractDto> {


    public List<T> getAll() throws ClassNotFoundException, JsonProcessingException {

        Type genericSuperclass = getClass().getGenericSuperclass();
        Type type = ((ParameterizedType)genericSuperclass).getActualTypeArguments()[ 0 ];

        String url = "http://localhost:8080/" + nameFromType(type) + "/all";

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        String result = restTemplate.getForObject(url, String.class);

        T[] dtos =  new ObjectMapper().readValue(result, arrayClassByType(type));
        return Arrays.asList(dtos);

    }

    public T getById(Long id) throws ClassNotFoundException, JsonProcessingException {

        Type genericSuperclass = getClass().getGenericSuperclass();
        Type type = ((ParameterizedType)genericSuperclass).getActualTypeArguments()[ 0 ];

        String url = "http://localhost:8080/" + nameFromType(type) + "/" + id.toString();

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        String result = restTemplate.getForObject(url, String.class);

        T dto =  new ObjectMapper().readValue(result, classByType(type));
        return dto;

    }

    private String nameFromType(Type type) {

        String raw = type.toString();
        int lastPoint = raw.lastIndexOf('.');
        int startDto = raw.indexOf("Dto");
        return raw.substring(lastPoint + 1, startDto).toLowerCase().concat("s");

    }

    private Class<T> classByType(Type type) throws ClassNotFoundException {
        String className =  type.toString().replace("class ", "");
        return  (Class<T>) Class.forName(className);
    }

    private Class<T[]> arrayClassByType(Type type) throws ClassNotFoundException {

        String className =  type.toString().replace("class ", "[L") + ";";
        return  (Class<T[]>) Class.forName(className);

    }

}

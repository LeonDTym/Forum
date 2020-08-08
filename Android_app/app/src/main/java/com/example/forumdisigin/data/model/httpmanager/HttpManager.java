package com.example.forumdisigin.data.model.httpmanager;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.forumdisigin.data.model.dto.AbstractDto;
import com.example.forumdisigin.data.model.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

public abstract class HttpManager<T extends AbstractDto> {

    public static String serverUrl = "http://localhost:8080/";

    public List<T> getAll() throws ClassNotFoundException, JsonProcessingException {

        Type genericSuperclass = getClass().getGenericSuperclass();
        Type type = ((ParameterizedType)genericSuperclass).getActualTypeArguments()[ 0 ];

        String url = serverUrl + nameFromType(type) + "/all";

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        String result = restTemplate.getForObject(url, String.class);

        T[] dtos =  new ObjectMapper().readValue(result, arrayClassByType(type));
        return Arrays.asList(dtos);

    }

    public T getById(Long id) throws ClassNotFoundException, JsonProcessingException {

        Type genericSuperclass = getClass().getGenericSuperclass();
        Type type = ((ParameterizedType)genericSuperclass).getActualTypeArguments()[ 0 ];

        String url = serverUrl + nameFromType(type) + "/" + id.toString();

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        String result = restTemplate.getForObject(url, String.class);

        T dto =  new ObjectMapper().readValue(result, classByType(type));
        return dto;

    }

    public int add(T item) {

        item.setId(null);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
        HttpEntity<T> entity = new HttpEntity<>(item);

        String url = serverUrl + nameFromType(item.getClass()) + "/add";
        ResponseEntity<? extends AbstractDto> response = restTemplate.exchange(url, HttpMethod.POST, entity, item.getClass());

        return response.getStatusCode().value();

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

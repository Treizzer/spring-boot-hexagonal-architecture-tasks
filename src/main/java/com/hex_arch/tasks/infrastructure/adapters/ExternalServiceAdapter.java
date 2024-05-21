package com.hex_arch.tasks.infrastructure.adapters;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.hex_arch.tasks.domain.models.AdditionalTaskInfo;
import com.hex_arch.tasks.domain.ports.out.ExternalServicePort;

import lombok.Getter;
import lombok.Setter;

public class ExternalServiceAdapter implements ExternalServicePort {

    // "https://jsonplaceholder.typicode.com/todos"
    // "https://jsonplaceholder.typicode.com/users"

    private final RestTemplate restTemplate;

    public ExternalServiceAdapter() {
        restTemplate = new RestTemplate();
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        String apiUrl = "https://jsonplaceholder.typicode.com/todos/" + id;
        // Http
        ResponseEntity<JsonPlaceHolderTodo> response = restTemplate.getForEntity(apiUrl,
                JsonPlaceHolderTodo.class);
        JsonPlaceHolderTodo todo = response.getBody();

        if (todo == null) {
            return null;
        }

        apiUrl = "https://jsonplaceholder.typicode.com/users/" + todo.getUserId();
        // Http
        ResponseEntity<JsonPlaceHolderUser> userResponse = restTemplate.getForEntity(apiUrl,
                JsonPlaceHolderUser.class);
        JsonPlaceHolderUser user = userResponse.getBody();

        if (user == null) {
            return null;
        }

        return new AdditionalTaskInfo(user.getId(), user.getName(), user.getEmail());
    }

    @Getter
    @Setter
    private static class JsonPlaceHolderTodo {
        private Long id;
        private Long userId;
    }

    @Getter
    @Setter
    private static class JsonPlaceHolderUser {
        private Long id;
        private String name;
        private String email;
    }

}

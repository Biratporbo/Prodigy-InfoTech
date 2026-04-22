package com.example.user_api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/users")
public class UserController {
    
    //In-memory data structure
    private final Map<UUID, User> userDatabase = new ConcurrentHashMap<>();
    
    //CREATE: POST /api/users
    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        //Basic check for duplicate emails
        boolean emailExists = userDatabase.values().stream().anyMatch(u -> u.getEmail().equalsIgnoreCase(user.getEmail()));
        if (emailExists) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already exists");
        }

        user.setId(UUID.randomUUID()); // Assign a new UUID
        userDatabase.put(user.getId(), user);
        return new ResponseEntity<>(user, HttpStatus.CREATED); // 201 Created
    }

    //READ ALL: GET /api/user
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(new ArrayList<>(userDatabase.values())); // 200 OK
    }

    // READ ONE: GET /api/user
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable UUID id) {
        User user = userDatabase.get(id);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"); // 404 Not Found
        }
        return ResponseEntity.ok(user); // 200 OK
    }

    // UPDATE: PUT /api/users/{id}
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable UUID id, @Valid @RequestBody User updatedUser) {
        if (!userDatabase.containsKey(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"); // 404 Not Found
        }
        
        updatedUser.setId(id); // Ensure the ID stays the same
        userDatabase.put(id, updatedUser);
        return ResponseEntity.ok(updatedUser); // 200 OK
    }

    // DELETE: DELETE /api/users/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        if (userDatabase.remove(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"); // 404 Not Found
        }
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}

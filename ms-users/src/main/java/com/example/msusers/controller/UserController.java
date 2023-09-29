package com.example.msusers.controller;

import com.example.msusers.model.dto.SaveUserRequest;
import com.example.msusers.model.dto.UpdateUserRequest;
import com.example.msusers.model.dto.UserResponse;
import com.example.msusers.model.reponse.CardResponse;
import com.example.msusers.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<UserResponse> getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/{user-id}")
    public Mono<CardResponse> getCardsByUserId(@PathVariable("user-id") Long userId){
        return userService.getAllCardsByUserId(userId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<UserResponse> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Void> saveUser(@RequestBody SaveUserRequest request){
        return userService.saveUser(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> updateUser(@PathVariable Long id, @RequestBody UpdateUserRequest request){
        return userService.updateUser(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }
}

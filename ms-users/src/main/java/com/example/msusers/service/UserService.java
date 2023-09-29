package com.example.msusers.service;

import com.example.msusers.client.CardWebClient;
import com.example.msusers.dao.repository.UserRepository;
import com.example.msusers.exception.NotFoundException;
import com.example.msusers.mapper.UserMapper;
import com.example.msusers.model.dto.SaveUserRequest;
import com.example.msusers.model.dto.UpdateUserRequest;
import com.example.msusers.model.dto.UserResponse;
import com.example.msusers.model.enums.Status;
import com.example.msusers.model.reponse.CardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CardWebClient cardWebClient;

    public Mono<UserResponse> getUserById(Long id){
        return userRepository.findById(id)
                .map(UserMapper::buildToResponse)
                .switchIfEmpty(Mono.error(new NotFoundException("User not found with id : " + id)));
    }

    public Flux<UserResponse> getAllUsers(){
        return userRepository.findAll().map(UserMapper::buildToResponse);
    }

    public Mono<CardResponse> getAllCardsByUserId(Long userId){
        return userRepository.findById(userId)
                .switchIfEmpty(Mono.error(new NotFoundException("User not found with id : " + userId)))
                .flatMap(cards -> {
                return cardWebClient.getAllCardsByUserId(userId);
                });
    }

    public Mono<Void> saveUser(SaveUserRequest request){
        return userRepository.save(UserMapper.buildToEntity(request)).then();
    }

    public Mono<Void> updateUser(Long id, UpdateUserRequest request){
        return userRepository.findById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("User not found with id : " + id)))
                .flatMap(user -> {
                    UserMapper.updateToEntity(user, request);
                    return userRepository.save(user).then();
                });
    }

    public Mono<Void> deleteUser(Long id){
        return userRepository.findById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("User not found with id : ")))
                .flatMap(user -> {
                    user.setStatus(Status.DELETED);
                    return userRepository.save(user).then();
                });
    }
}

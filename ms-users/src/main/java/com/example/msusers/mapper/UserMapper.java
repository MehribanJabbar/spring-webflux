package com.example.msusers.mapper;

import com.example.msusers.dao.entity.User;
import com.example.msusers.model.dto.SaveUserRequest;
import com.example.msusers.model.dto.UpdateUserRequest;
import com.example.msusers.model.dto.UserResponse;
import com.example.msusers.model.enums.Status;
import reactor.netty.udp.UdpServerConfig;

import java.time.LocalDateTime;

public class UserMapper {
    public static UserResponse buildToResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .birthDate(user.getBirthDate())
                .birthPlace(user.getBirthPlace())
                .build();
    }

    public static User buildToEntity(SaveUserRequest request){
        return User.builder()
                .name(request.name())
                .surname(request.surname())
                .birthDate(request.birthDate())
                .birthPlace(request.birthPlace())
                .createdAt(LocalDateTime.now())
                .status(Status.ACTIVE)
                .build();
    }

    public static void updateToEntity(User user, UpdateUserRequest request){
        user.setName(request.name());
        user.setSurname(request.surname());
        user.setBirthDate(request.birthDate());
        user.setBirthPlace(request.birthPlace());
        user.setUpdatedAt(LocalDateTime.now());
    }
}

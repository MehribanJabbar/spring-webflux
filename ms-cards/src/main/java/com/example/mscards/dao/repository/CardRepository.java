package com.example.mscards.dao.repository;

import com.example.mscards.dao.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CardRepository extends JpaRepository<CardEntity, Long> {
    List<CardEntity> findByUserId(Long userId);
}

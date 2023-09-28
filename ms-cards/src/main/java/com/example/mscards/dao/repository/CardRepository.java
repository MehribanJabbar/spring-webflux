package com.example.mscards.dao.repository;

import com.example.mscards.dao.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<CardEntity, Long> {
}

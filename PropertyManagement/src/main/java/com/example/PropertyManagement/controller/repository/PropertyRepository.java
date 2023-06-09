package com.example.PropertyManagement.controller.repository;

import com.example.PropertyManagement.binding.PropertyEntity;
import com.example.PropertyManagement.model.PropertyDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<PropertyEntity, Integer> {
}

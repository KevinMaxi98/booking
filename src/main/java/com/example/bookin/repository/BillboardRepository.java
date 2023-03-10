package com.example.bookin.repository;

import com.example.bookin.entity.BillboardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillboardRepository extends JpaRepository<BillboardEntity, Integer> {
}

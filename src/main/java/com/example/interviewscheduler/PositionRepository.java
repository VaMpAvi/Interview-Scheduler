package com.example.interviewscheduler;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PositionRepository extends JpaRepository<Position, Integer> {

    @Query(value = "SELECT position_name FROM positions", nativeQuery = true)
    List<String> findAllPositons();
}

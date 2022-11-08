package com.example.history.service.repository;

import com.example.history.service.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryCrudRepository extends JpaRepository<History,Long> {
    List<History> findByUsername(String username);
}

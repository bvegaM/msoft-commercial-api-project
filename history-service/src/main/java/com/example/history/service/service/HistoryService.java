package com.example.history.service.service;

import com.example.history.service.dto.HistoryDto;

import java.util.List;

public interface HistoryService {

    List<HistoryDto> findAll();
    List<HistoryDto> findByUsername(String username);
    HistoryDto findById(Long id);
    HistoryDto save(HistoryDto historyDto);
}

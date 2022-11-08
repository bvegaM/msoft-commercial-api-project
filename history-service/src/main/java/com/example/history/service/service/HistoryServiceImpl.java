package com.example.history.service.service;

import com.example.history.service.dto.HistoryDto;
import com.example.history.service.entity.History;
import com.example.history.service.repository.HistoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoryServiceImpl implements HistoryService{

    @Autowired
    private HistoryCrudRepository historyCrudRepository;

    @Override
    public List<HistoryDto> findAll() {
        List<History> histories = historyCrudRepository.findAll();
        return histories.stream().map(History::convertDto).collect(Collectors.toList());
    }

    @Override
    public List<HistoryDto> findByUsername(String username) {
        List<History> histories = historyCrudRepository.findByUsername(username);
        return histories.stream().map(History::convertDto).collect(Collectors.toList());
    }

    @Override
    public HistoryDto findById(Long id) {
        return historyCrudRepository.findById(id).map(History::convertDto).orElse(null);
    }

    @Override
    public HistoryDto save(HistoryDto historyDto) {
        return History.convertDto(historyCrudRepository.save(
                History.builder().request(historyDto.getRequest())
                        .method(historyDto.getMethod())
                        .dateRequest(historyDto.getDateRequest())
                        .username(historyDto.getUsername()).build()
        ));
    }
}

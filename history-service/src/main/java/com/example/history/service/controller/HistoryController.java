package com.example.history.service.controller;

import com.example.history.service.dto.HistoryDto;
import com.example.history.service.service.HistoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private HistoryServiceImpl historyService;

    @GetMapping
    public ResponseEntity<List<HistoryDto>> findAll(){
        try{
            List<HistoryDto> historyDtos = historyService.findAll();
            if(historyDtos.isEmpty())
                throw new Exception();
            return ResponseEntity.ok(historyDtos);
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<List<HistoryDto>> findByUsername(@PathVariable("username") String username){
        try{
            List<HistoryDto> historyDtos = historyService.findByUsername(username);
            if(historyDtos.isEmpty())
                throw new Exception();
            return ResponseEntity.ok(historyDtos);
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoryDto> findById(@PathVariable("id") Long id){
        try{
            HistoryDto historyDto = historyService.findById(id);
            if(historyDto == null)
                throw new Exception();
            return ResponseEntity.ok(historyDto);
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity<HistoryDto> save(@RequestBody HistoryDto historyDto){
        try{
            HistoryDto history = historyService.save(historyDto);
            return new ResponseEntity<>(history, HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}

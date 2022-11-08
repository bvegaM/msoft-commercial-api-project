package com.example.history.service.entity;

import com.example.history.service.dto.HistoryDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Data
@Entity
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String request;
    private String method;
    private Date dateRequest;
    private String username;


    public static HistoryDto convertDto(History history){
        return HistoryDto.builder().request(history.getRequest())
                .method(history.getMethod())
                .dateRequest(history.getDateRequest())
                .username(history.getUsername()).build();
    }
}

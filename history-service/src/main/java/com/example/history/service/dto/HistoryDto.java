package com.example.history.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Data
public class HistoryDto {

    private String request;
    private String method;
    @JsonFormat(pattern = "yyy-MM-dd")
    private Date dateRequest;
    private String username;
}

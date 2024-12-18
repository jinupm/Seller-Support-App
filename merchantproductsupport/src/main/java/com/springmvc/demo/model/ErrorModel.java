package com.springmvc.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
    public class ErrorModel {
        private int errorCode;
        private String errorMessage;
        private String details;
    }
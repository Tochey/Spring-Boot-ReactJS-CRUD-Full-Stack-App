package com.crud.employeeservice.builder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResponseBuilder {
    private String error;
    private String message;
    private String path;
    private String timestamp;

    public ResponseEntity<Object> responseBuilder(String message, HttpStatus status, Object responseObj) {

        Map<String, Object> map = new HashMap<String, Object>();
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        map.put("message", message);
        map.put("status", status.value());
        map.put("data", responseObj);
        map.put("timestamp", formattedDate);
        return new ResponseEntity<Object>(map, status);

    }
}

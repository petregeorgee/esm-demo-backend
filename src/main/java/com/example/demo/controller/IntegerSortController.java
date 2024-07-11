package com.example.demo.controller;

import com.example.demo.service.IntegerSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/list")
public class IntegerSortController {

    private final IntegerSortService sortService;

    @Autowired
    public IntegerSortController(IntegerSortService sortService) {
        this.sortService = sortService;
    }

    @PostMapping("/sort")
    public ResponseEntity<List<Integer>> sortList(@RequestBody List<Integer> numbers) {
        try {
            sortService.quickSort(numbers, 0, numbers.size() - 1);
            return ResponseEntity.ok(numbers);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}

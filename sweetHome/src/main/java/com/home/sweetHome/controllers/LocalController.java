package com.home.sweetHome.controllers;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.home.sweetHome.dtos.LocalDto;
import com.home.sweetHome.models.Local;
import com.home.sweetHome.repositories.LocalRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocalController {
    @Autowired
    LocalRepository localRepository;

    @PostMapping("/locais")
    public ResponseEntity<Object> saveLocal(@RequestBody @Valid LocalDto localDto) {
        var local = new Local();
        BeanUtils.copyProperties(localDto, local);
        return ResponseEntity.status(HttpStatus.CREATED).body(localRepository.save(local));
    }

    @GetMapping("/locais")
    public ResponseEntity<List<Local>> getAllLocais() {
        return ResponseEntity.status(HttpStatus.OK).body(localRepository.findAll());
    }

    

}

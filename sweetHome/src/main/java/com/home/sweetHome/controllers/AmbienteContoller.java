package com.home.sweetHome.controllers;

import com.home.sweetHome.dtos.AmbienteDto;
import com.home.sweetHome.models.Ambiente;
import com.home.sweetHome.repositories.AmbienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class AmbienteContoller {
    @Autowired
    AmbienteRepository ambienteRepository;

    @PostMapping("/ambientes")
    public ResponseEntity<Object> saveAmbiente(@RequestBody @Valid AmbienteDto ambienteDto) {
        var ambiente = new Ambiente();
        BeanUtils.copyProperties(ambienteDto, ambiente);
        return ResponseEntity.status(HttpStatus.CREATED).body(ambienteRepository.save(ambiente));
    }

    @GetMapping("/ambientes")
    public ResponseEntity<List<Ambiente>> getAllAmbientes() {
        return ResponseEntity.status(HttpStatus.OK).body(ambienteRepository.findAll());
    }

}

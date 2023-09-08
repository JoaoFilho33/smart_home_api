package com.home.sweetHome.controllers;

import com.home.sweetHome.dtos.DispositivoDto;
import com.home.sweetHome.models.Dispositivo;
import com.home.sweetHome.repositories.DispositivoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DispositivoController {
    @Autowired
    DispositivoRepository dispositivoRepository;

    @PostMapping("/dispositivos")
    public ResponseEntity<Object> saveDisposito(@RequestBody @Valid DispositivoDto dispositivoDto) {
        var dispositivo = new Dispositivo();
        BeanUtils.copyProperties(dispositivoDto, dispositivo);
        return ResponseEntity.status(HttpStatus.CREATED).body(dispositivoRepository.save(dispositivo));
    }

    @GetMapping("/dispotivos")
    public ResponseEntity<List<Dispositivo>> getAllDispositivos() {
        return ResponseEntity.status(HttpStatus.OK).body(dispositivoRepository.findAll());
    }
}

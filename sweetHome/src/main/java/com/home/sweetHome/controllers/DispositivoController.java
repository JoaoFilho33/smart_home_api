package com.home.sweetHome.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.home.sweetHome.dtos.AmbienteDto;
import com.home.sweetHome.dtos.DispositivoDto;
import com.home.sweetHome.models.Ambiente;
import com.home.sweetHome.models.Dispositivo;
import com.home.sweetHome.models.Local;
import com.home.sweetHome.repositories.AmbienteRepository;
import com.home.sweetHome.repositories.DispositivoRepository;
import com.home.sweetHome.repositories.LocalRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class DispositivoController {

    private static final Logger logger = LoggerFactory.getLogger(DispositivoController.class);

    @Autowired
    DispositivoRepository dispositivoRepository;

    @Autowired
    AmbienteRepository ambienteRepository;

    @PostMapping("/dispositivos")
    public ResponseEntity<Object> saveDispositivo(@RequestBody DispositivoDto dispositivoDto) {
        UUID ambientelId = dispositivoDto.ambienteId();
        Optional<Ambiente> ambienteOptional = ambienteRepository.findById(ambientelId);

        if(ambienteOptional.isEmpty()){
            logger.error("Local não encontrado para o ID: {}", ambientelId);
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Local não encontrado");
            return ResponseEntity.badRequest().body(errorResponse);
        }

        Ambiente ambiente = ambienteOptional.get();

        Dispositivo dispositivo = new Dispositivo();
        dispositivo.setDescricao(dispositivoDto.descricao());
        dispositivo.setOnline(dispositivoDto.online());
        dispositivo.setLigado(dispositivoDto.ligado());
        dispositivo.setCor(dispositivoDto.cor());
        dispositivo.setAmbiente(ambiente);

        try {
            Dispositivo novoDispositivo = dispositivoRepository.save(dispositivo);
            logger.info("Ambiente criado com sucesso: {}", novoDispositivo.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(novoDispositivo);
        } catch (DataIntegrityViolationException ex) {
            logger.error("Erro de integridade de dados ao criar ambiente: {}", ex.getMessage());
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Erro de integridade de dados");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @GetMapping("/dispositivos")
    public ResponseEntity<List<Dispositivo>> getAllDispositivos() {
        List<Dispositivo> dispositivos = dispositivoRepository.findAll();
        logger.info("Recuperados {} dispositivos.", dispositivos.size());
        return ResponseEntity.status(HttpStatus.OK).body(dispositivos);
    }
}

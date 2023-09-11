package com.home.sweetHome.controllers;

import com.home.sweetHome.dtos.LocalDto;
import com.home.sweetHome.models.Local;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.home.sweetHome.dtos.AmbienteDto;
import com.home.sweetHome.models.Ambiente;
import com.home.sweetHome.repositories.AmbienteRepository;
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
public class AmbienteContoller {
    private static final Logger logger = LoggerFactory.getLogger(AmbienteContoller.class);

    @Autowired
    private AmbienteRepository ambienteRepository;

    @Autowired
    private LocalRepository localRepository;

    @PostMapping("/ambientes")
    public ResponseEntity<Object> saveAmbiente(@RequestBody AmbienteDto ambienteDto) {
        UUID localId = ambienteDto.localId();
        Optional<Local> localOptional = localRepository.findById(localId);

        if (localOptional.isEmpty()) {
            logger.error("Local não encontrado para o ID: {}", localId);
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Local não encontrado");
            return ResponseEntity.badRequest().body(errorResponse);
        }

        Local local = localOptional.get();
        Ambiente ambiente = new Ambiente();
        ambiente.setDescricao(ambienteDto.descricao());
        ambiente.setLocal(local);

        try {
            Ambiente novoAmbiente = ambienteRepository.save(ambiente);
            logger.info("Ambiente criado com sucesso: {}", novoAmbiente.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(novoAmbiente);
        } catch (DataIntegrityViolationException ex) {
            logger.error("Erro de integridade de dados ao criar ambiente: {}", ex.getMessage());
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Erro de integridade de dados");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }


    @GetMapping("/ambientes")
    public ResponseEntity<List<Ambiente>> getAllAmbientes() {
        List<Ambiente> ambientes = ambienteRepository.findAll();
        logger.info("Recuperados {} ambientes.", ambientes.size());
        return ResponseEntity.status(HttpStatus.OK).body(ambientes);
    }
}

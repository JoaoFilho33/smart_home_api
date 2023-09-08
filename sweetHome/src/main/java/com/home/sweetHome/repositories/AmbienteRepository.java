package com.home.sweetHome.repositories;

import com.home.sweetHome.models.Ambiente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AmbienteRepository extends JpaRepository<Ambiente, UUID> {
}

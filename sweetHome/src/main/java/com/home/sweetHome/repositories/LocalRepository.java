package com.home.sweetHome.repositories;

import com.home.sweetHome.models.Local;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LocalRepository extends JpaRepository<Local, UUID> {
}

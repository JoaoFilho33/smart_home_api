package com.home.sweetHome.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Local {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String descricao;

    @OneToMany(mappedBy = "local", cascade = CascadeType.ALL) //orphanRemoval = true
    private List<Ambiente> ambientes = new ArrayList<>();//cada local pode ter varios ambientes
}
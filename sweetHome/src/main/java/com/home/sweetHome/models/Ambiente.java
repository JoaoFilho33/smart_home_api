package com.home.sweetHome.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ambiente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @ManyToOne
    private Local local;

    @OneToMany(mappedBy = "ambiente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Dispositivo> dispositivos = new ArrayList<>();
}

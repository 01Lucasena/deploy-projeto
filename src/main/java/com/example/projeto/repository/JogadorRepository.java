package com.example.projeto.repository;

import org.springframework.stereotype.Repository;

import com.example.projeto.model.Jogador;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {
    
    boolean existsByNumeroCamisa(int numeroCamisa);
    
}

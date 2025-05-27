package com.example.projeto.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

import com.example.projeto.exception.NumeroCamisaJaExistenteException;
import com.example.projeto.model.Jogador;
import com.example.projeto.repository.JogadorRepository;

@Service
@Validated
public class JogadorService {

    private JogadorRepository jogadorRepository;

    public JogadorService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    public List<Jogador> listarTodos() {
        return jogadorRepository.findAll();
    }

    public Jogador salvar(@Valid Jogador jogador) {
        if (jogadorRepository.existsByNumeroCamisa(jogador.getNumeroCamisa())) {
            throw new NumeroCamisaJaExistenteException("Já existe um jogador com esse número de camisa.");
    }
    return jogadorRepository.save(jogador);
}

    public Jogador atualizar(@Valid Jogador jogador) {

        if (jogador.getId() == null) {
            throw new IllegalArgumentException("O ID do jogador não pode ser nulo!");
}
        Jogador jogadorAtualizar = jogadorRepository.findById(jogador.getId())
                .orElseThrow(() -> new IllegalArgumentException("Jogador não encontrado"));

        jogadorAtualizar.setNome(jogador.getNome());
        jogadorAtualizar.setSexo(jogador.getSexo());
        jogadorAtualizar.setIdade(jogador.getIdade());
        jogadorAtualizar.setAltura(jogador.getAltura());
        jogadorAtualizar.setPeso(jogador.getPeso());
        jogadorAtualizar.setPosicao(jogador.getPosicao());
        jogadorAtualizar.setNumeroCamisa(jogador.getNumeroCamisa());
        return jogadorRepository.save(jogadorAtualizar);
    }

    public void excluir(Long id) {
        Jogador jogador = jogadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogador não encontrado"));
        jogadorRepository.delete(jogador);
    }
}

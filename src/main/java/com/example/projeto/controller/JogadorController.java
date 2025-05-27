package com.example.projeto.controller;

import com.example.projeto.model.Jogador;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import com.example.projeto.service.JogadorService;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    private JogadorService jogadorService;

    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @GetMapping
    public List<Jogador> listarTodos() {
        return jogadorService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Map<String,Object>> salvar(@RequestBody @Valid Jogador jogador) {
        jogadorService.salvar(jogador);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Jogador cadastrado com sucesso"));
    }


    @PutMapping
    public ResponseEntity<Map<String, Object>> atualizar(@Valid @RequestBody Jogador jogador) {
        jogadorService.atualizar(jogador);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Jogador atualizado com sucesso"));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> excluir(@PathVariable Long id) {
        jogadorService.excluir(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Jogador excluído com sucesso"));
    }
}

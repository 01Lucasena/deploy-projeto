package com.example.projeto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
public class Jogador {

    public enum Sexo {
        MASCULINO,
        FEMININO

    }

    public enum Posicao {
        GOLEIRO,
        LATERAL,
        ZAGUEIRO,
        MEIA,
        ATACANTE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome não pode ser vazio")
    private String nome;

    private Sexo sexo;

    @Min(value = 1, message = "Idade deve ser maior que 0")
    @Max(value = 100, message = "Idade deve ser menor que 100")
    private Integer idade;

    @DecimalMin(value = "1.5", message = "Altura deve ser maior que 1,5")
    @DecimalMax(value = "2.5", message = "Altura deve ser menor que 2,5")
    private double altura;
    
    @DecimalMin(value = "30", message = "Peso deve ser maior que 30")
    @DecimalMax(value = "200", message = "Peso deve ser menor que 200")
    private double peso;

    private Posicao posicao;

    @Min(value = 1, message = "Número da camisa deve ser maior que 0")
    @Max(value = 99, message = "Número da camisa deve ser menor que 100")
    private int numeroCamisa;

    public Jogador() {
    }

    public Jogador(Long id, @NotBlank(message = "Nome não pode ser vazio") String nome, Sexo sexo,
            @Min(value = 1, message = "Idade deve ser maior que 0") @Max(value = 100, message = "Idade deve ser menor que 100") Integer idade,
            @DecimalMin(value = "1.5", message = "Altura deve ser maior que 1,5") @DecimalMax(value = "2.5", message = "Altura deve ser menor que 2,5") double altura,
            @DecimalMin(value = "30", message = "Peso deve ser maior que 30") @DecimalMax(value = "200", message = "Peso deve ser menor que 200") double peso,
            Posicao posicao,
            @Min(value = 1, message = "Número da camisa deve ser maior que 0") @Max(value = 99, message = "Número da camisa deve ser menor que 100") int numeroCamisa) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.posicao = posicao;
        this.numeroCamisa = numeroCamisa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

    public int getNumeroCamisa() {
        return numeroCamisa;
    }

    public void setNumeroCamisa(int numeroCamisa) {
        this.numeroCamisa = numeroCamisa;
    }
}

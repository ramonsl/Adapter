package com.example.adpater;

public class Carros {
    private String nome;
    private double motor;
    private String marca;

    public Carros(String nome, double motor, String marca) {
        this.nome = nome;
        this.motor = motor;
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public String getMotor() {
        return Double.toString(motor);
    }

    public String getMarca() {
        return marca;
    }


    @Override
    public String toString() {
        return "Carros{" +
                "nome='" + nome + '\'' +
                ", motor=" + motor +
                ", marca='" + marca + '\'' +
                '}';
    }
}

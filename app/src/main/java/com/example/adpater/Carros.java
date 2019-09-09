package com.example.adpater;

public class Carros {
    private int _id;
    private String nome;
    private int ano  ;
    private String marca;

    public Carros(String nome, int ano, String marca) {
        this.nome = nome;
        this.ano = ano;
        this.marca = marca;
    }

    public Carros(int id,String nome, int ano, String marca) {
        this.nome = nome;
        this.ano = ano;
        this.marca = marca;
        this._id=id;
        ;
    }
    public String getNome() {
        return nome;
    }

    public String getAno() {
        return Integer.toString(ano);
    }

    public String getMarca() {
        return marca;
    }


    @Override
    public String toString() {
        return "Carros{" +
                "nome='" + nome + '\'' +
                ", ANO=" + ano +
                ", marca='" + marca + '\'' +
                '}';
    }
}

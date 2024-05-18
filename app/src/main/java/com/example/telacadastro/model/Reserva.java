package com.example.telacadastro.model;

public class Reserva {
    String nome, qtdpessoas,status, data, hora, id;

    public Reserva() {
    }

    public Reserva(String nome, String qtdpessoas, String status, String data, String hora, String id) {
        this.nome = nome;
        this.qtdpessoas = qtdpessoas;
        this.status = status;
        this.data = data;
        this.hora = hora;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQtdpessoas() {
        return qtdpessoas;
    }

    public void setQtdpessoas(String qtdPessoas) {
        this.qtdpessoas = qtdPessoas;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.hora = id;
    }


}

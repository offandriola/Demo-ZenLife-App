package com.example.ods.domain;


public class User {
    private Integer id;
    private String name;
    private String email;
    private String passoword;
    private String treinos;
    private String dadosMed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassoword() {
        return passoword;
    }

    public void setPassoword(String passoword) {
        this.passoword = passoword;
    }

    public String getTreinos() {
        return treinos;
    }

    public void setTreinos(String treinos) {
        this.treinos = treinos;
    }

    public String getDadosMed() {
        return dadosMed;
    }

    public void setDadosMed(String dadosMed) {
        this.dadosMed = dadosMed;
    }

}

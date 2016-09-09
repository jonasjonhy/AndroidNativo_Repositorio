package com.joao.android.exemplo_sqlite_simples;

/**
 * Created by joao on 08/09/2016.
 */
public class Pessoa {
    private String nome;
    private String email;
    private String cpf;
    private long id;


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }



}

package br.com.jsn.legaltech.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class UsuarioDto {

    @Schema(hidden = true) 
    private Integer id;
    private String nome;
    private String email;

    public UsuarioDto(){}
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
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

    
    
}

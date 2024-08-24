package br.com.jsn.legaltech.dto;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;

public class ProcessoDto {

    @Schema(hidden = true) 
    private Integer id;
    private Integer numero ;
    private String descricao;   
    private Integer usuario;
    @Schema(hidden = true) 
    private String data;

    public ProcessoDto(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    
    



}

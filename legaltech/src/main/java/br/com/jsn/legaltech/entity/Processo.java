package br.com.jsn.legaltech.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "processo")
public class Processo {


    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer processoId;
    @Column(name= "processo_numero")
    private Integer processoNumero;
    @Column(name= "processo_descricao")
    private String processoDescricao;
    @Column(name= "usuario_id")
    private Integer usuarioId;
    @Column(name = "processo_data")
    private Date processoData;


    public Processo(){}

    public Integer getProcessoId() {
        return processoId;
    }
    public void setProcessoId(Integer processoId) {
        this.processoId = processoId;
    }
    public Integer getProcessoNumero() {
        return processoNumero;
    }
    public void setProcessoNumero(Integer processoNumero) {
        this.processoNumero = processoNumero;
    }
    public String getProcessoDescricao() {
        return processoDescricao;
    }
    public void setProcessoDescricao(String processoDescricao) {
        this.processoDescricao = processoDescricao;
    }
    public Integer getUsuarioId() {
        return usuarioId;
    }
    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }
    public Date getProcessoData() {
        return processoData;
    }
    public void setProcessoData(Date processoData) {
        this.processoData = processoData;
    }

    

    
    
}

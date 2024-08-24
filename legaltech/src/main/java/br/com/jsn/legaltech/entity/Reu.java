package br.com.jsn.legaltech.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="reu")
public class Reu {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer reuId;
    @Column(name="reu_nome")
    private String reuName;
    @Column(name="reu_descricao")
    private String reuDescricao;
    @Column(name = "processo_numero")
    private Integer processo ;

    public Reu(){}

    public Integer getReuId() {
        return reuId;
    }

    public void setReuId(Integer reuId) {
        this.reuId = reuId;
    }

    public String getReuName() {
        return reuName;
    }

    public void setReuName(String reuName) {
        this.reuName = reuName;
    }

    public String getReuDescricao() {
        return reuDescricao;
    }

    public void setReuDescricao(String reuDescricao) {
        this.reuDescricao = reuDescricao;
    }

    public Integer getProcesso() {
        return processo;
    }

    public void setProcesso(Integer processo) {
        this.processo = processo;
    }

    

        
}

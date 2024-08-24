package br.com.jsn.legaltech.dto;

public class ReuRequestDto {

    private Integer processo;
    private ReuDto reu ;

    public ReuRequestDto(){}

    public Integer getProcesso() {
        return processo;
    }

    public void setProcesso(Integer processo) {
        this.processo = processo;
    }

    public ReuDto getReu() {
        return reu;
    }

    public void setReu(ReuDto reu) {
        this.reu = reu;
    }

    
    
}

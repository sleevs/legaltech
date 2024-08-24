package br.com.jsn.legaltech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.jsn.legaltech.entity.Processo;

public interface ProcessoRepository extends JpaRepository<Processo,Long>{

    @Query(value ="select * from processo p where p.processo_numero=?1" , nativeQuery=true)
    public Processo buscarProcessoPorNumero(Integer id);
    
}

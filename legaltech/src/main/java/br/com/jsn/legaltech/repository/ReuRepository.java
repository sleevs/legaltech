package br.com.jsn.legaltech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jsn.legaltech.entity.Reu;
import org.springframework.data.jpa.repository.Query;


public interface ReuRepository extends JpaRepository<Reu, Long>{

    @Query(value= "SELECT * FROM reu r WHERE r.processo_numero=?1", nativeQuery=true)
    List<Reu> buscarReusPorNumeroDeProcesso(Integer numero);
    
}

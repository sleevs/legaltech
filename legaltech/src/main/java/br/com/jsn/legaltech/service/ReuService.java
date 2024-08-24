package br.com.jsn.legaltech.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.jsn.legaltech.dto.ReuDto;
import br.com.jsn.legaltech.dto.ReuRequestDto;
import br.com.jsn.legaltech.entity.Processo;
import br.com.jsn.legaltech.entity.Reu;
import br.com.jsn.legaltech.repository.ProcessoRepository;
import br.com.jsn.legaltech.repository.ReuRepository;
import br.com.jsn.legaltech.util.DtoUtil;

@Service
public class ReuService {

    private static final Logger logger =  Logger.getLogger(ReuService.class.getName());
    private ReuRepository repository;
    private ProcessoRepository processoRepository;
  
    public ReuService(ReuRepository repository,ProcessoService processoService, ProcessoRepository processoRepository) {
        this.repository = repository;
        this.processoRepository = processoRepository;
    }

    
    public ReuDto registarReu(ReuDto dto){

     try{
        Reu input = DtoUtil.build(dto);
        Reu result = repository.save(input);
        return DtoUtil.build(result);
     }catch(Exception e){
        e.getMessage();
       
        logger.log(Level.SEVERE,  "Erro ao tentar criar um registro de Réu " + dto, e);
     }
     return null;
    }

    public ReuDto registrarReuAoProcesso(ReuDto dto){

        try{
            Processo processo = processoRepository.buscarProcessoPorNumero(dto.getProcesso());
            ReuDto reuDto = new ReuDto();
            reuDto.setProcesso(processo.getProcessoNumero());
            reuDto.setDescricao(dto.getDescricao());
            reuDto.setNome(dto.getNome());
            return registarReu(reuDto);
        }catch(Exception e){
            e.getMessage();
            logger.log(Level.SEVERE,  "Erro ao tentar associar um registro de Réu a um registro de Processo " + dto, e);
        }
        return null ;
    }


    public List<ReuDto> buscarReusPorProcesso(Integer numero){
        
        List<ReuDto> listResult = new ArrayList<>();
        try{
          var result = repository.buscarReusPorNumeroDeProcesso(numero);
          for(Reu r : result){
            listResult.add(DtoUtil.build(r));
          }
          return listResult;
        }catch(Exception e){
            e.getMessage();
            logger.log(Level.SEVERE,  "Erro ao tentar Réus associados a um número de Processo " + numero, e);
        }
        return null ;
    }
    
}

package br.com.jsn.legaltech.service;

import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;
import br.com.jsn.legaltech.dto.ProcessoDto;
import br.com.jsn.legaltech.entity.Processo;
import br.com.jsn.legaltech.repository.ProcessoRepository;
import br.com.jsn.legaltech.util.DataUtil;
import br.com.jsn.legaltech.util.DtoUtil;

@Service
public class ProcessoService {
    private static final Logger logger = Logger.getLogger(ProcessoService.class.getName());
    private ProcessoRepository processoRepository;

    public ProcessoService(ProcessoRepository processoRepository){
        this.processoRepository = processoRepository;
    }


    public ProcessoDto criarProcesso(ProcessoDto dto){
        
        
        try{
        Boolean result =existeNumeroProcesso(dto.getNumero());
        if(result ==true){
            logger.log(Level.WARNING,  "O número do processo já foi cadastrado anteriormente " ,dto);
            return null ;
        }
        
        Date dataAtual = new Date();
        dto.setData(DataUtil.formatarDataParaString(dataAtual));
        Processo processo = processoRepository.save(DtoUtil.build(dto));
        return DtoUtil.build(processo) ;
        }catch(Exception e){
            e.getMessage();
            logger.log(Level.SEVERE,  "Erro ao tentar criar um registro de o processo " + dto, e);
        }
        return null ;
    }

    public ProcessoDto buscarProcessoPorNumero(Integer numero){
      
        try{
            ProcessoDto dto = DtoUtil.build(processoRepository.buscarProcessoPorNumero(numero));
            return dto ;
        }catch(Exception e){
            e.getMessage();
            logger.log(Level.SEVERE,  "Erro ao tentar encontrar o processo com número " + numero, e);
        }
        return null ;
    }


    public Boolean excluirProcesso(Integer numero){
       try{
        var processo = processoRepository.buscarProcessoPorNumero(numero);
        processoRepository.delete(processo);
        return true ;
       }catch(Exception e){
         e.getMessage();
         logger.log(Level.SEVERE,  "Erro ao tentar excluir o processo com número " + numero, e);
       }
       return false;
    }


    public Boolean existeNumeroProcesso(Integer numero){

        try{
            Processo p =  processoRepository.buscarProcessoPorNumero(numero);
        if(p != null){
            return true;
        }
        }catch(Exception e){
            e.getMessage();
            logger.log(Level.SEVERE,  "Erro ao tentar processar a existencia de um processo com número " + numero, e);
        }
        return false ;
    }
    
    
}

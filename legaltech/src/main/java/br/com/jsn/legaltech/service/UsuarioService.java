package br.com.jsn.legaltech.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.jsn.legaltech.dto.UsuarioDto;
import br.com.jsn.legaltech.entity.Usuario;
import br.com.jsn.legaltech.repository.UsuarioRepository;
import br.com.jsn.legaltech.util.DtoUtil;

@Service
public class UsuarioService {

    private static final Logger logger = Logger.getLogger(UsuarioService.class.getName());
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioDto criarUsuario(UsuarioDto dto){

        if(dto != null){

        try{
            Usuario usuario= usuarioRepository.save(DtoUtil.build(dto));
            return DtoUtil.build(usuario);
        }catch(Exception e){
            e.getMessage();
            logger.log(Level.SEVERE , "Erro ao tentar criar um registro de usuário " +dto , e);
        }
        }
        return null ;
    }
    

    
    
}

package br.com.jsn.legaltech.util;

import br.com.jsn.legaltech.dto.ProcessoDto;
import br.com.jsn.legaltech.dto.ReuDto;
import br.com.jsn.legaltech.dto.UsuarioDto;
import br.com.jsn.legaltech.entity.Processo;
import br.com.jsn.legaltech.entity.Reu;
import br.com.jsn.legaltech.entity.Usuario;


public class DtoUtil {


    public static UsuarioDto build(Usuario usuario){

        UsuarioDto dto = new UsuarioDto();
        dto.setEmail(usuario.getUsuarioEmail());
        dto.setId(usuario.getUsuarioId());
        dto.setNome(usuario.getUsuarioNome());
        return dto;
    }

    public static Usuario build(UsuarioDto dto){

        Usuario usuario = new Usuario();
        usuario.setUsuarioEmail(dto.getEmail());
        usuario.setUsuarioNome(dto.getNome());
        return usuario;
    }
    

    public static ProcessoDto build(Processo processo){

        ProcessoDto processoDto = new ProcessoDto();
        processoDto.setId(processo.getProcessoId());
        processoDto.setDescricao(processo.getProcessoDescricao());
        processoDto.setNumero(processo.getProcessoNumero());
        processoDto.setUsuario(processo.getUsuarioId());
        processoDto.setData(DataUtil.formatarDataParaString(processo.getProcessoData()));
        return processoDto;
    }

    public static Processo build(ProcessoDto dto){

        Processo processo = new Processo();
        processo.setProcessoData(DataUtil.formatarStringParaData(dto.getData()));
        processo.setProcessoDescricao(dto.getDescricao());
        processo.setProcessoNumero(dto.getNumero());
        processo.setUsuarioId(dto.getUsuario());
        return processo;
    }
    

    public static ReuDto build(Reu reu ){

        ReuDto reuDto = new ReuDto();
        reuDto.setDescricao(reu.getReuDescricao());
        reuDto.setNome(reu.getReuName());
        reuDto.setProcesso(reu.getProcesso());
        return reuDto;
    }


    public static Reu build(ReuDto dto){

        Reu reu = new Reu();
        reu.setProcesso(dto.getProcesso());
        reu.setReuDescricao(dto.getDescricao());
        reu.setReuName(dto.getNome());
        return reu;
    }
    
}

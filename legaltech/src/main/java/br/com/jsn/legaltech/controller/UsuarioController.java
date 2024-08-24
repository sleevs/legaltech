package br.com.jsn.legaltech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.jsn.legaltech.dto.UsuarioDto;
import br.com.jsn.legaltech.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class UsuarioController {
    

    @Autowired
    private UsuarioService usuarioService;

     
     @Operation(
      summary = "Criar um usuário",
      description = "Realiza a criação de um usuário para a utilização das operações de Processo.",
      tags = {"Criar usuário"}
       )
     @ApiResponses(value = {
     @ApiResponse(responseCode = "200", description = "Usuário criado com sucesso"),
     @ApiResponse(responseCode = "400", description = "Requisição inválida")
     })
     @PostMapping("/usuario")
     public ResponseEntity<Object> criarUsuario(@RequestBody UsuarioDto requestUsuario){
    
      try{
        if (requestUsuario.getNome() == null || requestUsuario.getEmail() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Requisição inválida: dados do Usuário são obrigatórios.");
         }
        return ResponseEntity.ok(usuarioService.criarUsuario(requestUsuario)) ;
      }catch(Exception e){
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno do servidor.");
      }
        
     }





    }
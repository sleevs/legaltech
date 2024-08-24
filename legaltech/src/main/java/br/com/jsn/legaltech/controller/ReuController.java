package br.com.jsn.legaltech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.jsn.legaltech.dto.ReuDto;
import br.com.jsn.legaltech.service.ReuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class ReuController {

    @Autowired
    private ReuService reuService;

  
   @Operation(
    summary = "Registrar um Réu ao processo",
    description = "Realiza a vinculação de um Réu ao número de Processo.",
    tags = {"Registrar Réu"}
     )
   @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Réu vinsculado ao processo com sucesso"),
    @ApiResponse(responseCode = "404", description = "Processo informado para vincular o Réu não foi encontrado"),
    @ApiResponse(responseCode = "400", description = "Parâmetro inválido")
   })
   @PostMapping("/reu")
   public ResponseEntity<Object> registrarReu(@RequestBody ReuDto requestReu){
       
        try{
            if (requestReu.getProcesso() == null || requestReu.getProcesso() <= 0) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Número do Processo informado é inválido");
            }
            ReuDto reuDto = reuService.registrarReuAoProcesso(requestReu);
            if (reuDto == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Processo não encontrado");
            }

            return ResponseEntity.ok(reuDto);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno do servidor.");
        }
            
        }


    
     
     @Operation(
        summary = "Consultar de registro de Réu",
        description = "Realiza a consultar por Réus associados ao número de Processo.",
        tags = {"Consultar Réu"}
         )
      @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Resultado da pesquisa com sucesso"),
        @ApiResponse(responseCode = "404", description = "Processo não encontrado"),
        @ApiResponse(responseCode = "400", description = "Parâmetro inválido")
    })
      @GetMapping("/consultar_reus")
      public ResponseEntity<Object> consultarReus(@RequestParam(value= "numero") Integer numero){
     
        
        try{
            if (numero == null || numero <= 0) {
                return ResponseEntity.badRequest().body("Número informado inválido");
             }
             List<ReuDto> list = reuService.buscarReusPorProcesso(numero);
            if (list == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Número de Processo não encontrado");
            }
    
            return ResponseEntity.ok(list);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno do servidor.");
        }
            
      }
    
}

package br.com.jsn.legaltech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.jsn.legaltech.dto.ProcessoDto;
import br.com.jsn.legaltech.service.ProcessoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class ProcessoController {

   @Autowired
   private ProcessoService processoService;

   
    @Operation(
      summary = "Registrar processo no sistema",
      description = "Cria um novo processo e o registra no sistema.",
      tags = {"Processo"}
  )
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Processo criado com sucesso"),
    @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    @PostMapping("/processo")
     public ResponseEntity<Object> registrarProcesso(@RequestBody ProcessoDto requestProcesso){
         
           
      try {
         if (requestProcesso == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Requisição inválida: dados do processo são obrigatórios.");
         }
      
      if (requestProcesso.getNumero() == null || requestProcesso.getNumero() <= 0) {
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Número do processo informado é inválido.");
      }
        
         ProcessoDto processo = processoService.criarProcesso(requestProcesso);

         if (processo == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Número de processo já cadastrado anteriormente.");
         }
         return ResponseEntity.ok(processo);
      } catch (Exception e) {
         
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno do servidor.");
       }
      }


     
     @Operation(
      summary = "consultar por número de processo",
      description = "Realiza consulta no sistema a partir do número do processo.",
      tags = {"Consulatar Processo"}
       )
      @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Processo encontrado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Processo não encontrado"),
        @ApiResponse(responseCode = "400", description = "Parâmetro inválido")
    })
     @GetMapping("/consultar_processo")
      public ResponseEntity<Object> consultarProcesso(@RequestParam(value= "numero") Integer numero){
     
         try{
            if (numero == null || numero <= 0) {
               return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Número informado inválido");
            }
            ProcessoDto processo = processoService.buscarProcessoPorNumero(numero);
           if (processo == null) {
               return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Processo não encontrado");
           }
   
           return ResponseEntity.ok(processo);
         }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno do servidor.");
         }
         
      }


     
      @Operation(
         summary = "excluir  por número de processo",
         description = "Realiza a exclusão de registro no sistema a partir do número do processo.",
         tags = {"Excluir Processo"}
          )
      @ApiResponses(value = {
         @ApiResponse(responseCode = "200", description = "Processo excluído com sucesso"),
         @ApiResponse(responseCode = "404", description = "Processo não encontrado"),
         @ApiResponse(responseCode = "400", description = "Parâmetro inválido")
     })
      @DeleteMapping("/excluir_processo")
      public ResponseEntity<Object> deletarProcesso(@RequestParam(value= "numero") Integer numero){
     
       try{

         if (numero == null || numero <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Número informado inválido");
         }
         Boolean result = processoService.excluirProcesso(numero);
        if (result == false) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Processo não encontrado");
        }

        return  ResponseEntity.status(HttpStatus.OK).body("Processo excluído com sucesso");

       }catch(Exception e){
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno do servidor.");
       }
         
      }

    
}

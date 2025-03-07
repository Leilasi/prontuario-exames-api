package com.clinica.controller;

import com.clinica.dto.request.FilaTriagemRequestDTO;
import com.clinica.dto.request.ProntuarioExameRequestDTO;
import com.clinica.service.ProntuarioExameService;
import com.clinica.utils.exception.EntidadeNaoEncontradaException;
import com.clinica.utils.exception.FilaVaziaException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prontuario-exame")
@Tag(name = "Prontuário de Exames", description = "Gerenciamento de prontuários médicos e fila de triagem")
public class ProntuarioExameController {

    @Autowired
    private ProntuarioExameService service;

    @Operation(summary = "Adicionar um novo prontuário", description = "Cria um novo prontuário com os dados fornecidos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Prontuário adicionado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao adicionar prontuário", content = @Content)
    })
    @PostMapping("adicionarNovoProntuario")
    public ResponseEntity<?> adicionarProntuario(@RequestBody ProntuarioExameRequestDTO prontuarioExameDTO) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.adicionarProntuario(prontuarioExameDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao adicionar prontuário: " + e.getMessage());
        }
    }

    @Operation(summary = "Buscar todos os prontuários", description = "Retorna uma lista com todos os prontuários cadastrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de prontuários"),
            @ApiResponse(responseCode = "500", description = "Erro ao buscar prontuários", content = @Content)
    })
    @GetMapping("buscarTodosProntuarios")
    public ResponseEntity<?> buscarTodos() {
        try {
            return ResponseEntity.ok(service.buscarTodos());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar prontuários: " + e.getMessage());
        }
    }

    @Operation(summary = "Buscar prontuário por ID", description = "Retorna os detalhes de um prontuário específico.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Prontuário encontrado"),
            @ApiResponse(responseCode = "404", description = "Prontuário não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro ao buscar prontuário", content = @Content)
    })
    @GetMapping("buscarProntuario")
    public ResponseEntity<?> buscarPorId(@Parameter(description = "ID do prontuário") @RequestParam("id") Long id) {
        try {
            return ResponseEntity.ok(service.buscarPorId(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar prontuário: " + e.getMessage());
        }
    }

    @Operation(summary = "Buscar prontuário por CPF", description = "Retorna os prontuários associados ao CPF informado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de prontuários"),
            @ApiResponse(responseCode = "500", description = "Erro ao buscar prontuário", content = @Content)
    })
    @GetMapping("buscarProntuarioPorCpf")
    public ResponseEntity<?> buscarPorCpf(@Parameter(description = "CPF do paciente") @RequestParam("cpf") String cpf) {
        try {
            return ResponseEntity.ok(service.buscarPorCpf(cpf));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar prontuários por CPF: " + e.getMessage());
        }
    }

    @Operation(summary = "Chamar próximo paciente", description = "Busca o próximo paciente na fila de triagem.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Paciente encontrado"),
            @ApiResponse(responseCode = "404", description = "Fila vazia ou profissional não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro ao processar requisição", content = @Content)
    })
    @GetMapping("/chamarProximoPaciente")
    public ResponseEntity<?> chamarProximoPaciente(
            @Parameter(description = "Matrícula do profissional") @RequestParam("matriculaProfisional") String matriculaProfisional) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarProximoFila(matriculaProfisional));
        } catch (FilaVaziaException | EntidadeNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar requisição: " + e.getMessage());
        }
    }
}
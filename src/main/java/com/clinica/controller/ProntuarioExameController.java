package com.clinica.controller;

import com.clinica.dto.ProntuarioExameDTO;
import com.clinica.service.ProntuarioExameService;
import com.clinica.service.impl.ProntuarioExameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prontuario-exame")
public class ProntuarioExameController {

    @Autowired
    private ProntuarioExameService service;

    @PostMapping
    public ResponseEntity<?> adicionarProntuario(@RequestBody ProntuarioExameDTO prontuarioExameDTO) {
        try {
            service.adicionarProntuario(prontuarioExameDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Prontuário adicionado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao adicionar prontuário: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> buscarTodos() {
        try {
            return ResponseEntity.ok(service.buscarTodos());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar prontuários: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.buscarPorId(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar prontuário: " + e.getMessage());
        }
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<?> buscarPorCpf(@PathVariable String cpf) {
        try {
            return ResponseEntity.ok(service.buscarPorCpf(cpf));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar prontuários por CPF: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarProntuario(@PathVariable Long id, @RequestBody ProntuarioExameDTO prontuarioExameDTO) {
        try {
            return ResponseEntity.ok(service.atualizarProntuario(id, prontuarioExameDTO));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar prontuário: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarProntuario(@PathVariable Long id) {
        try {
            service.deletarProntuario(id);
            return ResponseEntity.ok("Prontuário deletado com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar prontuário: " + e.getMessage());
        }
    }

    // Novo método para chamar o próximo exame da fila
    @GetMapping("/chamarProximoPaciente")
    public ResponseEntity<?> chamarProximoPaciente(
            @RequestParam("matriculaProfisional") String matriculaProfisional,
            @RequestParam("abrirProximeTo") Boolean abrirProximeTo) {

        try {
            service.buscarProximoFila(matriculaProfisional, abrirProximeTo);
            return null;
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao chamar próximo exame: " + e.getMessage());
        }
    }
}

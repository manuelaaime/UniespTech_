package com.uniesp.tech.demo.controller;

import com.uniesp.tech.demo.model.Aluno;
import com.uniesp.tech.demo.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @PostMapping
    public ResponseEntity<Aluno> cadastrarAluno(@Valid @RequestBody Aluno aluno){
        Aluno alunoSalvo = service.cadastrarAluno(aluno);
        return ResponseEntity.ok(alunoSalvo);
    }

    @GetMapping
    public List<Aluno> listarAlunos(){
        return service.listarAlunos();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarAlunoPorId(@PathVariable Long id){
        service.deletarAlunoPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarAlunoPorId(@PathVariable Long id, @RequestBody Aluno aluno){
        service.atualizarAlunoPorId(id, aluno);
    }
}
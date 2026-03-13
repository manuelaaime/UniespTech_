package com.uniesp.tech.demo.controller;

import com.uniesp.tech.demo.model.Aluno;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.uniesp.tech.demo.service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @PostMapping
    public ResponseEntity<Aluno> cadastrarAluno(@Valid @RequestBody Aluno aluno){
        Aluno alunoSalvo = service.cadastrarAluno(aluno); // Passe o objeto inteiro
        return ResponseEntity.ok(alunoSalvo);
    }

    @GetMapping
    public List<Aluno> listarAlunos(){
        return service.listarAlunos();
    }

    @DeleteMapping
    public void deletarTodos(){
        service.deletarTodos();
    }
}
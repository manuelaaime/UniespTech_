package com.uniesp.tech.demo.controller;

import com.uniesp.tech.demo.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.uniesp.tech.demo.service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @PostMapping
    public void cadastrar(@RequestBody Aluno aluno){
        service.cadastrarAluno(aluno.getNome(), aluno.getCpf());
    }

    @GetMapping
    public List<Aluno> listar(){
        return service.listarAlunos();
    }

    @DeleteMapping
    public void deletarTudo(){
        service.deletarTodos();
    }
}
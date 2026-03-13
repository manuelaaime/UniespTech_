package com.uniesp.tech.demo.service;

import com.uniesp.tech.demo.model.Aluno;
import com.uniesp.tech.demo.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    @Transactional // Garante que a operação seja finalizada no banco
    public Aluno cadastrarAluno(Aluno aluno) {

        return repository.save(aluno);
    }

    public List<Aluno> listarAlunos() {
        return repository.findAll();
    }

    public void deletarTodos() {
        repository.deleteAll(); 
    }
}
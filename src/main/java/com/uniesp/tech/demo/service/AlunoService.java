package com.uniesp.tech.demo.service;

import com.uniesp.tech.demo.model.Aluno;
import com.uniesp.tech.demo.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    public void cadastrarAluno(String nome, String cpf){

        if(nome == null || nome.isEmpty()){
            throw new RuntimeException("Nome não pode ser vazio");
        }

        if(cpf == null || cpf.length() != 11){
            throw new RuntimeException("CPF deve ter 11 dígitos");
        }

        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setCpf(cpf);

        repository.salvar(aluno);
    }

    public List<Aluno> listarAlunos(){
        return repository.listar();
    }

    public void deletarTodos(){
        repository.deletarTodos();
    }
}
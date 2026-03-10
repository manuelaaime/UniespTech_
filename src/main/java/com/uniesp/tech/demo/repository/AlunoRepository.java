package com.uniesp.tech.demo.repository;

import com.uniesp.tech.demo.model.Aluno;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AlunoRepository {

    private List<Aluno> alunos = new ArrayList<>();

    public void salvar(Aluno aluno){
        alunos.add(aluno);
    }

    public List<Aluno> listar(){
        return alunos;
    }

    public void deletarTodos(){
        alunos.clear();
    }
}
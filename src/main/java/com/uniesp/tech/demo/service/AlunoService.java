package com.uniesp.tech.demo.service;

import com.uniesp.tech.demo.model.Aluno;
import com.uniesp.tech.demo.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Transactional
    public Aluno cadastrarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public List<Aluno> listarAlunos() {
        return alunoRepository.findAll();
    }

    public void deletarAlunoPorId(Long id) {
        alunoRepository.deleteById(id);
    }

    public Optional<Aluno> buscarAlunoPorId(Long id) {
        return alunoRepository.findById(id);
    }

    public void atualizarAlunoPorId(Long id, Aluno aluno) {
        Optional<Aluno> alunoDoBancoDeDados = buscarAlunoPorId(id);

        if (alunoDoBancoDeDados.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Aluno não encontrado no Banco de Dados"
            );
        }

        Aluno alunoParaEditar = alunoDoBancoDeDados.get();

        alunoParaEditar.setNome(aluno.getNome());
        alunoParaEditar.setCpf(aluno.getCpf());

        alunoRepository.save(alunoParaEditar);
    }
}
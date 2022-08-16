package com.academia.service;

import java.text.MessageFormat;
import java.util.Optional;

import com.academia.model.dto.AlunoDTO;
import com.academia.util.MensagemUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academia.model.Aluno;
import com.academia.repository.AlunoRepository;

@Service
@Log4j2
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Iterable<Aluno> getAlunos() {
        return alunoRepository.findAll();

    }

    public Aluno getAlunoById(Long id) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);
        return alunoOptional.orElse(null);
    }

    public Aluno criarAluno(AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno();
        if (getAlunoById(alunoDTO.getId()) != null) {
            log.error(MensagemUtil.ALUNO_ID_JA_CADASTRADO, alunoDTO.getId());
        }
        BeanUtils.copyProperties(alunoDTO, aluno);

        return alunoRepository.save(aluno);
    }

    public Aluno atualizarAluno(AlunoDTO alunoDTO, Long id) {
        Aluno aluno = getAlunoById(id);

        BeanUtils.copyProperties(alunoDTO, aluno);
        return alunoRepository.save(aluno);

    }

    public String deletarAluno(Long id) {
        if (getAlunoById(id) != null) {
            alunoRepository.deleteById(id);
            return "Aluno deletado com sucesso";
        } else {
            throw new IllegalArgumentException(MessageFormat.format(MensagemUtil.ALUNO_NAO_ECONTRADO, id));
        }
    }

}

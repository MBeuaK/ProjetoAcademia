package com.academia.service;

import java.text.MessageFormat;
import java.util.Optional;

import com.academia.model.dto.AlunoDTO;
import com.academia.model.dto.BaseResponseDTO;
import com.academia.util.MensagemUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.academia.model.Aluno;
import com.academia.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public Iterable<Aluno> getAlunos(){
		return alunoRepository.findAll();

	}

	public Optional<Aluno> getAlunosById(Long id) {
		return alunoRepository.findById(id);
	}

	public Aluno criarAluno(AlunoDTO alunoDTO) {
		Aluno aluno = new Aluno();
		Optional<Aluno> optional = getAlunosById(alunoDTO.getId());

		if(optional.isPresent()){
			throw new IllegalArgumentException(MessageFormat
					.format(MensagemUtil.ALUNO_ID_JA_CADASTRADO, alunoDTO.getId()));
		}

		BeanUtils.copyProperties(alunoDTO, aluno);

		return alunoRepository.save(aluno);
	}

	public Object update(AlunoDTO alunoDTO, Long id) {
		Optional<Aluno> optional = getAlunosById(id);

		if(optional.isPresent()) {
			Aluno aluno=optional.get();

			BeanUtils.copyProperties(alunoDTO, alunoDTO);
			
			alunoRepository.save(aluno);
			return alunoRepository.save(aluno);
		} else {
			throw new IllegalArgumentException(MessageFormat.format(MensagemUtil.ALUNO_NAO_ECONTRADO, id));
		}
	}
	
	public void delete(Long id) {
		Optional<Aluno> aluno = getAlunosById(id);
			if(aluno.isPresent()) {
				alunoRepository.deleteById(id);
			}
	}
	

}

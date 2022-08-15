package com.academia.controller;


import java.util.Optional;


import com.academia.util.MensagemUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.academia.model.dto.AlunoDTO;
import com.academia.model.dto.BaseResponseDTO;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academia.model.Aluno;
import com.academia.service.AlunoService;

import static jdk.internal.org.jline.utils.Log.error;
import static org.apache.logging.log4j.spi.LoggerContextKey.create;

@RestController
@RequestMapping("/api/v1/alunos")
public class AlunoController {
	private final Logger log = LoggerFactory.getLogger(AlunoController.class);

	@Autowired
	private AlunoService alunoService;
	
	@GetMapping
	public ResponseEntity<Iterable<Aluno>> get() {
		return ResponseEntity.ok(alunoService.getAlunos());
	}
	 
	@GetMapping("/{id}")
	public ResponseEntity<Aluno> get(@PathVariable("id") Long id) {
		Optional<Aluno> aluno = alunoService.getAlunosById(id);
		return aluno
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity cadastrarAluno(@RequestBody AlunoDTO alunoDTO) {
		try{
			alunoService.criarAluno(alunoDTO);
			return new ResponseEntity("Aluno cadastrado com sucesso: " + alunoDTO, HttpStatus.CREATED);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return new ResponseEntity<>(MensagemUtil.ERRO_DESCONHECIDO,HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<BaseResponseDTO> editarAluno(@PathVariable("id") @NonNull Long id, @RequestBody AlunoDTO alunoDTO) {
		try {
			alunoService.update(alunoDTO,id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return new ResponseEntity(MensagemUtil.ERRO_DESCONHECIDO,HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/{id}")
	public String deletarAluno(@PathVariable("id")Long id) {
		alunoService.delete(id);
		return "Aluno deletado com sucesso!";
	}

}

package com.academia.controller;


import com.academia.model.dto.AlunoDTO;
import com.academia.model.dto.BaseResponseDTO;
import com.academia.service.AlunoService;
import com.academia.util.MensagemUtil;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/alunos")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

	protected BaseResponseDTO buildResponse(Object object) {
		BaseResponseDTO response = new BaseResponseDTO();
		response.setData(object);
		response.setMessage("Sucesso");
		return response;
	}

	protected BaseResponseDTO buildResponseMessage(String message) {
		BaseResponseDTO response = new BaseResponseDTO();
		response.setMessage(message);
		return response;
	}


	@GetMapping
	public BaseResponseDTO buscarTodosAlunos() {
		return buildResponse(alunoService.getAlunos());
	}
	 
	@GetMapping("/{id}")
	public BaseResponseDTO buscarAlunoPorId(@PathVariable("id") Long id) {
		return buildResponse(alunoService.getAlunoById(id));
	}
	
	@PostMapping
	public BaseResponseDTO cadastrarAluno(@RequestBody AlunoDTO alunoDTO) {
			return buildResponse(alunoService.criarAluno(alunoDTO));
	}
	
	@PutMapping("/{id}")
	public BaseResponseDTO editarAluno(@PathVariable("id") @NonNull Long id, @RequestBody AlunoDTO alunoDTO) {
			return buildResponse(alunoService.atualizarAluno(alunoDTO,id));
	}
	
	@DeleteMapping("/{id}")
	public BaseResponseDTO deletarAluno(@PathVariable("id")Long id) {
		alunoService.deletarAluno(id);
		return buildResponseMessage(alunoService.deletarAluno(id));
	}

}

package com.academia.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDTO  implements Serializable{
	
	 private static final long serialVersionUID = 1L;
	 
	 private Long id;
	 private String nome; 
	 private Long idTreino;
	 private Long idInstrutor;


}

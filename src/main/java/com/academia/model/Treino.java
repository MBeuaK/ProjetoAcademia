package com.academia.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name="treino")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Treino {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="treino_id")
	private Long id;
	
	@Column(name = "nome_treino")
	private String nomeDoTreino;
	
	@Column(name = "tipo_treino")
	private int tipoTreino;

	@ManyToOne
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;

}

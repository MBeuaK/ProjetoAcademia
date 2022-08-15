package com.academia.model;

import com.academia.model.enums.RepeticaoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="exercicio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exercicio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "exercicio_id")
	private Long id;
	
	@Column(name = "nome_exercicio")
	private String nomeDoExercicio;

	@Column(name = "serie")
	private RepeticaoEnum serie;

	@ManyToOne
	@JoinColumn(name = "treino_id")
	private Treino treino;

}

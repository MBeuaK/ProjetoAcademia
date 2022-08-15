package com.academia.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="instrutor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Instrutor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "instrutor_id")
	private Long id;
	
	@Column(name = "nome_instrutor")
	private String nome;

}

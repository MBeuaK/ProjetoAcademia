package com.academia.model.dto;

import com.academia.model.enums.RepeticaoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExercicioDTO {

    private Long id;
    private String nomeDoExercicio;
    private RepeticaoEnum serie;
    private Long treinoId;

}

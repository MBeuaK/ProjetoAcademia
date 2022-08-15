package com.academia.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TreinoDTO {

    private Long id;
    private String nomeDoTreino;
    private int tipoTreino;
    private Long alunoId;

}

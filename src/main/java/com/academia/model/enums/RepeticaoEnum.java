package com.academia.model.enums;

import org.apache.commons.lang3.EnumUtils;

public enum RepeticaoEnum {
    
    PADRAO("3 séries de 12 repetições"),
    AVANCADO("4 séries de 12 repetições"),
    FORCA("4 séries de 6 a 8 repetições"),
    PANTURRILHA("3 séries de 20 repetições"),
    ABDOMEN("3 séries de 20 repetições");

    RepeticaoEnum(String descricao) {
    }

    public static RepeticaoEnum getEnum(String descricao){
        return EnumUtils.getEnum(RepeticaoEnum.class, descricao, PADRAO);
    }
}

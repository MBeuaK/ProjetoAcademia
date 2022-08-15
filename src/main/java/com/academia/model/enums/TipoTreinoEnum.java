package com.academia.model.enums;

import org.apache.commons.lang3.EnumUtils;

public enum TipoTreinoEnum {
    PEITO(1),
    COSTAS(2),
    PERNA(3),
    PANTURRILHA(4),
    ABDOMEN(5);

    TipoTreinoEnum(int value) {
    }

    public static TipoTreinoEnum getEnum(String label){
        return EnumUtils.getEnum(TipoTreinoEnum.class, label, PEITO);
    }
}

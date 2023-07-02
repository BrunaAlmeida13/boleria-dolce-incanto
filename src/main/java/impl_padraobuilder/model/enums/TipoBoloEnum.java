package impl_padraobuilder.model.enums;

import java.math.BigDecimal;

public enum TipoBoloEnum {
    SIMPLES(new BigDecimal("10.0")),
    FESTA(new BigDecimal("15.0")),
    CASAMENTO(new BigDecimal("20.0"));

    private BigDecimal preco;

    TipoBoloEnum(BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getPreco() {
        return preco;
    }
}

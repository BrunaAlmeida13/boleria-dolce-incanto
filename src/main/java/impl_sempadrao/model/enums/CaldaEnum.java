package impl_sempadrao.model.enums;

import java.math.BigDecimal;

public enum CaldaEnum {
    CHOCOLATE(new BigDecimal("2.0")),
    BAUNILHA(new BigDecimal("2.0")),
    MORANGO(new BigDecimal("2.0"));

    private BigDecimal preco;

    CaldaEnum(BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getPreco() {
        return preco;
    }
}

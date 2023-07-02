package impl_padraobuilder.model.enums;

import java.math.BigDecimal;

public enum FormaEnum {

    REDONDA(new BigDecimal("10.0")),
    QUADRADA(new BigDecimal("7.0"));

    private BigDecimal preco;

    FormaEnum(BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getPreco() {
        return preco;
    }
}

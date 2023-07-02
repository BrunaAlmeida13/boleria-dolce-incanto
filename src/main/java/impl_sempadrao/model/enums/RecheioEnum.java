package impl_sempadrao.model.enums;

import java.math.BigDecimal;

public enum RecheioEnum {
    FLORESTA_NEGRA(new BigDecimal("12.0")),
    SENSACAO(new BigDecimal("15.0")),
    BABA_DE_MOCA(new BigDecimal("13.0"));
    private BigDecimal preco;

    RecheioEnum(BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getPreco() {
        return preco;
    }
}

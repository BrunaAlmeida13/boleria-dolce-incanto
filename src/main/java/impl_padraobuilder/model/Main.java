package impl_padraobuilder.model;

import impl_padraobuilder.model.enums.CaldaEnum;
import impl_padraobuilder.model.enums.FormaEnum;
import impl_padraobuilder.model.enums.RecheioEnum;
import impl_padraobuilder.model.enums.TipoBoloEnum;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Bolo boloFesta = new Bolo.Builder()
                .tipo(TipoBoloEnum.FESTA)
                .forma(FormaEnum.QUADRADA)
                .recheio(RecheioEnum.FLORESTA_NEGRA)
                .calda(CaldaEnum.CHOCOLATE)
                .peso(new BigDecimal("12.0"))
                .build();

        boloFesta.mostrarDetalhes();

        System.out.println();

        Bolo boloCasamento = new Bolo.Builder()
                .tipo(TipoBoloEnum.CASAMENTO)
                .forma(FormaEnum.REDONDA)
                .recheio(RecheioEnum.BABA_DE_MOCA)
                .calda(CaldaEnum.MORANGO)
                .peso(new BigDecimal("25.0"))
                .build();

        boloCasamento.mostrarDetalhes();
    }
}

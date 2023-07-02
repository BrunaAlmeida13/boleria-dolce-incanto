package impl_sempadrao;

import impl_sempadrao.model.Bolo;
import impl_sempadrao.model.enums.CaldaEnum;
import impl_sempadrao.model.enums.FormaEnum;
import impl_sempadrao.model.enums.RecheioEnum;
import impl_sempadrao.model.enums.TipoBoloEnum;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Bolo boloCasamento = new Bolo(TipoBoloEnum.CASAMENTO, FormaEnum.QUADRADA, RecheioEnum.SENSACAO, CaldaEnum.CHOCOLATE.CHOCOLATE, new BigDecimal("30.0"));
        boloCasamento.mostrarDetalhes();

        System.out.println();

        Bolo boloFesta = new Bolo(TipoBoloEnum.FESTA, FormaEnum.REDONDA, RecheioEnum.FLORESTA_NEGRA, CaldaEnum.MORANGO, new BigDecimal("10.0"));
        boloFesta.mostrarDetalhes();

        System.out.println();

        Bolo boloSimples = new Bolo(TipoBoloEnum.SIMPLES, FormaEnum.REDONDA, null, CaldaEnum.BAUNILHA, new BigDecimal("2.0"));
        boloSimples.mostrarDetalhes();

    }
}

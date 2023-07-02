package impl_sempadrao.model;

import impl_sempadrao.model.enums.CaldaEnum;
import impl_sempadrao.model.enums.FormaEnum;
import impl_sempadrao.model.enums.RecheioEnum;
import impl_sempadrao.model.enums.TipoBoloEnum;

import java.math.BigDecimal;

public class Bolo {
    private TipoBoloEnum tipo;
    private FormaEnum forma;
    private RecheioEnum recheio;
    private CaldaEnum calda;
    private BigDecimal peso;
    private static final BigDecimal PRECO_POR_KG = new BigDecimal("60.0");
    private BigDecimal preco;

    public Bolo(TipoBoloEnum tipo, FormaEnum forma, RecheioEnum recheio, CaldaEnum calda, BigDecimal peso) {
        this.tipo = tipo;
        this.forma = forma;

        if (tipo == TipoBoloEnum.SIMPLES && recheio != null) {
            throw new IllegalArgumentException("Bolo simples não pode ter recheio!");
        }

        this.recheio = recheio;
        this.calda = calda;
        this.peso = peso;
        this.preco = calcularPreco();
    }

    private BigDecimal calcularPreco() {
        BigDecimal precoBase = tipo.getPreco();
        BigDecimal precoForma = forma.getPreco();
        BigDecimal precoRecheio = (recheio != null) ? recheio.getPreco() : BigDecimal.ZERO;
        BigDecimal precoCalda = calda.getPreco();

        BigDecimal precoSemPeso = precoBase.add(precoForma).add(precoRecheio).add(precoCalda);
        BigDecimal precoTotal = precoSemPeso.add(PRECO_POR_KG.multiply(peso));
        return precoTotal;
    }

    public void mostrarDetalhes() {
        System.out.println("Detalhes do bolo:");
        System.out.println("Tipo: " + tipo);
        System.out.println("Forma: " + forma);
        if (recheio != null) {
            System.out.println("Recheio: " + recheio);
        }
        System.out.println("Peso: " + peso + " kg");
        System.out.println("Calda: " + calda);
        System.out.println("Preço: R$" + preco);
    }
}

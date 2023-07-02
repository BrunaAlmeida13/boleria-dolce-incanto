package impl_padraobuilder.model;

import impl_padraobuilder.model.enums.CaldaEnum;
import impl_padraobuilder.model.enums.FormaEnum;
import impl_padraobuilder.model.enums.RecheioEnum;
import impl_padraobuilder.model.enums.TipoBoloEnum;

import java.math.BigDecimal;

public class Bolo {
    private TipoBoloEnum tipo;
    private FormaEnum forma;
    private RecheioEnum recheio;
    private CaldaEnum calda;
    private BigDecimal peso;
    private static final BigDecimal PRECO_POR_KG = new BigDecimal("60.0");
    private BigDecimal preco;

    private Bolo() {
    }

    public TipoBoloEnum getTipo() {
        return tipo;
    }

    public FormaEnum getForma() {
        return forma;
    }

    public RecheioEnum getRecheio() {
        return recheio;
    }

    public CaldaEnum getCalda() {
        return calda;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public BigDecimal getPreco() {
        return preco;
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

    public static class Builder {
        private TipoBoloEnum tipo;
        private FormaEnum forma;
        private RecheioEnum recheio;
        private CaldaEnum calda;
        private BigDecimal peso;

        public Builder tipo(TipoBoloEnum tipo) {
            this.tipo = tipo;
            return this;
        }

        public Builder forma(FormaEnum forma) {
            this.forma = forma;
            return this;
        }

        public Builder recheio(RecheioEnum recheio) {
            this.recheio = recheio;
            return this;
        }

        public Builder calda(CaldaEnum calda) {
            this.calda = calda;
            return this;
        }

        public Builder peso(BigDecimal peso) {
            this.peso = peso;
            return this;
        }

        public Bolo build() {
            if (tipo == TipoBoloEnum.SIMPLES && recheio != null) {
                throw new IllegalArgumentException("Bolo simples não pode ter recheio!");
            }

            Bolo bolo = new Bolo();
            bolo.tipo = tipo;
            bolo.forma = forma;
            bolo.recheio = recheio;
            bolo.calda = calda;
            bolo.peso = peso;
            bolo.preco = bolo.calcularPreco();
            return bolo;
        }
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

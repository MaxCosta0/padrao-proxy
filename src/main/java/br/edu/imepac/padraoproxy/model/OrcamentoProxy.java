package br.edu.imepac.padraoproxy.model;

import java.math.BigDecimal;

public class OrcamentoProxy extends Orcamento {
    private Orcamento orcamento;
    private BigDecimal descontoOrcamento;

    public OrcamentoProxy(Orcamento orcamento) {
        this.orcamento = orcamento;
    }

    @Override
    public BigDecimal getDescontoOrcamento() {
        if (descontoOrcamento == null) {
            this.descontoOrcamento = orcamento.getDescontoOrcamento();
        }
        return descontoOrcamento;
    }
}

package br.edu.imepac.padraoproxy;

import br.edu.imepac.padraoproxy.model.Orcamento;
import br.edu.imepac.padraoproxy.model.OrcamentoProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class PadraoProxyApplication {

	public static void main(String[] args) {
		Orcamento orcamento = new Orcamento(new BigDecimal("100"), new BigDecimal("10"));
		System.out.println("Valor do orcamento = " + orcamento.getValorOrcamento());
		System.out.println("Tempo para ver o desconto = " + orcamento.getDescontoOrcamento());

		OrcamentoProxy proxy = new OrcamentoProxy(orcamento);

		long tempoInicioSemProxy = System.nanoTime();
		System.out.println("Valor sem proxy = " + proxy.getDescontoOrcamento());
		long tempoFimSemProxy = System.nanoTime();
		long tempoDecorridoSemProxy = (tempoFimSemProxy - tempoInicioSemProxy) / 1000000000;

		long tempoInicioComProxy = System.nanoTime();
		System.out.println("Valor com proxy = " + proxy.getDescontoOrcamento());
		long tempoFimComProxy = System.nanoTime();
		long tempoDecorridoComProxy = (tempoFimComProxy - tempoInicioComProxy) / 1000000000;

		System.out.println("Tempo de espera sem cache proxy " + tempoDecorridoSemProxy + " segundos");
		System.out.println("Tempo de espera com chache proxy " + tempoDecorridoComProxy + " segundos");
	}

}

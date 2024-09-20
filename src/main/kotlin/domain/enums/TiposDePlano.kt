package br.com.gabriel.domain.enums

import br.com.gabriel.domain.models.Aluguel
import br.com.gabriel.domain.interfaces.Plano

enum class TiposDePlano(val mensalidade: Double, val qtdJogosGratis : Int, val desconto : Double) : Plano {

    BRONZE(0.0, 0, desconto = 0.0) {
        override fun obterOValor(aluguel: Aluguel): Double {
            return super.obterOValor(aluguel)
        }
    },
    PRATA(30.0, 2, desconto = 0.15) {
        override fun obterOValor(aluguel: Aluguel): Double {
            val totalDeJogosAlugados = aluguel
                .gamer
                .filtraPorMes(aluguel.periodo.dataInicial.monthValue, aluguel.periodo.dataInicial.year)
                .size
            return if (totalDeJogosAlugados < qtdJogosGratis) {
                0.0
            } else {
                calcularValor(super.obterOValor(aluguel), desconto, aluguel)
            }
        }
    },
    OURO(40.0, 4, 0.20) {
        override fun obterOValor(aluguel: Aluguel): Double {
            val totalDeJogosAlugados = aluguel
                .gamer
                .filtraPorMes(aluguel.periodo.dataInicial.monthValue, aluguel.periodo.dataInicial.year)
                .size

            return if (totalDeJogosAlugados < qtdJogosGratis) {
                0.0
            } else {
                calcularValor(super.obterOValor(aluguel), desconto, aluguel)
            }
        }
    };

    fun calcularValor(valorInicial : Double, desconto : Double, aluguel: Aluguel) : Double {
        var valorFinal = valorInicial
        if (aluguel.gamer.media > 8)
            valorFinal = valorInicial - (valorInicial * desconto)
        return valorFinal
    }

    override fun toString(): String {
        return "TiposDePlano(mensalidade=$mensalidade, qtdJogosGratis=$qtdJogosGratis, desconto=$desconto)"
    }
}
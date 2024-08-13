package br.com.gabriel.domain.enums

import br.com.gabriel.domain.entities.Aluguel
import br.com.gabriel.domain.entities.Plano

enum class TiposDePlano(val mensalidade: Double, val jogosGratis : Int) : Plano {

    BRONZE(0.0, 0) {
        override fun obterOValor(aluguel: Aluguel): Double {
            return super.obterOValor(aluguel)
        }
    },
    PRATA(30.0, 2) {
        override fun obterOValor(aluguel: Aluguel): Double {
            val totalDeJogosAlugados = aluguel.gamer.filtraPorMes(aluguel.periodo.dataInicial.monthValue, aluguel.periodo.dataInicial.year).size
            return if (totalDeJogosAlugados < jogosGratis) {
                0.0
            } else {
                super.obterOValor(aluguel)
            }
        }
    },
    OURO(40.0, 4) {
        override fun obterOValor(aluguel: Aluguel): Double {
            val totalDeJogosAlugados = aluguel.gamer.filtraPorMes(aluguel.periodo.dataInicial.monthValue, aluguel.periodo.dataInicial.year).size
            return if (totalDeJogosAlugados < jogosGratis) {
                0.0
            } else {
                super.obterOValor(aluguel)
            }
        }
    }
}
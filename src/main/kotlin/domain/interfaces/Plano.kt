package br.com.gabriel.domain.interfaces

import br.com.gabriel.domain.entities.Aluguel

interface Plano {

    fun obterOValor(aluguel : Aluguel) : Double {
        return aluguel.jogo.preco * aluguel.periodo.emDias
    }
}
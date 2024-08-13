package br.com.gabriel.domain.entities

interface Plano {

    fun obterOValor(aluguel : Aluguel) : Double {
        return aluguel.jogo.preco * aluguel.periodo.emDias
    }
}
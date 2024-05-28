package br.com.gabriel.domain.entities

import java.time.LocalDate
import java.time.Period

data class Periodo(
    val dataInicial: LocalDate,
    val dataFinal: LocalDate
) {
    val emDias = Period.between(this.dataInicial, this.dataFinal).days
}

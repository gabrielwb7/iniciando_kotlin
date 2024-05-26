package br.com.gabriel.domain.utils.extensions

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun String.extrairIdade() : Int {
    val pattern =  DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val dataAtual = LocalDate.now()
    val dataPassada = LocalDate.parse(this, pattern)

    return Period.between(dataPassada, dataAtual).years
}
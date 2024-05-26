package br.com.gabriel.application.services

import java.util.Scanner

class CapturarRespostas {

    fun capturarId(scanner: Scanner): String {

        println("Digite o código do jogo que deseja buscar: ")

        val valorInserido = scanner.nextLine()

        return valorInserido
    }

    fun capturarDescricao(scanner: Scanner): String {

        println("Você deseja inserir uma tag? S/N")
        val valorInserido = scanner.nextLine()

        if(valorInserido.equals("S", true))
            println("Digite a tag: ")
            val tag = scanner.nextLine()

        return tag
    }
}
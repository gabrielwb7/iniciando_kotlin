package br.com.gabriel.domain.entities

import br.com.gabriel.domain.utils.extensions.extrairIdade
import java.util.*
import kotlin.random.Random

data class Gamer(var nome: String, var email: String) {
    var dataNascimento: String? = null
    var idade: Int? = null
    val listaDeJogos = mutableListOf<Jogo?>()
    var apelidoUsuario: String? = null
        set(value) {
            field = value
            if (idUsuario.isNullOrBlank())
                criarIdInterno()
        }
    var idUsuario: String? = null
        private set

    constructor(nome: String, email: String, dataNascimento: String, apelidoUsuario: String)
            : this(nome, email) {
        this.dataNascimento = dataNascimento
        this.apelidoUsuario = apelidoUsuario
        this.idade = dataNascimento.extrairIdade()
        criarIdInterno()
    }

    init {
        if (nome.isBlank())
            throw IllegalArgumentException("Nome nao pode ser em branco")

        this.email = validarEmail()
    }

    companion object {
        fun criarCadastroGamer(leitura: Scanner): Gamer {
            println("Digite o nome: ")
            val nome = leitura.nextLine()

            println("Digite o e-mail: ")
            val email = leitura.nextLine()

            println("Digite a data de nascimento: [dd/mm/yyyy]")
            val dataDeNascimento = leitura.nextLine()

            println("Digite o nome de usuario: ")
            val usuario = leitura.nextLine()

            return Gamer(nome, email, dataDeNascimento, usuario)
        }
    }

    private fun criarIdInterno() {
        val numero = Random.nextInt(10000)
        val tag = String.format("%04d", numero)

        idUsuario = "$apelidoUsuario#$tag"
    }

    private fun validarEmail(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")

        if (!regex.matches(this.email)) {
            throw IllegalArgumentException("Email invalido")
        }

        return this.email
    }

    override fun toString(): String {
        return "Gamer => \n" +
                " nickname=$apelidoUsuario" +
                " username=$idUsuario" +
                " idade=$idade" +
                " games=$listaDeJogos"
    }


}

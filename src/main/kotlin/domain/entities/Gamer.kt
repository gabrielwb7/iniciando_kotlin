package br.com.gabriel.domain.entities

import br.com.gabriel.domain.enums.TiposDePlano
import br.com.gabriel.domain.interfaces.Recomendavel
import br.com.gabriel.domain.utils.extensions.extrairIdade
import br.com.gabriel.domain.utils.extensions.formatoComDuasCasasDecimais
import java.util.*
import kotlin.random.Random

data class Gamer(var nome: String, var email: String) : Recomendavel {
    private var dataNascimento: String? = null
    private var idade: Int? = null
    val listaDeJogos = mutableListOf<Jogo?>()
    private val listaDeAlugueis = mutableListOf<Aluguel?>()
    var plano : TiposDePlano? = null
    private val listaNotas = mutableListOf<Int>()
    val jogosRecomendados = mutableListOf<Jogo>()

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

    fun alugaJogo(jogo: Jogo, periodo: Periodo) : Aluguel {
        val aluguel = Aluguel(this, jogo, periodo)
        this.listaDeAlugueis.add(aluguel)
        return aluguel;
    }

    fun filtraPorMes(mes: Int, year: Int) : List<Aluguel?> {
        return this.listaDeAlugueis.filter {
            it?.periodo?.dataInicial?.monthValue == mes &&  it.periodo.dataInicial.year == year
        }
    }

    fun cadastrarPlano(tipoInformado : String) {
        for (tipo in TiposDePlano.entries) {
            if (tipo.name.equals(tipoInformado, true)) {
                this.plano = tipo
            }
        }
    }

    override val media: Double
        get() = listaNotas.average()

    override fun recomendar(nota: Int) {
        if (nota in 0..10)
            listaNotas.add(nota)
        else
            throw IllegalArgumentException("Nota invalida")
    }

    fun recomendarJogo(jogo: Jogo, nota : Int) {
        jogo.recomendar(nota)
        jogosRecomendados.add(jogo)
    }

    override fun toString(): String {
        return "\n Gamer => \n" +
                " nickname=$apelidoUsuario" +
                " username=$idUsuario" +
                " idade=$idade" +
                " lista de desejo=$listaDeJogos" +
                " lista de alugueis=$listaDeAlugueis" +
                " media=${media.formatoComDuasCasasDecimais()}"
    }


}

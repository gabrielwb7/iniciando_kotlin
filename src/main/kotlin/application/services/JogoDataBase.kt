package br.com.gabriel.application.services

import br.com.gabriel.domain.entities.Jogo
import br.com.gabriel.infra.config.DatabaseConfig
import java.sql.ResultSet

class JogoDataBase {

    fun consultarJogos() : List<Jogo> {
        val listaDeJogos = mutableListOf<Jogo>()
        val conexao = DatabaseConfig.obterConexao()

        if (conexao != null) {
            try {
                val statement = conexao.createStatement()
                val consulta = statement
                    .executeQuery("SELECT * FROM jogos")

                while(consulta.next()) {
                    val dadosFormatados = mapearDados(consulta)

                    listaDeJogos.add(dadosFormatados)
                }

            } finally {
                conexao.close()
            }
        }

        return listaDeJogos
    }

    private fun mapearDados(consulta: ResultSet) : Jogo {
        val id = consulta.getInt("id")
        val titulo = consulta.getString("titulo")
        val capa = consulta.getString("capa")
        val preco = consulta.getDouble("preco")
        val descricao = consulta.getString("descricao")

        return Jogo(titulo, capa, preco, descricao, id)
    }

    fun inserirJogo(jogo: Jogo) {
        val conexao = DatabaseConfig.obterConexao()
        val query = "INSERT INTO jogos(titulo, capa, descricao, preco) VALUES (?, ?, ?, ?)"

        if (conexao != null) {
            try {
                val statement = conexao.prepareStatement(query)
                statement.setString(1, jogo.titulo)
                statement.setString(2, jogo.capa)
                statement.setString(3, jogo.descricao)
                statement.setDouble(4, jogo.preco)

                statement.executeUpdate()
                statement.close()
            } finally {
                conexao.close()
            }
        }
    }
}

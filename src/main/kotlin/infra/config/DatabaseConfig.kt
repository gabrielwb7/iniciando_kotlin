package br.com.gabriel.infra.config

import infra.config.PropertiesLoader
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.util.*

object DatabaseConfig {
    fun obterConexao(): Connection? {
        val properties = PropertiesLoader.loadProperties()
        val nomeDataBase = properties["database"]
        val user = properties["usuario-bd"]
        val senha = properties["senha-bd"]

        return try {
            DriverManager.getConnection("jdbc:mysql://localhost:3306/$nomeDataBase", "$user", "$senha")
        } catch (e: SQLException) {
            e.printStackTrace()
            null
        }
    }
}
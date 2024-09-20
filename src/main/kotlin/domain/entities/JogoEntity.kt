package br.com.gabriel.domain.entities

import javax.persistence.*

@Entity
@Table(name = "jogos")
class JogoEntity(
    val titulo: String = "titulo",
    val capa: String = "capa",
    val preco: Double = 0.0,
    val descricao: String? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0
) {
}
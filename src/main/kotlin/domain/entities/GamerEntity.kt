package br.com.gabriel.domain.entities

import javax.persistence.*

@Entity
@Table(name = "gamer")
class GamerEntity(
    val nome: String = "nome",
    val email: String = "email",
    val dataNascimento: String? = null,
    val usuario:String? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0
) {
}
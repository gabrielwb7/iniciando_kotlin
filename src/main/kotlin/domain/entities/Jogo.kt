package br.com.gabriel.domain.entities

data class Jogo (
    val titulo: String,
    val capa: String,
) {
    var preco:Double = 0.0
    var descricao:String? =  null

    override fun toString(): String {
        return "\n Jogo: " +
                "\n\t titulo='$titulo', \n" +
                "\t capa='$capa', \n" +
                "\t descricao='$descricao'\n" +
                "\t preco='$preco'"
    }


}
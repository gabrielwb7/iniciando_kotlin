package br.com.gabriel.domain.entities

data class Jogo (
    val titulo: String,
    val capa: String
) {
    var tag:String? =  null

    override fun toString(): String {
        return "Jogo: \n" +
                "titulo='$titulo', \n" +
                "capa='$capa', \n" +
                "tag='$tag'"
    }


}
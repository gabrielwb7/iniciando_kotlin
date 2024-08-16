package br.com.gabriel.domain.usecases

import br.com.gabriel.domain.entities.Jogo
import com.google.gson.GsonBuilder
import java.io.File

class CompartilharJsonUsecase {

    fun converterParaJson(listaDeJogos : MutableList<Jogo>) : String {
        val gson = GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()

        return gson.toJson(listaDeJogos)
    }

    fun gerarArquivoJson(json : String, idGamer : String ): File {
        val arquivo = File("D:\\workspaces\\kotlin\\AluGames\\src\\main\\resources\\jsons\\jogos-$idGamer")
        arquivo.writeText(json)
        return arquivo
    }
}
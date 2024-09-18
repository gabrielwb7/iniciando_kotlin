package br.com.gabriel.domain.usecases

import br.com.gabriel.domain.entities.Jogo
import com.google.gson.GsonBuilder
import java.io.File
import java.nio.file.FileSystems

class CompartilharJsonUsecase {

    fun converterParaJson(listaDeJogos : MutableList<Jogo>) : String {
        val gson = GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()

        return gson.toJson(listaDeJogos)
    }

    fun gerarArquivoJson(json : String, idGamer : String ): File {
        val currentDirectoryPath = FileSystems.getDefault().getPath("");
        val currentDirectoryName = currentDirectoryPath.toAbsolutePath().toString();
        val arquivo = File("$currentDirectoryName/src/main/resources/jsons/jogos-$idGamer.json")
        arquivo.writeText(json)
        return arquivo
    }
}
package br.com.gabriel.application.services

import br.com.gabriel.application.dto.InfoApi
import br.com.gabriel.application.dto.InfoGamerJson
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class ConsultaDadosExterno {

    private val gson = Gson()

    fun consultarJogo(id: String): InfoApi {
        val endpoint = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val response = fazerRequisicao(endpoint)

        val infoJogo: InfoApi = gson.fromJson(response, InfoApi::class.java)

        return infoJogo
    }

    fun consultarGamer(): List<InfoGamerJson> {
        val endpoint = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"

        val response = fazerRequisicao(endpoint)

        val tipoListaInfoGamerJson = object : TypeToken<List<InfoGamerJson>>() {}.type
        val infoJogo: List<InfoGamerJson> = gson.fromJson(response, tipoListaInfoGamerJson)

        return infoJogo
    }

    private fun fazerRequisicao(uri : String) : String? {
        val client: HttpClient = HttpClient.newHttpClient()

        val request = HttpRequest.newBuilder()
            .uri(URI.create(uri))
            .build()

        val response = client
            .send(request, BodyHandlers.ofString())

        if (response.body().isEmpty()) {
            throw RuntimeException("nao foi encontrado lista gamer a partir do id informado")
        }

        return response.body()
    }
}
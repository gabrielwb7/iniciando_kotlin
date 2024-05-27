package br.com.gabriel.application.services

import br.com.gabriel.application.dto.InfoGamerJson
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class ConsultarGamer {

    private val gson = Gson()

    fun consultarGamer(): List<InfoGamerJson> {
        val endpoint = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"

        val client: HttpClient = HttpClient.newHttpClient()

        val request = HttpRequest.newBuilder()
            .uri(URI.create(endpoint))
            .build()

        val response = client
            .send(request, BodyHandlers.ofString())

        if (response.body().isEmpty()) {
            throw RuntimeException("nao foi encontrado lista gamer a partir do id informado")
        }

        val tipoListaInfoGamerJson = object : TypeToken<List<InfoGamerJson>>() {}.type
        val infoJogo: List<InfoGamerJson> = gson.fromJson(response.body(), tipoListaInfoGamerJson)

        return infoJogo
    }
}
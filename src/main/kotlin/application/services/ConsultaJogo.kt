package br.com.gabriel.application.services

import br.com.gabriel.domain.dto.InfoApi
import com.google.gson.Gson
import java.lang.RuntimeException
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class ConsultaJogo {

    private val gson = Gson()

    fun consultarJogo(id: String): InfoApi {
        val endpoint = "https://www.cheapshark.com/api/1.0/games"

        val client: HttpClient = HttpClient.newHttpClient()

        val request = HttpRequest.newBuilder()
            .uri(URI.create("$endpoint?id=$id"))
            .build()

        val response = client
            .send(request, BodyHandlers.ofString())

        if (response.body().isEmpty()) {
            throw RuntimeException("nao foi encontrado jogo a partir do id informado")
        }

        val infoJogo: InfoApi = gson.fromJson(response.body(), InfoApi::class.java)

        return infoJogo
    }
}
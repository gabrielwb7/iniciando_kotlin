package br.com.gabriel.services

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class ConsultaJogoService {

    fun consultarJogo(id: Int): String? {
        val endpoint = "https://www.cheapshark.com/api/1.0/games"

        val client: HttpClient = HttpClient.newHttpClient()

        val request = HttpRequest.newBuilder()
            .uri(URI.create("$endpoint?id=$id"))
            .build()

        val response = client
            .send(request, BodyHandlers.ofString())

        return response.body()
    }
}
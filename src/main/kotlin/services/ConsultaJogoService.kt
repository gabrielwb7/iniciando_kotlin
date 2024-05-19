package br.com.gabriel.services

import br.com.gabriel.domain.dto.InfoApi
import br.com.gabriel.domain.entities.Jogo
import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class ConsultaJogoService {

    val gson = Gson()

    fun consultarJogo(id: Int): Jogo? {
        val endpoint = "https://www.cheapshark.com/api/1.0/games"

        val client: HttpClient = HttpClient.newHttpClient()

        val request = HttpRequest.newBuilder()
            .uri(URI.create("$endpoint?id=$id"))
            .build()

        val response = client
            .send(request, BodyHandlers.ofString())

        val infoJogo = gson.fromJson(response.body(), InfoApi::class.java)

        val jogo = Jogo(titulo = infoJogo.info.title, capa =  infoJogo.info.thumb)

        return jogo
    }
}
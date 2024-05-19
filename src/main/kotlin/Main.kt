package br.com.gabriel

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers


fun main() {

    val endpoint = "https://www.cheapshark.com/api/1.0/games"
    val idGame = 146

    val client: HttpClient = HttpClient.newHttpClient()

    val request = HttpRequest.newBuilder()
        .uri(URI.create("$endpoint?id=$idGame"))
        .build()

    val response = client
        .send(request, BodyHandlers.ofString())

    println(response.body())

}
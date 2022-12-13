package app.apps.elbishtranslator.client

import app.apps.elbishtranslator.client.URLS.local
import org.http4k.client.ApacheClient
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Response


object Client {

    private val client = ApacheClient()

    fun get(url: String): Response {
        return client(Request(Method.GET, "$local$url"))
    }

}

object URLS{

    val local = "http://localhost:8080"

    val ready = "/ready"

    val translate = "/translate"

}
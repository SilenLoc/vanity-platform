package app.common.client

import org.http4k.client.ApacheClient
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Response



interface IRestClient{

    fun get(url: String): Response
    fun post(url: String): Response
    fun delete(url: String): Response
    fun put(url: String): Response

}


class RestClient(private val base:String): IRestClient {

    private val client = ApacheClient()


    override fun get(url: String): Response {
        return client(Request(Method.GET, "$base$url"))
    }

    override fun post(url: String): Response {
        throw Exception()
    }

    override fun delete(url: String): Response {
        throw Exception()
    }

    override fun put(url: String): Response {
        throw Exception()
    }

}


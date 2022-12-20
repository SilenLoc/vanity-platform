package app.apps.elbishtranslator.frontend.backingclient

import app.common.client.IRestClient


class ElbishClient(private val client: IRestClient) {

   val maintenance = object: IMaintenance {
       override fun isServerReady() = client.get(URLS.ready).status.successful
   }



}

interface IMaintenance{
    fun isServerReady(): Boolean
}


object URLS {

    val local = "http://localhost:8080"

    val ready = "/ready"

    val translate = "/translate"

}
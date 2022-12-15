package app.apps.elbishtranslator.frontend.init

import app.common.client.RestClient


class InitElbishTrans {

    fun init(baseUrl: String) = ElbishAppContext(RestClient(baseUrl))

}
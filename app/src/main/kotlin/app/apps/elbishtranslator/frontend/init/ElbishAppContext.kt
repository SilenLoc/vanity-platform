package app.apps.elbishtranslator.frontend.init

import app.apps.elbishtranslator.frontend.backingclient.ElbishClient
import app.apps.elbishtranslator.frontend.backingclient.URLS.local
import app.common.client.IRestClient
import vanity.app.results.Unfit
import vanity.app.results.Well
import vanity.app.results.WellOrUnfit
import vanity.app.results.wellOrElse

class ElbishAppContext(restClient: IRestClient) {

    val client: ElbishClient = ElbishClient(restClient)

}

object ElbishApp {

    var context: WellOrUnfit<ElbishAppContext, String> = Unfit("not context yet")

    fun getContext(): ElbishAppContext = context.wellOrElse {
        context = Well(InitElbishTrans().init(local))
        context.wellOrElse { throw Exception("context must have been there") }
    }


}
import app.apps.elbishtranslator.client.Client
import app.apps.elbishtranslator.client.URLS
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import vanity.app.Log
import vanity.app.results.*


class ServerStartup() {


    suspend fun tryStartServer() {
        Log.info { "try connecting" }
        probeServer().onWell {inner ->
            inner.onWell {
                Log.info { it }
            }
        }.onUnfit {
            Log.info { it }
        }

    }

    private var tries = 0
    private suspend fun probeServer(): WellOrUnfit<WellOrUnfit<String, String>, String> {
        var result: WellOrUnfit<WellOrUnfit<String, String>, String> = Unfit("not reachable")

        while (result is Unfit) {
            val response = withContext(Dispatchers.IO) {
                Client.get(URLS.ready)
            }

            if (response.status.successful) {
                result = Well(Well("server ready"))
            }

            if (tries > 10) {
                Log.info { "server not reachable" }
                result = Well(Well("server not reachable"))

            }

            tries++
            delay(3000)
        }

        return result
    }


}


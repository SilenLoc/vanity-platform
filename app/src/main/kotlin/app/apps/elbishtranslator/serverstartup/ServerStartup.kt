import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import vanity.app.Log
import vanity.app.results.*
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ServerStartup(private val serverURL: String) {


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
        val client = HttpClient.newBuilder().build()
        val request = HttpRequest.newBuilder().uri(URI.create(serverURL + "ready")).build()

        var result: WellOrUnfit<WellOrUnfit<String, String>, String> = Unfit("not reachable")

        while (result is Unfit) {
            val response = withContext(Dispatchers.IO) {
                client.send(request, HttpResponse.BodyHandlers.ofString())
            }

            if (response.statusCode() == 200) {
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


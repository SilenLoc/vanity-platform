package app.apps.elbishtranslator.`server-startup`

object ServerStartup {

    private var serverState: ServerState = ServerDown()
    private var serverDownloadState: ServerDownloadState = ServerNotAround()


    suspend fun startServer(path: String) {
        downloadServer(path)



    }

    suspend fun downloadServer(path: String) {
        while (serverDownloadState !is ServerReadyToStart) {
            when (serverDownloadState) {
                is ServerNotAround -> downloadServer()
                is ServerDownloading -> wait()
            }
        }
    }

    private fun downloadServer() {}
    private fun wait() {}


}

interface ServerState

class ServerStarted : ServerState
class ServerReady : ServerState
class ServerDown : ServerState


interface ServerDownloadState

class ServerNotAround : ServerDownloadState
class ServerDownloading : ServerDownloadState
class ServerReadyToStart : ServerDownloadState
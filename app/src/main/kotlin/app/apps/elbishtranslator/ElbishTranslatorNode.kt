package app.apps.elbishtranslator

import ServerStartup
import javafx.scene.control.Button
import javafx.scene.layout.BorderPane
import kotlinx.coroutines.*
import vanity.app.view.javafx.action
import vanity.app.view.javafx.cssBtnGreyAndGreen

@OptIn(DelicateCoroutinesApi::class)
class ElbishTranslatorNode : BorderPane() {

    val startBtn = Button("Start")

    init {
        startBtn.cssBtnGreyAndGreen()
        startBtn.action {
            val serverStartup = ServerStartup( "http://localhost:8080/")

            GlobalScope.launch {
                serverStartup.tryStartServer()
            }
        }
        this.center = startBtn
    }


}
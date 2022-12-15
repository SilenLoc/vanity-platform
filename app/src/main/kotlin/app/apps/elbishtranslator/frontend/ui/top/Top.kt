package app.apps.elbishtranslator.frontend.ui.top

import app.apps.elbishtranslator.frontend.serverstartup.ServerStartup
import javafx.scene.control.Button
import javafx.scene.layout.HBox
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import vanity.app.view.javafx.action
import vanity.app.view.javafx.cssBtnGreyAndGreen

@OptIn(DelicateCoroutinesApi::class)
class Top : HBox() {

    private val startBtn = Button("Is server around")

    init {
        startBtn.cssBtnGreyAndGreen()
        startBtn.action {
            val serverStartup = ServerStartup()

            GlobalScope.launch {
                serverStartup.tryStartServer()
            }
        }
        this.children.addAll(startBtn)
    }


}
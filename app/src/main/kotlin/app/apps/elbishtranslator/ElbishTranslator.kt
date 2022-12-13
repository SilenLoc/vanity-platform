package app.apps.elbishtranslator

import javafx.scene.Node
import javafx.scene.control.Label
import vanity.app.view.platformview.apps.JavaFxApp



val ELBISH_TRANS_SERVER =  "elibsh_trans_server"


class ElbishTranslator: JavaFxApp {

    override val name: String = "Elbish Translator"
    override val node: Node = ElbishTranslatorNode()

}


class ExampleApp(override val name: String) : JavaFxApp {
    override val node: Node = Label(name)
}


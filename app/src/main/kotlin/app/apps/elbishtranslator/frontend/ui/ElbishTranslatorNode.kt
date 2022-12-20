package app.apps.elbishtranslator.frontend.ui

import app.apps.elbishtranslator.frontend.backingclient.URLS.local
import app.apps.elbishtranslator.frontend.init.ElbishApp
import app.apps.elbishtranslator.frontend.init.InitElbishTrans
import app.apps.elbishtranslator.frontend.ui.top.Top
import javafx.scene.layout.BorderPane
import vanity.app.results.Well

class ElbishTranslatorNode : BorderPane() {

    init {
        ElbishApp.context = Well(InitElbishTrans().init(local))
        initView()
    }

    private fun initView() {
        this.top = Top()
    }

}
package vanity.app.apps.services

import vanity.app.IAppService
import vanity.app.JavaFxAppModule
import app.apps.elbishtranslator.ElbishTranslator
import app.apps.elbishtranslator.ExampleApp

class AppService : IAppService {

    override val javaFxAppModules: Collection<JavaFxAppModule>
        get() = listOf(
                JavaFxAppModule(
                        "Fantasy",
                        listOf(
                                ElbishTranslator(),
                                ExampleApp("NameGenerator")
                        )
                ),
                JavaFxAppModule(
                        "Dev",
                        listOf(
                                ExampleApp("Just Just")
                        )
                ),
                JavaFxAppModule(
                        "Dev",
                        listOf(
                                ExampleApp("Just Just")
                        )
                ),
        )

}
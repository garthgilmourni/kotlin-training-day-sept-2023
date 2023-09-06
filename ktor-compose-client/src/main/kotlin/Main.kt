import androidx.compose.runtime.*
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import org.rest.io.buildClient
import org.rest.ui.App


fun main() = application {
    val client = remember { buildClient() }

    Window(
        title = "Examples of the Ktor HTTP Client",
        onCloseRequest = ::exitApplication,
        state = rememberWindowState(
            size = DpSize(600.dp, 500.dp),
            position = WindowPosition(100.dp, 100.dp)
        )
    ) {
        App(client)
    }
}

package corp.wmsoft.drawcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import corp.wmsoft.apolo.Apollo

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Apollo()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    Apollo()
}
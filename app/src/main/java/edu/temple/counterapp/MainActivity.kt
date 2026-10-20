package edu.temple.counterapp
import androidx.compose.ui.unit.sp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import edu.temple.counterapp.ui.theme.CounterAppTheme
import kotlin.getValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val counterViewModel by viewModels <CounterViewModel>()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CounterAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Counter(
                        counterViewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Counter(viewModel: CounterViewModel, modifier: Modifier = Modifier) {
    //by column we r editing how the button text is viewd on the screen
    var counterValue by rememberSaveable() { mutableIntStateOf(0) }
    Column(modifier= Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
    Button(onClick  = {
        viewModel.counterValue.intValue++
    }) {
        Text("Increase")}
    Text(
        text = viewModel.counterValue.intValue.toString(),
        fontSize =56.sp,
        modifier = modifier
    )
    Button(onClick = {
        if (viewModel.counterValue.intValue>0){
            viewModel.counterValue.intValue--
                }}) { Text("Decrease")}
}
}


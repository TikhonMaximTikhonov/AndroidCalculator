package ru.pechenka.androidcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import ru.pechenka.androidcalculator.viewmodels.main.CalculationViewModel
import ru.pechenka.androidcalculator.views.main.MainScreen
import ru.pechenka.androidcalculator.views.ui.theme.AndroidCalculatorTheme

val viewModel = CalculationViewModel()

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val displayHeight = baseContext.resources.displayMetrics.heightPixels
        val displayWidth = baseContext.resources.displayMetrics.widthPixels

        setContent {
            if (viewModel.state.darkTheme == 2) {
                viewModel.state = viewModel.state.copy(
                    darkTheme = if (isSystemInDarkTheme()) 1
                    else 0
                )
            }
            AndroidCalculatorTheme(viewModel.state.darkTheme == 1) {
                MainScreen(displayHeight, displayWidth, viewModel)
            }
        }
    }
}

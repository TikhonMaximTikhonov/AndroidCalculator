package ru.pechenka.androidcalculator.viewmodels.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import ru.pechenka.androidcalculator.models.main.CalculationState
import ru.pechenka.androidcalculator.models.main.CalculationAction
import ru.pechenka.androidcalculator.models.main.CalculationOperation

class CalculationViewModel : ViewModel() {
    var state by mutableStateOf(CalculationState())

    fun onAction(action: CalculationAction) {
        when (action) {
            is CalculationAction.Number -> enterNumber(action.number)
            is CalculationAction.Decimal -> enterDecimal()
            is CalculationAction.Operation -> enterOperation(action.operation)
            is CalculationAction.Calculate -> calculate()
            is CalculationAction.Delete -> delete()
            is CalculationAction.Clear -> state = CalculationState()
            is CalculationAction.Theme -> theme()
        }
    }

    private fun enterNumber(number: String) {
        if (state.number1 != "Error") {
            state = if (state.number1 == "0") {
                state.copy(number1 = number)
            } else {
                state.copy(number1 = state.number1 + number)
            }
        }
    }

    private fun enterDecimal() {
        if (state.number1 != "Error") {
            state = state.copy(number1 = state.number1 + ".")
        }
    }

    private fun enterOperation(operation: CalculationOperation) {
        if (state.number1 != "Error") {
            if (state.number1 != "0") {
                if (state.operation != CalculationOperation.None) {
                    calculate()
                }
                state = state.copy(
                    number1 = "0",
                    number2 = state.number1,
                    operation = operation
                )
            }
        }
    }

    private fun calculate() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()

        if (number1 != null && number2 != null) {
            var result = when (state.operation) {
                is CalculationOperation.Add -> number2 + number1
                is CalculationOperation.Subtract -> number2 - number1
                is CalculationOperation.Multiply -> number2 * number1
                is CalculationOperation.Divide ->
                    if (number1 != 0.0) number2 / number1
                    else "Error"
                is CalculationOperation.None -> return
            }.toString().take(15)

            while (
                "." in result &&
                (result[result.length - 1] == '0' || result[result.length - 1] == '.')
            ) {
                result = result.slice(0..<result.length-1)
            }

            state = state.copy(
                number1 = result,
                number2 = "",
                operation = CalculationOperation.None
            )
        }
    }

    private fun delete() {
        if (state.number1 != "Error") {
            when {
                state.number1 != "0" ->
                    state = if (state.number1.length != 1) {
                        state.copy(number1 = state.number1.dropLast(1))
                    } else {
                        state.copy(number1 = "0")
                    }

                state.operation != CalculationOperation.None ->
                    state = state.copy(
                        number1 = state.number2,
                        number2 = "",
                        operation = CalculationOperation.None
                    )

            }
        }
    }

    private fun theme() {
        state = if (state.darkTheme == 1) {
            state.copy(darkTheme = 0)
        } else {
            state.copy(darkTheme = 1)
        }
    }
}
package ru.pechenka.androidcalculator.models.main

import androidx.compose.foundation.isSystemInDarkTheme

data class CalculationState(
    val number1: String = "0",
    val number2: String = "",
    val operation: CalculationOperation = CalculationOperation.None,
    val darkTheme: Int = 2
)

sealed class CalculationAction {
    data class Number(val number: String): CalculationAction()
    data object Clear: CalculationAction()
    data object Delete: CalculationAction()
    data class Operation(val operation: CalculationOperation): CalculationAction()
    data object Calculate: CalculationAction()
    data object Decimal: CalculationAction()
    data object Theme: CalculationAction()
}

sealed class CalculationOperation(val symbol: String) {
    data object None: CalculationOperation("")
    data object Add: CalculationOperation("+")
    data object Subtract: CalculationOperation("-")
    data object Multiply: CalculationOperation("x")
    data object Divide: CalculationOperation("/")
}

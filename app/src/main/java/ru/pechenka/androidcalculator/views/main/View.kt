package ru.pechenka.androidcalculator.views.main

import android.view.View
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat.recreate
import ru.pechenka.androidcalculator.models.main.CalculationAction
import ru.pechenka.androidcalculator.models.main.CalculationOperation
import ru.pechenka.androidcalculator.viewmodels.main.CalculationViewModel
import ru.pechenka.androidcalculator.views.ui.components.NumberButton
import ru.pechenka.androidcalculator.views.ui.components.OperationButton
import ru.pechenka.androidcalculator.views.ui.components.SwitchButton
import ru.pechenka.androidcalculator.views.ui.theme.AndroidCalculatorTheme

@Composable
fun HorizontalView(
    viewModel: CalculationViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .fillMaxWidth()
                .height(260.dp)
                .background(
                    MaterialTheme.colorScheme.secondary,
                    RoundedCornerShape(16.dp)
                )
                .border(
                    2.dp,
                    MaterialTheme.colorScheme.onSecondary,
                    shape = RoundedCornerShape(16.dp)
                )
                .clip(RoundedCornerShape(16.dp))
        ) {
            SwitchButton(
                isChecked = viewModel.state.darkTheme == 1
            ) {
                viewModel.onAction(CalculationAction.Theme)
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 8.dp)
                    .align(Alignment.BottomEnd)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = viewModel.state.number2 + viewModel.state.operation.symbol,
                    textAlign = TextAlign.End,
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.titleLarge,
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = viewModel.state.number1,
                    textAlign = TextAlign.End,
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }

        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
        ) {
            val elementMargin = 16.dp
            val elementWidth = (this.maxWidth - elementMargin * 3) / 4
            val elementHeight = (this.maxHeight - elementMargin * 4) / 5
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(elementMargin)

            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(elementMargin)
                ) {
                    OperationButton(
                        Modifier.size(elementWidth * 2 + elementMargin, elementHeight),
                        text = "C"
                    ) {
                        viewModel.onAction(CalculationAction.Clear)
                    }

                    OperationButton(
                        Modifier.size(elementWidth, elementHeight),
                        text = "CE"
                    ) {
                        viewModel.onAction(CalculationAction.Delete)
                    }

                    OperationButton(
                        Modifier.size(elementWidth, elementHeight),
                        text = "/"
                    ) {
                        viewModel.onAction(CalculationAction.Operation(
                            CalculationOperation.Divide
                        ))
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(elementMargin)
                ) {
                    NumberButton(
                        Modifier.size(elementWidth, elementHeight),
                        text = "7"
                    ) {
                        viewModel.onAction(CalculationAction.Number("7"))
                    }

                    NumberButton(
                        Modifier.size(elementWidth, elementHeight),
                        text = "8"
                    ) {
                        viewModel.onAction(CalculationAction.Number("8"))
                    }

                    NumberButton(
                        Modifier.size(elementWidth, elementHeight),
                        text = "9"
                    ) {
                        viewModel.onAction(CalculationAction.Number("9"))
                    }

                    OperationButton(
                        Modifier.size(elementWidth, elementHeight),
                        text = "*"
                    ) {
                        viewModel.onAction(CalculationAction.Operation(
                            CalculationOperation.Multiply
                        ))
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(elementMargin)
                ) {
                    NumberButton(
                        Modifier.size(elementWidth, elementHeight),
                        text = "4"
                    ) {
                        viewModel.onAction(CalculationAction.Number("4"))
                    }

                    NumberButton(
                        Modifier.size(elementWidth, elementHeight),
                        text = "5"
                    ) {
                        viewModel.onAction(CalculationAction.Number("5"))
                    }

                    NumberButton(
                        Modifier.size(elementWidth, elementHeight),
                        text = "6"
                    ) {
                        viewModel.onAction(CalculationAction.Number("6"))
                    }

                    OperationButton(
                        Modifier.size(elementWidth, elementHeight),
                        text = "-"
                    ) {
                        viewModel.onAction(CalculationAction.Operation(
                            CalculationOperation.Subtract
                        ))
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(elementMargin)
                ) {
                    NumberButton(
                        Modifier.size(elementWidth, elementHeight),
                        text = "1"
                    ) {
                        viewModel.onAction(CalculationAction.Number("1"))
                    }

                    NumberButton(
                        Modifier.size(elementWidth, elementHeight),
                        text = "2"
                    ) {
                        viewModel.onAction(CalculationAction.Number("2"))
                    }

                    NumberButton(
                        Modifier.size(elementWidth, elementHeight),
                        text = "3"
                    ) {
                        viewModel.onAction(CalculationAction.Number("3"))
                    }

                    OperationButton(
                        Modifier.size(elementWidth, elementHeight),
                        text = "+"
                    ) {
                        viewModel.onAction(CalculationAction.Operation(
                            CalculationOperation.Add
                        ))
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(elementMargin)
                ) {
                    NumberButton(
                        Modifier.size(elementWidth * 2 + elementMargin, elementHeight),
                        text = "0"
                    ) {
                        viewModel.onAction(CalculationAction.Number("0"))
                    }

                    NumberButton(
                        Modifier.size(elementWidth, elementHeight),
                        text = "."
                    ) {
                        viewModel.onAction(CalculationAction.Decimal)
                    }

                    OperationButton(
                        Modifier.size(elementWidth, elementHeight),
                        text = "="
                    ) {
                        viewModel.onAction(CalculationAction.Calculate)
                    }
                }
            }
        }
    }
}

@Composable
fun VerticalView(
    viewModel: CalculationViewModel
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .fillMaxHeight()
                .width(260.dp)
                .background(
                    MaterialTheme.colorScheme.secondary,
                    RoundedCornerShape(16.dp)
                )
                .border(
                    2.dp,
                    MaterialTheme.colorScheme.onSecondary,
                    shape = RoundedCornerShape(16.dp)
                )
                .clip(RoundedCornerShape(16.dp))
        ) {
            SwitchButton(
                isChecked = viewModel.state.darkTheme == 1
            ) {
                viewModel.onAction(CalculationAction.Theme)
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 8.dp)
                    .align(Alignment.BottomEnd)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = viewModel.state.number2 + viewModel.state.operation.symbol,
                    textAlign = TextAlign.End,
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.titleLarge,
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = viewModel.state.number1,
                    textAlign = TextAlign.End,
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }

        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp, end = 16.dp, bottom = 16.dp)
        ) {
            val elementMargin = 8.dp
            val elementWidth = (this.maxWidth - elementMargin * 4) / 5
            val elementHeight = (this.maxHeight - elementMargin * 3) / 4
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.spacedBy(elementMargin)

            ) {
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.spacedBy(elementMargin)
                ) {
                    OperationButton(
                        Modifier.size(elementWidth, elementHeight),
                        text = "/"
                    ) {
                        viewModel.onAction(CalculationAction.Operation(
                            CalculationOperation.Divide
                        ))
                    }

                    OperationButton(
                        Modifier.size(elementWidth, elementHeight),
                        text = "CE"
                    ) {
                        viewModel.onAction(CalculationAction.Delete)
                    }

                    OperationButton(
                        Modifier.size(elementWidth, elementHeight * 2 + elementMargin),
                        text = "C"
                    ) {
                        viewModel.onAction(CalculationAction.Clear)
                    }
                }

                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.spacedBy(elementMargin)
                ) {
                    OperationButton(
                        Modifier.size(elementWidth, elementHeight),
                        text = "*"
                    ) {
                        viewModel.onAction(CalculationAction.Operation(
                            CalculationOperation.Multiply
                        ))
                    }

                    NumberButton(
                        Modifier.size(elementWidth, elementHeight),
                        text = "3"
                    ) {
                        viewModel.onAction(CalculationAction.Number("3"))
                    }

                    NumberButton(
                        Modifier.size(elementWidth, elementHeight),
                        text = "2"
                    ) {
                        viewModel.onAction(CalculationAction.Number("2"))
                    }

                    NumberButton(
                        Modifier.size(elementWidth, elementHeight),
                        text = "1"
                    ) {
                        viewModel.onAction(CalculationAction.Number("1"))
                    }
                }

                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.spacedBy(elementMargin)
                ) {
                    OperationButton(
                        Modifier.size(elementWidth, elementHeight),
                        text = "-"
                    ) {
                        viewModel.onAction(CalculationAction.Operation(
                            CalculationOperation.Subtract
                        ))
                    }

                    NumberButton(
                        Modifier.size(elementWidth, elementHeight),
                        text = "6"
                    ) {
                        viewModel.onAction(CalculationAction.Number("6"))
                    }

                    NumberButton(
                        Modifier.size(elementWidth, elementHeight),
                        text = "5"
                    ) {
                        viewModel.onAction(CalculationAction.Number("5"))
                    }

                    NumberButton(
                        Modifier.size(elementWidth, elementHeight),
                        text = "4"
                    ) {
                        viewModel.onAction(CalculationAction.Number("4"))
                    }
                }

                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.spacedBy(elementMargin)
                ) {
                    OperationButton(
                        Modifier.size(elementWidth, elementHeight),
                        text = "+"
                    ) {
                        viewModel.onAction(CalculationAction.Operation(
                            CalculationOperation.Add
                        ))
                    }

                    NumberButton(
                        Modifier.size(elementWidth, elementHeight),
                        text = "9"
                    ) {
                        viewModel.onAction(CalculationAction.Number("9"))
                    }

                    NumberButton(
                        Modifier.size(elementWidth, elementHeight),
                        text = "8"
                    ) {
                        viewModel.onAction(CalculationAction.Number("8"))
                    }

                    NumberButton(
                        Modifier.size(elementWidth, elementHeight),
                        text = "7"
                    ) {
                        viewModel.onAction(CalculationAction.Number("7"))
                    }
                }

                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.spacedBy(elementMargin)
                ) {
                    OperationButton(
                        Modifier.size(elementWidth, elementHeight),
                        text = "="
                    ) {
                        viewModel.onAction(CalculationAction.Calculate)
                    }

                    NumberButton(
                        Modifier.size(elementWidth, elementHeight),
                        text = "."
                    ) {
                        viewModel.onAction(CalculationAction.Decimal)
                    }

                    NumberButton(
                        Modifier.size(elementWidth, elementHeight * 2 + elementMargin),
                        text = "0"
                    ) {
                        viewModel.onAction(CalculationAction.Number("0"))
                    }
                }
            }
        }
    }
}

@Composable
fun MainScreen(
    displayHeight: Int,
    displayWidth: Int,
    viewModel: CalculationViewModel
) {
    if (displayHeight > displayWidth) {
        HorizontalView(viewModel)
    } else {
        VerticalView(viewModel)
    }
}

// Tests

@Preview()
@Composable
private fun ShowLightMainScreen() {
    val viewModel = CalculationViewModel()
    viewModel.state = viewModel.state.copy(darkTheme = 0)
    AndroidCalculatorTheme(false) {
        MainScreen(1, 0, viewModel)
    }
}

@Preview()
@Composable
private fun ShowDarkMainScreen() {
    val viewModel = CalculationViewModel()
    viewModel.state = viewModel.state.copy(darkTheme = 1)

    AndroidCalculatorTheme(true) {
        MainScreen(1, 0, viewModel)
    }
}
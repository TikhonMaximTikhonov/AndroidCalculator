package ru.pechenka.androidcalculator.views.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import ru.pechenka.androidcalculator.R

@Composable
fun SwitchButton(
    modifier: Modifier = Modifier,
    isChecked: Boolean = false,
    onValueChange: (Boolean) -> Unit
) {
    val iconId = if (isChecked)
        R.drawable.ic_day
    else
        R.drawable.ic_moon

    Icon(
        modifier = modifier
            .size(56.dp)
            .padding(8.dp)
            .background(MaterialTheme.colorScheme.secondary)
            .clip(CircleShape)
            .clickable(
                onClick = {
                    onValueChange.invoke(!isChecked)
                }
            ),
        imageVector = ImageVector.vectorResource(id = iconId),
        contentDescription = ""
    )
}
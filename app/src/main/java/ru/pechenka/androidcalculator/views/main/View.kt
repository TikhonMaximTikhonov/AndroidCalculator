package ru.pechenka.androidcalculator.views.main

import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme

@Composable
fun View() {
    val scrollState = false

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {}
}

@Composable
fun MainScreen() {
    View(

    )
}
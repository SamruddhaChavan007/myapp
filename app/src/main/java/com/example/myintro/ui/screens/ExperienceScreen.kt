package com.example.myintro.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.myintro.learning.SCurveStatic

@Composable
fun ExperienceScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        SCurveStatic()
        Column(modifier = Modifier
            .fillMaxWidth()
            .weight(0.65f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Experience Screen")
        }
        //Spacer(modifier = Modifier.weight(1.0f))
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ){
            SCurveStatic(fillBelowCurve = true)
        }
    }
}
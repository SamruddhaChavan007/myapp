package com.example.myintro.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myintro.R
import com.example.myintro.learning.SCurveStatic
import com.example.myintro.ui.theme.PacificoFontFamily

@Composable
fun EducationScreen() {


    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
        ) {
            SCurveStatic()
        }

        Box(
            modifier = Modifier.align(Alignment.Center)
        ) {
            Image(
                painter = painterResource(R.drawable.university_background),
                contentDescription = "Linkedin",
                alpha = 0.3f
                //modifier = Modifier
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
            SCurveStatic(fillBelowCurve = true)
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.School,
                    contentDescription = "School",
                    tint = Color(0xffeba05f),
                    modifier = Modifier.size(60.dp)
                )
                Spacer(Modifier.width(6.dp))
                Text(
                    text = "Education History",
                    fontFamily = PacificoFontFamily,
                    fontSize = 40.sp,
                    color = Color(0xffeba05f)
                )
            }
            Spacer(Modifier.height(10.dp))
            Column {
                Text("Arizona State University")
                Text("Master's in Information Technology")
            }
        }       //Main Column
    }           //Background Box
}
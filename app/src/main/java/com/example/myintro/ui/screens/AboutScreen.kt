package com.example.myintro.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myintro.R
import com.example.myintro.learning.SCurveStatic
import com.example.myintro.ui.theme.GeorgiaFontFamily
import com.example.myintro.ui.theme.PacificoFontFamily
import com.example.myintro.ui.theme.RobotoFontFamily
import com.example.myintro.utils.AppLinks

@Composable
fun AboutScreen() {

    val uriHandler = LocalUriHandler.current

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
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
            SCurveStatic(fillBelowCurve = true)
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .border(
                        width = 3.dp,
                        color = Color(0xFF000000).copy(alpha = 0.6f),
                        shape = CircleShape
                    )
            ) {
                Image(
                    painter = painterResource(R.drawable.profile_pic),
                    contentDescription = "Profile Image"
                )
            }
            Spacer(Modifier.height(10.dp))
            Text(
                text = "About Me",
                fontFamily = PacificoFontFamily,
                fontSize = 40.sp,
                color = Color(0xffeba05f)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.LocationOn,
                    contentDescription = "Location",
                    modifier = Modifier.size(20.dp)
                )
                Spacer(Modifier.width(2.dp))
                Text(
                    text = "Santa Clara, California",
                    fontFamily = RobotoFontFamily,
                    fontSize = 20.sp
                )
            }   //Location Row
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 8.dp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(30.dp),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Professional Summary",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = GeorgiaFontFamily,
                    )
                    Text(
                        text = """
                Mobile Software Engineer (Android & iOS) with 2+ years of experience 
                building scalable, high performance apps using Kotlin, SwiftUI, and 
                Jetpack Compose. Skilled in MVVM, RESTful APIs, AWS, and CI/CD with 
                expertise in performance optimization, clean architecture, and 
                cross-functional collaboration.
            """
                            .trimIndent()
                            .replace("\n", " "),
                        fontSize = 14.sp,
                        lineHeight = 16.sp,
                        softWrap = true,
                    )
                }
            }    //Elevated Card
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.linkedin_icon),
                    contentDescription = "Linkedin",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable{
                            uriHandler.openUri(AppLinks.LINKEDIN_URL)
                        },
                )
                Spacer(Modifier.width(58.dp))
                Image(
                    painter = painterResource(R.drawable.github_icon),
                    contentDescription = "Github",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable{
                            uriHandler.openUri(AppLinks.GITHUB_URL)
                        },
                )
                Spacer(Modifier.width(58.dp))
                Image(
                    painter = painterResource(R.drawable.gmail_logo),
                    contentDescription = "Gmail",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable{
                            uriHandler.openUri(AppLinks.EMAIL_MAILTO)
                        }
                )
            }   //Icon Row
        }       //Main Column
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun PreviewAboutScreen() {
    AboutScreen()
}
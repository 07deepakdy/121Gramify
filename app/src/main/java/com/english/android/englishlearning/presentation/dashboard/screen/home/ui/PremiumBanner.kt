package com.english.android.englishlearning.presentation.dashboard.screen.home.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.english.android.englishlearning.R

@Composable
fun PremiumBanner() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1A237E))
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            // Background Image/Illustration
            Image(
                painter = painterResource(id = R.drawable.daily_practice), // Placeholder
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(200.dp)
                    .align(Alignment.CenterEnd),
                contentScale = ContentScale.Crop,
                alpha = 0.5f
            )

            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(0.7f)
            ) {
                Text(
                    text = "Unlock Premium Grammar",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    lineHeight = 24.sp
                )

                Spacer(Modifier.height(8.dp))

                Text(
                    text = "Get access to 500+ advanced lessons and native feedback.",
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 14.sp,
                    lineHeight = 18.sp
                )

                Spacer(Modifier.height(16.dp))

                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "Get Started",
                        color = Color(0xFF1A237E),
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

package com.english.android.englishlearning.presentation.dashboard.screen.dictionary.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class TrendingWord(
    val rank: Int,
    val word: String,
    val meaning: String,
    val bgColor: Color
)

@Composable
fun TrendingSection() {
    val trendingWords = listOf(
        TrendingWord(1, "Ubiquitous", "Seen everywhere", Color(0xFFE8EAF6)),
        TrendingWord(2, "Pragmatic", "Practical results", Color(0xFFE0F2F1)),
        TrendingWord(3, "Ephemeral", "Lasting briefly", Color(0xFFFFF3E0)),
        TrendingWord(4, "Eloquent", "Fluent expression", Color(0xFFF3E5F5)),
        TrendingWord(5, "Resilient", "Quick recovery", Color(0xFFE1F5FE))
    )

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Trending Now",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            TextButton(onClick = { }) {
                Text("View All", color = Color(0xFF1A1C7E))
            }
        }

        Spacer(Modifier.height(12.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(start = 4.dp, end = 4.dp, bottom = 16.dp)
        ) {
            items(trendingWords) { trending ->
                TrendingCard(trending)
            }
        }
    }
}

@Composable
fun TrendingCard(trending: TrendingWord) {
    Card(
        modifier = Modifier
            .width(180.dp)
            .height(120.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = trending.bgColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "#${trending.rank} Trending",
                fontSize = 12.sp,
                color = Color.Gray
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = trending.word,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1A1C7E)
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = trending.meaning,
                fontSize = 12.sp,
                color = Color.DarkGray
            )
        }
    }
}

package com.english.android.englishlearning.presentation.dashboard.screen.grammar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.english.android.englishlearning.presentation.dashboard.screen.grammar.ui.GrammarMasteryCard
import com.english.android.englishlearning.presentation.dashboard.screen.grammar.ui.GrammarRule
import com.english.android.englishlearning.presentation.dashboard.screen.grammar.ui.GrammarRuleCard
import com.english.android.englishlearning.presentation.dashboard.screen.grammar.ui.RuleStatus
import com.english.android.englishlearning.ui.theme.AppTheme

@Composable
fun GrammarScreen() {
    var searchQuery by remember { mutableStateOf("") }
    var selectedFilter by remember { mutableStateOf("All") }
    
    val filters = listOf("All", "Verbs", "Nouns", "Articles")
    
    val rules = listOf(
        GrammarRule(
            id = 1,
            title = "Subject-Verb Agreement",
            description = "The basic rule states that a singular subject takes a singular verb, while a plural subject...",
            status = RuleStatus.MASTERED,
            completionDate = "May 12",
            accentColor = Color(0xFFFFD54F)
        ),
        GrammarRule(
            id = 2,
            title = "Present Perfect Tense",
            description = "Used for actions that started in the past and continue to the present, or actions performed...",
            status = RuleStatus.IN_PROGRESS,
            progress = 0.4f,
            accentColor = Color(0xFF1A1C7E)
        ),
        GrammarRule(
            id = 3,
            title = "Comma Splices",
            description = "A comma splice occurs when two independent clauses are connected with only a comma...",
            status = RuleStatus.NOT_STARTED,
            duration = "5 min lesson",
            accentColor = Color.LightGray
        ),
        GrammarRule(
            id = 4,
            title = "Modal Auxiliaries",
            description = "Understanding the nuances between 'can', 'could', 'may', and 'might' in formal and inform...",
            status = RuleStatus.NOT_STARTED,
            duration = "8 min lesson",
            accentColor = Color.LightGray
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F8F8))
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Mastery Card
            item {
                GrammarMasteryCard()
            }

            // Search Bar
            item {
                SearchBar(
                    query = searchQuery,
                    onQueryChange = { searchQuery = it }
                )
            }

            // Filters
            item {
                FilterSection(
                    filters = filters,
                    selectedFilter = selectedFilter,
                    onFilterSelected = { selectedFilter = it }
                )
            }

            // Rules List
            items(rules) { rule ->
                GrammarRuleCard(rule = rule)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit
) {
    OutlinedTextField(
        value = query,
        onValueChange = onQueryChange,
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text("Search rules or categories...", color = Color.Gray) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = Color(0xFF1A1C7E)
            )
        },
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFF5F5F5),
            unfocusedContainerColor = Color(0xFFF5F5F5),
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent
        ),
        singleLine = true
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterSection(
    filters: List<String>,
    selectedFilter: String,
    onFilterSelected: (String) -> Unit
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(filters) { filter ->
            val isSelected = filter == selectedFilter
            FilterChip(
                selected = isSelected,
                onClick = { onFilterSelected(filter) },
                label = {
                    Text(
                        text = filter,
                        modifier = Modifier.padding(horizontal = 8.dp),
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                    )
                },
                shape = RoundedCornerShape(20.dp),
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = Color(0xFF000080),
                    selectedLabelColor = Color.White,
                    containerColor = Color(0xFFE0E0E0),
                    labelColor = Color.Gray
                ),
                border = null
            )
        }
    }
}

@Preview(
    name = "Grammar Mastery",
    showBackground = true,
    device = Devices.PIXEL_7
)
@Composable
fun GrammarScreenPreview() {
    AppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFF8F8F8)
        ) {
            GrammarScreen()
        }
    }
}

package com.english.android.englishlearning.presentation.dashboard


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.english.android.englishlearning.R
import com.english.android.englishlearning.presentation.dashboard.screen.dictionary.DictionaryScreen
import com.english.android.englishlearning.presentation.dashboard.screen.grammar.GrammarScreen
import com.english.android.englishlearning.presentation.dashboard.screen.home.ui.HomeRoute
import com.english.android.englishlearning.presentation.dashboard.utils.DashboardDestination
import com.english.android.englishlearning.presentation.dashboard.screen.profile.ProfileScreen

@Composable
fun DashboardScreen() {

    val dashboardNavController = rememberNavController()
    // Observe navigation state
    val backStackEntry by dashboardNavController.currentBackStackEntryAsState()
    val currentRoute by remember {
        derivedStateOf {
            backStackEntry?.destination?.route
        }
    }


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(0xFFF8F8F8),

        topBar = {
            DashboardTopBar(
                onMenuClick = {},
                onSearchClick = {}
            )
        },

        bottomBar = {
            BottomNavigationBar(
                navController = dashboardNavController,
                currentRoute = currentRoute
            )
        },
        
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                containerColor = Color(0xFF1A237E),
                contentColor = Color.White,
                shape = RoundedCornerShape(12.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.article_24px), // Using article icon as placeholder for edit/pen
                    contentDescription = "Edit",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    ) { paddingValues ->

        DashboardNavHost(
            navController = dashboardNavController,
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Composable
fun DashboardTopBar(
    onMenuClick: () -> Unit,
    onSearchClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .statusBarsPadding()
            .padding(
                start = 12.dp,
                end = 12.dp,
                top = 12.dp,
                bottom = 12.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {

        IconButton(
            onClick = onMenuClick
        ) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",
                tint = Color(0xFF1A1C7E)
            )
        }

        Text(
            text = "LinguistCore",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1A1C7E),
            modifier = Modifier.weight(1f)
        )

        IconButton(
            onClick = onSearchClick
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = Color(0xFF1A1C7E)
            )
        }
    }
}

@Composable
fun DashboardNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DashboardDestination.Home.route,
        modifier = modifier
    ) {

        composable(DashboardDestination.Home.route) {
            HomeRoute(
                navController = navController
            )
        }

        composable(DashboardDestination.Grammar.route) {
            GrammarScreen()
        }

        composable(DashboardDestination.Dictionary.route) {
            DictionaryScreen()
        }

        composable(DashboardDestination.Profile.route) {
            ProfileScreen()
        }
    }
}




@Composable
fun BottomNavigationBar(
    navController: NavHostController,
    currentRoute: String?
) {

    NavigationBar(
        containerColor = Color.White,
        tonalElevation = 8.dp
    ) {

        DashboardDestination.items.forEach { destination ->

            NavigationBarItem(
                selected = currentRoute == destination.route,

                onClick = {
                    navController.navigate(destination.route) {
                        launchSingleTop = true
                        restoreState = true

                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                    }
                },

                icon = {
                    Icon(
                        painter = painterResource(destination.iconRes),
                        contentDescription = destination.label,
                        modifier = Modifier.size(24.dp)
                    )
                },

                label = {
                    Text(
                        text = destination.label,
                        fontSize = 12.sp
                    )
                },

                alwaysShowLabel = true,

                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF1A1C7E),
                    selectedTextColor = Color(0xFF1A1C7E),

                    unselectedIconColor = Color.Gray,
                    unselectedTextColor = Color.Gray,

                    indicatorColor = Color(0xFFDDEBF8)
                )
            )
        }
    }
}

package com.english.android.englishlearning

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.english.android.englishlearning.presentation.navigation.AppNavHost
import com.english.android.englishlearning.ui.theme.AppTheme
import com.english.android.englishlearning.utils.AuthViewModelFactory
import com.english.android.englishlearning.presentation.login.LoginViewModel
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()

        val result = FirebaseApp.initializeApp(this)

        //  Get ViewModel
        val viewModel = ViewModelProvider(
            this,
            AuthViewModelFactory(this)
        )[LoginViewModel::class.java]

        setContent {
            AppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   // ThemeColorPreview()

                    val  navController = rememberNavController()
                    AppNavHost(navController = navController, authViewModel = viewModel)
                }
            }
        }
    }


    @Composable
    fun MainScreenPreview() {
     AppTheme {
         Surface(
             modifier = Modifier.fillMaxSize(),
             color = MaterialTheme.colorScheme.background
         ) {
             // Replace with your actual main screen composable

         }
     }
 }
}



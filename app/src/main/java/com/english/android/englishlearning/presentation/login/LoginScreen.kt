package com.english.android.englishlearning.presentation.login

import  android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.english.android.englishlearning.R
import com.english.android.englishlearning.ui.theme.AppTheme
import com.english.android.englishlearning.presentation.navigation.Screen
import com.english.android.englishlearning.presentation.signup.SignInResult



@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
    onLoginSuccess: () -> Unit,
    onEmailClick: () -> Unit,
    navController: NavController
) {
    val activity = LocalContext.current as Activity

    AppTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            WelcomeScreen(
                viewModel = viewModel,
                activity = activity,
                onLoginSuccess = onLoginSuccess,
                navController = navController

            )
        }
    }
}


@Composable
fun WelcomeScreen(
    viewModel: LoginViewModel,
    activity: Activity?,
    onLoginSuccess: () -> Unit,
    navController: NavController
) {
    val context = LocalContext.current
    val signInResult by viewModel.signInResult.collectAsState()

    WelcomeContent(
        onGoogleSignInClick = {
            activity?.let { viewModel.launchGoogleSignIn(it) }
        },
        onEmailClick = {
            navController.navigate(Screen.SignUp.route)
        }
    )

    // ✅ SIDE-EFFECT HANDLING
    LaunchedEffect(signInResult) {
        when (signInResult) {
            is SignInResult.Success -> {
                val userName =
                    (signInResult as SignInResult.Success).user?.displayName

                Toast
                    .makeText(
                        context,
                        "Welcome, ${userName ?: "User"}",
                        Toast.LENGTH_SHORT
                    )
                    .show()

                onLoginSuccess()
                viewModel.clearSignInResult()
            }

            is SignInResult.Error -> {
                Toast
                    .makeText(
                        context,
                        (signInResult as SignInResult.Error)
                            .exception.message ?: "Login failed",
                        Toast.LENGTH_LONG
                    )
                    .show()

                viewModel.clearSignInResult()
            }

            else -> Unit
        }
    }
}


@Composable
fun WelcomeContent(
    onGoogleSignInClick: () -> Unit,
    onEmailClick: () -> Unit
)  {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        LottieWelcomeAnimation(modifier = Modifier.size(300.dp))

        Spacer(modifier = Modifier.height(84.dp))

        Text(
            text = "Welcome to " + stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "This app helps you explore modern Android UI using Jetpack Compose. Learn to build fast and beautiful UIs in a simple way. Enjoy your journey with Kotlin and Compose!",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))

        GoogleSignInButton(onClick = onGoogleSignInClick)
        Spacer(modifier = Modifier.height(16.dp))

        Text("Or", style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))

        LoginWithEmail(onClick = onEmailClick)

        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
fun GoogleSignInButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 48.dp),
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        ),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_google_icon),
                contentDescription = "Google Icon",
                modifier = Modifier.size(20.dp),
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Sign in with Google",
                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Medium),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun LoginWithEmail(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        ),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "Email Icon",
                modifier = Modifier.size(20.dp),
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Sign in with Email",
                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Medium),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun LottieWelcomeAnimation(modifier: Modifier, animationResId: Int = R.raw.welcome_animation) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(animationResId))
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )
    LottieAnimation(
        composition = composition,
        progress = { progress },
        modifier = modifier.size(200.dp)
    )
}

@Preview(
    name = "Welcome Screen Preview",
    showBackground = true,
    showSystemUi = true
)
@Composable
fun WelcomeContentPreview() {
    MaterialTheme {
        WelcomeContent(
            onGoogleSignInClick = {},
            onEmailClick = {}
        )
    }
}





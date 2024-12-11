package com.jackl.jackprojects.naivenetwork.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.jackl.jackprojects.naivenetwork.R
import com.jackl.jackprojects.naivenetwork.core.presentation.ui.theme.NaiveNetworkTheme
import com.jackl.jackprojects.naivenetwork.core.presentation.ui.theme.Paddings
import com.jackl.jackprojects.naivenetwork.core.presentation.ui.theme.Spacers
import com.jackl.jackprojects.naivenetwork.core.util.Constants.LOGO_IMAGE_SIZE_IN_DP
import com.jackl.jackprojects.naivenetwork.core.util.Constants.SPLASH_SCREEN_DURATION_MILLISECONDS
import kotlinx.coroutines.delay

/**
 * A composable function that displays a splash screen with an animated logo and app name.
 *
 * @param goNextScreen A lambda function that will be invoked to navigate to the next screen
 *                     after the splash animation completes.
 */
@Composable
fun SplashScreen(
    goNextScreen: () -> Unit
) {
    /**
     * Scale for the logo animation.
     */
    val scale = remember {
        Animatable(0f)
    }

    /**
     * Interpolator for the overshoot animation effect.
     * The logo grows slightly beyond the target size and then settles.
     */
    val overshootInterpolator = remember {
        OvershootInterpolator(2f)
    }

    // Animate the logo scale and trigger navigation to the next screen after the duration.
    LaunchedEffect(true) {
//        scale.animateTo(
//            targetValue = 1f,
//            animationSpec = tween(
//                durationMillis = 1000,
//                easing = {
//                    overshootInterpolator.getInterpolation(it)
//                }
//            )
//        )
        delay(SPLASH_SCREEN_DURATION_MILLISECONDS)
        goNextScreen()
    }

    // Layout for the splash screen.
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Paddings.xLarge)
            .scale(scale.value),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // App logo with rounded corners.
        Image(
            painter = painterResource(id = R.drawable.naive_network_app_icon),
            contentDescription = "Logo",
            modifier = Modifier
                .clip(MaterialTheme.shapes.extraLarge)
                .size(LOGO_IMAGE_SIZE_IN_DP)
        )
        Spacer(modifier = Modifier.height(Spacers.medium))
        // App name displayed below the logo.
        Text(
            text = stringResource(id = R.string.app_name),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.headlineLarge,
        )
    }
}

/**
 * A preview function to visualize the SplashScreen in design tools.
 */
@Composable
@Preview
fun SplashScreenPreview() {
    NaiveNetworkTheme {
        SplashScreen(
            goNextScreen = {}
        )
    }
}
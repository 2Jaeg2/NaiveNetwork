package com.jackl.jackprojects.naivenetwork.auth.presentation.intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.jackl.jackprojects.naivenetwork.R
import com.jackl.jackprojects.naivenetwork.core.presentation.designsystem.components.NaiveNetworkButton
import com.jackl.jackprojects.naivenetwork.core.presentation.designsystem.components.NaiveNetworkOutlinedButton
import com.jackl.jackprojects.naivenetwork.core.presentation.ui.theme.NaiveNetworkTheme
import com.jackl.jackprojects.naivenetwork.core.presentation.ui.theme.Paddings
import com.jackl.jackprojects.naivenetwork.core.presentation.ui.theme.Spacers

@Composable
fun IntroScreen(
    onSignIn: () -> Unit,
    onSignUp: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
            .padding(Paddings.extra),
        verticalArrangement = Arrangement.Bottom
    ) {
        Image(
            painter = painterResource(id = R.drawable.naive_network_app_icon),
            contentScale = ContentScale.Crop,
            contentDescription = stringResource(id = R.string.intro_logo),
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .clip(MaterialTheme.shapes.medium)
        )
        Spacer(modifier = Modifier.height(Spacers.small))
        Text(
            text = stringResource(id = R.string.intro_hello),
            style = MaterialTheme.typography.displaySmall,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(Spacers.small))
        Text(
            text = stringResource(id = R.string.intro_description),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(Spacers.large))
        NaiveNetworkButton(
            title = stringResource(id = R.string.sign_up),
            isLoading = false,
            onClick = onSignUp
        )
        Spacer(modifier = Modifier.height(Spacers.small))
        NaiveNetworkOutlinedButton(
            title = stringResource(id = R.string.sign_in),
            isLoading = false,
            onClick = onSignIn
        )
    }
}

@Composable
@PreviewLightDark
private fun IntroScreenPreview() {
    NaiveNetworkTheme {
        IntroScreen(
            onSignIn = {},
            onSignUp = {}
        )
    }
}
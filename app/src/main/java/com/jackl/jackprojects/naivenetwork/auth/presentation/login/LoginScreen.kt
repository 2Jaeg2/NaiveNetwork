package com.jackl.jackprojects.naivenetwork.auth.presentation.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jackl.jackprojects.naivenetwork.R
import com.jackl.jackprojects.naivenetwork.core.presentation.designsystem.components.NaiveNetworkButton
import com.jackl.jackprojects.naivenetwork.core.presentation.designsystem.components.NaiveNetworkPasswordTextField
import com.jackl.jackprojects.naivenetwork.core.presentation.designsystem.components.NaiveNetworkTextField
import com.jackl.jackprojects.naivenetwork.core.presentation.ui.theme.NaiveNetworkTheme
import com.jackl.jackprojects.naivenetwork.core.presentation.ui.theme.Paddings
import com.jackl.jackprojects.naivenetwork.core.presentation.ui.theme.Spacers
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreenRoot(
    viewModel: LoginViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    LoginScreen(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun LoginScreen(
    state: LoginState,
    onAction: (LoginAction) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Paddings.extra),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.hello_buddy),
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(Spacers.small))
        Text(
            text = stringResource(id = R.string.welcome_back),
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(Spacers.large))
        NaiveNetworkTextField(
            state = state.email,
            keyboardType = KeyboardType.Email,
            hint = stringResource(id = R.string.email)
        )
        Spacer(modifier = Modifier.height(Spacers.xSmall))
        NaiveNetworkPasswordTextField(
            state = state.password,
            hint = stringResource(id = R.string.password),
            toggleVisible = state.isToggleVisible,
            onToggleClicked = {
                onAction(LoginAction.OnToggleClicked)
            }
        )
        Spacer(modifier = Modifier.height(Spacers.extra))
        NaiveNetworkButton(
            title = stringResource(id = R.string.sign_in),
            isLoading = state.isLoggin,
            onClick = { onAction(LoginAction.OnLoginClicked) })

        Spacer(modifier = Modifier.height(Spacers.medium))
        Text(text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colorScheme.onBackground
                )
            ) {
                append(stringResource(id = R.string.dont_have_an_account_yet))
            }
            append(" ")
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colorScheme.primary
                )
            ) {
                append(stringResource(id = R.string.sign_up))
            }
        })
    }
}

@Composable
@PreviewLightDark
private fun LoginScreenPreview() {
    NaiveNetworkTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            LoginScreen(state = LoginState(), onAction = {})
        }
    }
}
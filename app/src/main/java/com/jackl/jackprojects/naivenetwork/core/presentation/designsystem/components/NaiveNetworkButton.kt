package com.jackl.jackprojects.naivenetwork.core.presentation.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.invisibleToUser
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.jackl.jackprojects.naivenetwork.core.presentation.ui.theme.NaiveNetworkTheme
import com.jackl.jackprojects.naivenetwork.core.presentation.ui.theme.Paddings
import com.jackl.jackprojects.naivenetwork.core.util.Constants.CIRCULAR_PROGRESS_BAR_SIZE
import com.jackl.jackprojects.naivenetwork.core.util.Constants.CIRCULAR_PROGRESS_STROKE_WIDTH

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun NaiveNetworkButton(
    title: String,
    isLoading: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        modifier = modifier
            .height(IntrinsicSize.Min),
        onClick = onClick,
        shape = MaterialTheme.shapes.medium
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = Paddings.medium),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(CIRCULAR_PROGRESS_BAR_SIZE)
                    .semantics {
                        contentDescription = "ProgressBar"
                        if (!isLoading) {
                            invisibleToUser()
                        }
                    }
                    .alpha(if (isLoading) 1f else 0f),
                strokeWidth = CIRCULAR_PROGRESS_STROKE_WIDTH,
                color = MaterialTheme.colorScheme.onPrimary,
            )

            Text(
                text = title,
                modifier = Modifier
                    .alpha(if (isLoading) 0f else 1f),
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}

@Composable
@PreviewLightDark
private fun NaiveNetworkButtonPreview() {
    NaiveNetworkTheme {
        NaiveNetworkButton(
            title = "Button",
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            isLoading = false
        )
    }
}
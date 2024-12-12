package com.jackl.jackprojects.naivenetwork.core.presentation.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.jackl.jackprojects.naivenetwork.core.presentation.ui.theme.NaiveNetworkTheme
import com.jackl.jackprojects.naivenetwork.core.util.Constants.NAIVE_BUTTON_BACK_CIRCLE_SIZE
import com.jackl.jackprojects.naivenetwork.core.util.Constants.NAIVE_BUTTON_ICON_SIZE

@Composable
fun NaiveIconButton(
    icon: ImageVector,
    tint: Color,
    contentDescription: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(NAIVE_BUTTON_BACK_CIRCLE_SIZE)
            .clip(CircleShape)
            .clickable {
                onClick()
            }
            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.8f)),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = tint,
            modifier = Modifier.size(NAIVE_BUTTON_ICON_SIZE)
        )
    }
}

@Composable
@PreviewLightDark
private fun NaiveIconButtonPreview() {
    NaiveNetworkTheme {
        Box(
            modifier= Modifier.fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            NaiveIconButton(
                icon = Icons.Default.Favorite,
                contentDescription = "Favorite",
                onClick = {},
                tint = Color.Red
            )
        }
    }
}
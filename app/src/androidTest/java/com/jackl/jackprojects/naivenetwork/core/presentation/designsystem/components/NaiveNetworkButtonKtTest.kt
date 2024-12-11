package com.jackl.jackprojects.naivenetwork.core.presentation.designsystem.components

import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.hasAnySibling
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class NaiveNetworkButtonKtTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun verifyCircularProgressBarVisibility_whenButtonIsLoading() {
        composeRule.setContent {
            NaiveNetworkButton(
                title = "test title",
                isLoading = true,
                onClick = {  }
            )
        }

        composeRule
            .onNodeWithContentDescription("ProgressBar")
            .assertIsDisplayed()
    }

    @Test
    fun verifyCircularProgressBarVisibility_whenButtonIsNotLoading() {
        composeRule.setContent {
            NaiveNetworkButton(
                title = "test title",
                isLoading = false,
                onClick = {  }
            )
        }

        composeRule
            .onNodeWithContentDescription("ProgressBar")
            .assertIsNotDisplayed()
    }
}
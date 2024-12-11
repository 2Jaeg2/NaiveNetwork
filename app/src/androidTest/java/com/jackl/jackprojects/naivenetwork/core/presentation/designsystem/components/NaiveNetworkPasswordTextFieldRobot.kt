package com.jackl.jackprojects.naivenetwork.core.presentation.designsystem.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.hasSetTextAction
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextReplacement
import com.jackl.jackprojects.naivenetwork.core.presentation.ui.theme.NaiveNetworkTheme

class NaiveNetworkPasswordTextFieldRobot(
    private val composeRule: ComposeContentTestRule
) {
    fun setContent(passwordTextField: @Composable () -> Unit): NaiveNetworkPasswordTextFieldRobot {
        composeRule.setContent {
            NaiveNetworkTheme {
                passwordTextField()
            }
        }
        return this
    }

    fun assertVisibilityIconIsDisplayed(): NaiveNetworkPasswordTextFieldRobot {
        composeRule
            .onNodeWithContentDescription("Password Visible")
            .assertIsDisplayed()
        return this
    }

    fun assertInvisibilityIconIsDisplayed(): NaiveNetworkPasswordTextFieldRobot {
        composeRule
            .onNodeWithContentDescription("Password Invisible")
            .assertIsDisplayed()
        return this
    }

    fun assertHintIsDisplayed(hint: String) : NaiveNetworkPasswordTextFieldRobot {
        composeRule
            .onNodeWithText(hint)
            .assertIsDisplayed()
        return this
    }

    fun assertHintIsNotDisplayedWhenTextFieldIsFocused(hint: String) : NaiveNetworkPasswordTextFieldRobot {
        composeRule
            .onNode(hasSetTextAction())
            .performClick()

        composeRule
            .onNodeWithText(hint)
            .assertIsNotDisplayed()
        return this
    }

    fun assertIsPasswordReplacedWithStar(typedPassword: String): NaiveNetworkPasswordTextFieldRobot {
        val replacePasswordWithStar = typedPassword.map { '*' }.toString()
        composeRule
            .onNodeWithText(typedPassword)
            .assertIsDisplayed()
        return this
    }
}
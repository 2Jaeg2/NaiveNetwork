package com.jackl.jackprojects.naivenetwork.core.presentation.designsystem.components

import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.ui.test.junit4.createComposeRule
import com.jackl.jackprojects.naivenetwork.core.presentation.ui.theme.NaiveNetworkTheme
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class NaiveNetworkPasswordTextFieldKtTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun whenToggleVisibleIsTrue_visibilityIconIsDisplayed() {
        NaiveNetworkPasswordTextFieldRobot(composeRule)
            .setContent {
                NaiveNetworkPasswordTextField(
                    state = TextFieldState(),
                    hint = "test hint",
                    toggleVisible = true,
                    onToggleClicked = {}
                )
            }
            .assertVisibilityIconIsDisplayed()
    }

    @Test
    fun whenToggleVisibleIsFalse_invisibilityIconIsDisplayed() {
        NaiveNetworkPasswordTextFieldRobot(composeRule)
            .setContent {
                NaiveNetworkPasswordTextField(
                    state = TextFieldState(),
                    hint = "test hint",
                    toggleVisible = false,
                    onToggleClicked = {}
                )
            }
            .assertInvisibilityIconIsDisplayed()
    }

    @Test
    fun whenPasswordTextFieldIsNotFocusedAndTypedNothing_hintIsDisplayed() {
        val hint = "test hint"
        NaiveNetworkPasswordTextFieldRobot(composeRule)
            .setContent {
                NaiveNetworkPasswordTextField(
                    state = TextFieldState(),
                    hint = hint,
                    toggleVisible = false,
                    onToggleClicked = {}
                )
            }
            .assertHintIsDisplayed(hint)
    }

    @Test
    fun whenPasswordTextFieldIsFocused_hintIsNotDisplayed() {
        val hint = "test hint"
        NaiveNetworkPasswordTextFieldRobot(composeRule)
            .setContent {
                NaiveNetworkPasswordTextField(
                    state = TextFieldState(),
                    hint = hint,
                    toggleVisible = false,
                    onToggleClicked = {}
                )
            }
            .assertHintIsNotDisplayedWhenTextFieldIsFocused(hint)
    }

    @Test
    fun whenToggleVisibilityIsFalseAndPasswordTyped_passwordTypedWithStar() {
        val password = "test text"
        NaiveNetworkPasswordTextFieldRobot(composeRule)
            .setContent {
                NaiveNetworkPasswordTextField(
                    state = TextFieldState(password),
                    hint = "test hint",
                    toggleVisible = false,
                    onToggleClicked = {}
                )
            }
            .assertIsPasswordReplacedWithStar(password)
    }
}
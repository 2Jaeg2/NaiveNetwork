package com.jackl.jackprojects.naivenetwork.splash

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.rememberNavController
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import assertk.assertions.isTrue
import com.jackl.jackprojects.naivenetwork.core.presentation.MainActivity
import com.jackl.jackprojects.naivenetwork.core.presentation.ui.theme.NaiveNetworkTheme
import com.jackl.jackprojects.naivenetwork.core.presentation.ui.util.AuthGraph
import com.jackl.jackprojects.naivenetwork.core.presentation.ui.util.IntroScreen
import com.jackl.jackprojects.naivenetwork.core.presentation.ui.util.NavigationRoot
import com.jackl.jackprojects.naivenetwork.core.presentation.ui.util.SplashScreen
import com.jackl.jackprojects.naivenetwork.core.util.Constants.SPLASH_SCREEN_DURATION_MILLISECONDS
import com.jackl.jackprojects.util.MainCoroutineExtension
import com.jackl.jackprojects.util.TestDispatchers
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Isolated UI Test for SplashScreen
 */

class SplashScreenKtTest {

    @get:Rule
    val composeRule = createComposeRule()

    @get:Rule
    val mainDispatcher = MainCoroutineExtension()

    private lateinit var testDispatcher: TestDispatchers

    @RelaxedMockK
    private lateinit var navController: NavHostController

    @Before
    fun setUpDispatcher() {
        testDispatcher = TestDispatchers(mainDispatcher.testDispatcher)
    }

    @Before
    fun setUpMockk() {
        MockKAnnotations.init(this)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDownDispatcher() {
        Dispatchers.resetMain()
    }

    @Test
    fun splashScreen_showsLogoImage() {
        composeRule.setContent {
            NaiveNetworkTheme {
                SplashScreen(
                    dispatchers = testDispatcher,
                    goNextScreen = {}
                )
            }
        }

        composeRule
            .onNodeWithContentDescription("Logo")
            .assertExists("Logo should exist")
            .assertIsDisplayed()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    //Todo 애니메이션 테스트 다시
    @Test
    fun splashScreen_callGoNextScreenAfterDelay() = runTest(testDispatcher.testDispatchers) {
        val goNextScreenMock = mockk<() -> Unit>(relaxed = true)
        composeRule.setContent {
            NaiveNetworkTheme {
                SplashScreen(
                    dispatchers = testDispatcher,
                    goNextScreen = goNextScreenMock
                )
            }
        }
        composeRule.mainClock.advanceTimeBy(SPLASH_SCREEN_DURATION_MILLISECONDS)
        verify {
            goNextScreenMock()
        }
    }
}
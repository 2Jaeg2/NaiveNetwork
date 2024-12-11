package com.jackl.jackprojects.util

import com.jackl.jackprojects.naivenetwork.core.domain.util.DispatcherProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestDispatcher

class TestDispatchers(
    val testDispatchers: TestDispatcher = StandardTestDispatcher()
): DispatcherProvider {
    override val main: CoroutineDispatcher
        get() = testDispatchers
    override val io: CoroutineDispatcher
        get() = testDispatchers
    override val default: CoroutineDispatcher
        get() = testDispatchers
    override val unconfined: CoroutineDispatcher
        get() = testDispatchers
}
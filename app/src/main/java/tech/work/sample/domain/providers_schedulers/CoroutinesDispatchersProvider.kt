package tech.work.sample.domain.providers_schedulers

import kotlinx.coroutines.CoroutineDispatcher

interface CoroutinesDispatchersProvider {
    val io: CoroutineDispatcher
    val main: CoroutineDispatcher
}
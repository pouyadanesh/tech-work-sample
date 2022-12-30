package tech.work.sample.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tech.work.sample.data.MovieRepositoryImpl
import tech.work.sample.domain.providers_schedulers.CoroutinesDispatchersProvider
import tech.work.sample.domain.providers_schedulers.CoroutinesDispatchersProviderImpl
import tech.work.sample.domain.repository.MovieRepository

@Module
@InstallIn(SingletonComponent::class)
interface DomainModule {
    @Binds
    fun provideCoroutinesDispatchersProvider(coroutinesDispatchersProviderImpl: CoroutinesDispatchersProviderImpl): CoroutinesDispatchersProvider

    @Binds
    fun providePostRepository(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository
}
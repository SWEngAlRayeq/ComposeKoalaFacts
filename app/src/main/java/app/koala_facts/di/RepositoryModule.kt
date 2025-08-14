package app.koala_facts.di

import app.koala_facts.data.repo_impl.KoalaRepositoryImpl
import app.koala_facts.domain.repo.KoalaRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindKoalaRepository(impl: KoalaRepositoryImpl): KoalaRepository
}
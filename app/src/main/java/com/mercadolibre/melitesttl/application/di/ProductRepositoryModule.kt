package com.mercadolibre.melitesttl.application.di

import com.mercadolibre.test.data.repository.IProductRepository
import com.mercadolibre.melitesttl.application.data.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class ProductRepositoryModule {
    @Binds
    @ViewModelScoped
    abstract fun bindProductRepository(productRepository: ProductRepository) : IProductRepository
}
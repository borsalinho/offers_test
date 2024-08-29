package com.tests.offerstest.di

import com.tests.data.network.OffersApi
import com.tests.data.offerrepositoryimpl.OffersRepositoryImpl
import com.tests.data.offersparser.OffersParser
import com.tests.domain.offersrepository.OffersRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class DataModule {

    private val BASE_URL = "https://drive.usercontent.google.com"

    @Singleton
    @Provides
    fun provideOffersRepositoryImpl(
        offersApi: OffersApi,
        offersParser : OffersParser
    ) : OffersRepository {
        return OffersRepositoryImpl(
            offersApi = offersApi,
            offersParser = offersParser
        )
    }

    @Singleton
    @Provides
    fun provideOffersApi() : OffersApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OffersApi::class.java)
    }

    @Provides
    fun provideOffersParser() : OffersParser {
        return OffersParser()
    }

}
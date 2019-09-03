package pl.ejdriansoft.personalwallet.services

import okhttp3.OkHttpClient
import org.koin.dsl.module
import pl.ejdriansoft.personalwallet.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import rx.Completable


fun provideDefaultOkhttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .build()
}

fun provideRetrofit(client: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.MY_CLOUD_API)
        .client(client)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
}

fun provideApiService(retrofit: Retrofit): ServiceApi = retrofit.create(ServiceApi::class.java)

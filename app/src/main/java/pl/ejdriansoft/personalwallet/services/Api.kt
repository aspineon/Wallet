package pl.ejdriansoft.personalwallet.services

import okhttp3.OkHttpClient
import pl.ejdriansoft.personalwallet.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


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

package pl.ejdriansoft.personalwallet.services

import retrofit2.http.GET
import rx.Completable


interface ServiceApi {

    @GET
    fun all(): Completable
}
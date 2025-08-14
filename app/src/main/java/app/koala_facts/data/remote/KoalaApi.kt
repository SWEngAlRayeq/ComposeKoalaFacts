package app.koala_facts.data.remote

import app.koala_facts.data.model.KoalaDto
import retrofit2.http.GET

interface KoalaApi {

    @GET("animal/koala")
    suspend fun getKoala() : KoalaDto

}
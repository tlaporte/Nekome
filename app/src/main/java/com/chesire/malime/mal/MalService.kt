package com.chesire.malime.mal

import com.chesire.malime.models.Entry
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MalService {
    @GET("account/verify_credentials.xml")
    fun loginToAccount(): Call<LoginToAccountResponse>

    @GET("anime/search.xml")
    fun searchForAnime(@Query("q") name: String): Call<SearchForAnimeResponse>

    @Root(name = "user")
    data class LoginToAccountResponse(
            @field:Element(name = "id", required = false)
            @param:Element(name = "id", required = false)
            val id: Int? = null,
            @field:Element(name = "username", required = false)
            @param:Element(name = "username", required = false)
            val username: String? = null
    )

    @Root(name = "anime")
    data class SearchForAnimeResponse(
            @field:ElementList(inline = true, entry = "entry")
            @param:ElementList(inline = true, entry = "entry")
            val entries: List<Entry>
    )
}
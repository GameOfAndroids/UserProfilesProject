package com.tm78775.userproject.data.service

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * The [ApiClient] will provide an instance of retrofit ready to
 * be used with our services.
 */
class ApiClient {
    companion object {
        private const val SERVER = "https://randomuser.me"

        /**
         * This will get an instance of retrofit facing the provided baseUrl.
         * @return Instance of [Retrofit].
         */
        fun getApiClient(): Retrofit = Retrofit.Builder()
                .baseUrl(SERVER)
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient())
                .build()
    }
}
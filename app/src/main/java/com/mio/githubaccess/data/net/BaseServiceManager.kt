package com.mio.githubaccess.data.net

import com.mio.githubaccess.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Base class that provides retrofit client instances for communicating with rest and auth server
 */
@Singleton
class BaseServiceManager
@Inject constructor() {

  private var restClient: Retrofit? = null

  /**
   * Create an instance of [Retrofit] for communication with rest server
   */
  val restRetrofitClient: Retrofit
    get() {
      if (restClient == null && !BuildConfig.BASE_URL.isNullOrEmpty()) {
        val builder = Retrofit.Builder().apply {
          baseUrl(BuildConfig.BASE_URL)
          addConverterFactory(GsonConverterFactory.create())
          addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          client(createRestOkHttpClient())
        }
        restClient = builder.build()
      }
      return restClient!!
    }

  /**
   * Create an instance of [OkHttpClient] for retrofit rest client instance
   */
  private fun createRestOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder().apply {
      connectTimeout(Constants.TIMEOUT.toLong(), TimeUnit.SECONDS)
      writeTimeout(Constants.TIMEOUT.toLong(), TimeUnit.SECONDS)
      readTimeout(Constants.READ_TIMEOUT.toLong(), TimeUnit.SECONDS)
    }.build()
  }
}
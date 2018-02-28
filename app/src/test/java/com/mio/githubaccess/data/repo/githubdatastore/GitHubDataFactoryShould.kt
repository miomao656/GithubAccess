package com.mio.githubaccess.data.repo.githubdatastore

import com.mio.githubaccess.data.net.BaseServiceManager
import com.mio.githubaccess.data.net.ConnectionManager
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import retrofit2.Retrofit

class GitHubDataFactoryShould {

  private val baseServiceManager = mock<BaseServiceManager> {
    on { restRetrofitClient } doReturn Retrofit.Builder().apply {
      baseUrl("https://www.youtube.com/")
    }.build()
  }

  private val connectionManager = mock<ConnectionManager> {
    on { it.isNetworkAvailable } doReturn true
  }

  private val gitHubDataFactory = GitHubDataFactory(baseServiceManager, connectionManager)

  @Test fun create() {
    val store = gitHubDataFactory.create()

    assertThat(store, `is`(notNullValue()))
    assertThat(store, `is`(instanceOf(RestGitHubDataStore::class.java)))
  }
}
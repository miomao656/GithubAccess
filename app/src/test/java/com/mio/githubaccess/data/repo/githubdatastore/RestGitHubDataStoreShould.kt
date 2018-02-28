package com.mio.githubaccess.data.repo.githubdatastore

import com.mio.githubaccess.data.net.GitHubApiService
import com.mio.githubaccess.data.net.responses.ReposResponse
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import io.reactivex.Observable
import org.junit.Test
import retrofit2.Response

class RestGitHubDataStoreShould {

  private val gitHubResponse = ReposResponse().apply {
    total_count = 10
    items = emptyList()
  }
  private val response = Response.success(gitHubResponse)
  private val gitHubApiService = mock<GitHubApiService> {
    on { this.searchRepos("", "", "") } doReturn Observable.just(response)
  }
  private val restGitHubDataStore = RestGitHubDataStore(gitHubApiService)

  @Test fun searchRepos() {
    restGitHubDataStore.searchRepos("", "",
        "").test().assertNoErrors().assertComplete().assertResult(
        emptyList())
  }
}
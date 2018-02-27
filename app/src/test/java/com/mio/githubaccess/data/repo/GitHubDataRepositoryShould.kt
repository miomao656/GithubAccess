package com.mio.githubaccess.data.repo

import com.mio.githubaccess.data.repo.githubdatastore.GitHubDataFactory
import com.mio.githubaccess.data.repo.githubdatastore.GitHubDataStore
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import io.reactivex.Observable
import org.junit.Test

class GitHubDataRepositoryShould {

  private val gitHubDataStore = mock<GitHubDataStore> {
    on { searchRepos("", "", "") } doReturn Observable.just(listOf())
  }

  private val gitHubDataFactory = mock<GitHubDataFactory> {
    on { create() } doReturn gitHubDataStore
  }

  private val gitHubRepository = GitHubDataRepository(gitHubDataFactory)

  @Test fun getReposShould() {
    gitHubRepository.getRepos("", "", "").test().assertNoErrors().assertComplete()
  }
}
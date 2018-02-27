package com.mio.githubaccess.data.repo.githubdatastore

import com.mio.githubaccess.data.net.GitHubApiService
import com.mio.githubaccess.data.net.responses.Repo
import io.reactivex.Observable

class RestGitHubDataStore(
    private val service: GitHubApiService
) : GitHubDataStore {

  override fun searchRepos(query: String, sort: String, order: String): Observable<List<Repo>> {
    return service.searchRepos(query, sort, order).map { it.body()?.items }
  }
}
package com.mio.githubaccess.data.repo

import com.mio.githubaccess.data.net.responses.Repo
import com.mio.githubaccess.data.repo.githubdatastore.GitHubDataFactory
import com.mio.githubaccess.domain.GitHubRepository
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GitHubRepositoryImpl
@Inject constructor(
    private val gitHubDataFactory: GitHubDataFactory
) : GitHubRepository {

  override fun getRepos(query: String, sort: String, order: String): Observable<List<Repo>> =
      gitHubDataFactory.create()!!.searchRepos(query, sort, order)
}
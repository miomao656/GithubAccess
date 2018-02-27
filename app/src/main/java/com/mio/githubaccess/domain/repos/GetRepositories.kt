package com.mio.githubaccess.domain.repos

import com.mio.githubaccess.data.net.responses.Repo
import com.mio.githubaccess.domain.GitHubRepository
import com.mio.githubaccess.domain.UseCase
import com.mio.githubaccess.domain.executor.PostExecutionThread
import com.mio.githubaccess.domain.executor.ThreadExecutor
import io.reactivex.Observable
import javax.inject.Inject

class GetRepositories
@Inject constructor(
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread,
    private val repo: GitHubRepository
) : UseCase<List<Repo>>(threadExecutor, postExecutionThread) {

  private var order: String? = null
  private var query: String? = null
  private var sort: String? = null

  override fun buildUseCaseObservable(): Observable<List<Repo>> {
    return if (order == null || query == null || sort == null)
      Observable.error(IllegalArgumentException("Missing parameters or parameters null"))
    else
      repo.getRepos(query!!, sort!!, order!!)
  }

  fun setQueryParams(query: String, sort: String, order: String) {
    this.query = query
    this.sort = sort
    this.order = order
  }
}
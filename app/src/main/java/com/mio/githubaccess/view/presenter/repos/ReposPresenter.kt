package com.mio.githubaccess.view.presenter.repos

import com.mio.githubaccess.domain.DefaultObserver
import com.mio.githubaccess.domain.GetRepositories
import com.mio.githubaccess.injection.PerActivity
import com.mio.githubaccess.view.presenter.Presenter
import com.mio.githubaccess.view.ui.model.Repo
import timber.log.Timber
import javax.inject.Inject

@PerActivity
class ReposPresenter
@Inject constructor(
    private val getRepositories: GetRepositories
) : Presenter<ReposView> {

  var reposView: ReposView? = null

  override fun detachView(view: ReposView) {
    getRepositories.dispose()
    reposView = null
  }

  override fun attachView(view: ReposView) {
    reposView = view
  }

  fun getReposBy(query: String, sort: String, order: String) {
    if (reposView == null) {
      throw IllegalArgumentException("View interface cannot be null!")
    }
    reposView!!.hideRetry()
    reposView!!.showLoading()
    getRepositories.setQueryParams(query, sort, order)
    getRepositories.execute(GetAllCollectionsObserver())
  }

  private inner class GetAllCollectionsObserver : DefaultObserver<List<Repo>>() {

    override fun onComplete() {
      if (reposView != null) {
        reposView!!.hideLoading()
      }
    }

    override fun onError(exception: Throwable) {
      Timber.e(exception)
      if (reposView != null) {
        reposView!!.hideLoading()
        reposView!!.showRetry()
      }
    }

    override fun onNext(result: List<Repo>) {
      reposView?.presentRepos(result)
    }
  }
}
package com.mio.githubaccess.view.ui

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.mio.githubaccess.R
import com.mio.githubaccess.injection.components.DaggerRepositoriesComponent
import com.mio.githubaccess.injection.components.RepositoriesComponent
import com.mio.githubaccess.view.presenter.repos.ReposPresenter
import com.mio.githubaccess.view.presenter.repos.ReposView
import com.mio.githubaccess.view.ui.base.BaseActivity
import com.mio.githubaccess.view.ui.model.Repo
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class ReposActivity : BaseActivity(), ReposView {

  @Inject lateinit var reposPresenter: ReposPresenter

  private val reposComponent: RepositoriesComponent by lazy {
    DaggerRepositoriesComponent.builder().appComponent(appComponent).build()
  }

  override val appContext: Context get() = this.applicationContext

  override fun presentRepos(repos: List<Repo>) {
    repo_list.adapter = ReposAdapter(repos) {
      //call details
    }
  }

  override fun showLoading() {
  }

  override fun hideLoading() {
  }

  override fun showRetry() {
  }

  override fun hideRetry() {
  }

  override fun showError(errorMessage: String) {
  }

  override fun onConnectionChange(isOnline: Boolean) {
    // handle when app goes offline
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    reposComponent.inject(this)
    reposPresenter.attachView(this)
    reposPresenter.getReposBy("trending", "stars", "desc")
    repo_list.layoutManager = LinearLayoutManager(this)
  }

  override fun onDestroy() {
    super.onDestroy()
    reposPresenter.detachView(this)
  }
}

package com.mio.githubaccess.view.presenter.repos

import com.mio.githubaccess.view.presenter.LoadDataView
import com.mio.githubaccess.view.ui.model.Repo

interface ReposView : LoadDataView {

  fun presentRepos(repos: List<Repo>)
}

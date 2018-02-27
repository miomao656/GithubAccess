package com.mio.githubaccess.view.presenter.repos

import com.mio.githubaccess.data.net.responses.Repo
import com.mio.githubaccess.view.presenter.LoadDataView

interface ReposView : LoadDataView {

  fun presentRepos(repos: List<Repo>)
}

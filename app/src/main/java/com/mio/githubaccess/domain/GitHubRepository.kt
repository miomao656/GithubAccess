package com.mio.githubaccess.domain

import com.mio.githubaccess.view.ui.model.Repo
import io.reactivex.Observable

interface GitHubRepository {

  fun getRepos(query: String, sort: String, order: String): Observable<List<Repo>>
}
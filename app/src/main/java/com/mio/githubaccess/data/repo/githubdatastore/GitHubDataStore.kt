package com.mio.githubaccess.data.repo.githubdatastore

import com.mio.githubaccess.view.ui.model.Repo
import io.reactivex.Observable

interface GitHubDataStore {

  fun searchRepos(query: String, sort: String, order: String): Observable<List<Repo>>
}
package com.mio.githubaccess.domain

import com.mio.githubaccess.data.net.responses.Repo
import io.reactivex.Observable

interface GitHubRepository {

  fun getRepos(query: String, sort: String, order: String): Observable<List<Repo>>
}
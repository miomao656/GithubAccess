package com.mio.githubaccess.data.net

import com.mio.githubaccess.data.net.responses.ReposResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubApiService {

  @GET("search/repositories")
  fun searchRepos(
      @Query("q") query: String,
      @Query("sort") sort: String,
      @Query("order") order: String
  ): Observable<Response<ReposResponse>>
}

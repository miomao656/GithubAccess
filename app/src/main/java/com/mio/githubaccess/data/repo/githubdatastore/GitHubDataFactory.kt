package com.mio.githubaccess.data.repo.githubdatastore

import com.mio.githubaccess.data.net.BaseServiceManager
import com.mio.githubaccess.data.net.ConnectionManager
import com.mio.githubaccess.data.net.GitHubApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GitHubDataFactory
@Inject constructor(
    private val baseServiceManager: BaseServiceManager,
    private val connectionManager: ConnectionManager
) {

  fun create(): GitHubDataStore? =
      if (connectionManager.isNetworkAvailable) {
        createCloudDataStore()
      } else {
        // add offline solution
        null
      }

  /**
   * Create [GitHubDataStore] to retrieve data from the rest api.
   */
  private fun createCloudDataStore(): GitHubDataStore {
    //reset rest client and change token
    val restApi = baseServiceManager.restRetrofitClient.create(GitHubApiService::class.java)
    return RestGitHubDataStore(restApi)
  }
}
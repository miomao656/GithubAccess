package com.mio.githubaccess.injection.modules

import com.mio.githubaccess.domain.GitHubRepository
import com.mio.githubaccess.domain.executor.PostExecutionThread
import com.mio.githubaccess.domain.executor.ThreadExecutor
import com.mio.githubaccess.domain.repos.GetRepositories
import com.mio.githubaccess.injection.PerActivity
import dagger.Module
import dagger.Provides

@Module
open class RepositoriesModule {

  @Provides
  @PerActivity
  fun provideGetRepositoriesUseCase(threadExecutor: ThreadExecutor,
      postExecutionThread: PostExecutionThread,
      documentsRepository: GitHubRepository): GetRepositories = GetRepositories(
      threadExecutor,
      postExecutionThread, documentsRepository)
}
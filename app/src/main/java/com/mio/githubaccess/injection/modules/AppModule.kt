package com.mio.githubaccess.injection.modules

import android.content.Context
import com.mio.githubaccess.data.executor.JobExecutor
import com.mio.githubaccess.data.repo.GitHubRepositoryImpl
import com.mio.githubaccess.domain.GitHubRepository
import com.mio.githubaccess.domain.executor.PostExecutionThread
import com.mio.githubaccess.domain.executor.ThreadExecutor
import com.mio.githubaccess.view.GitHubAccessApp
import com.mio.githubaccess.view.UIThread
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
class AppModule(private val application: GitHubAccessApp) {

  @Provides
  @Singleton
  fun provideApplicationContext(): Context = this.application

  @Provides
  @Singleton
  fun provideThreadExecutor(
      jobExecutor: JobExecutor): ThreadExecutor = jobExecutor

  @Provides
  @Singleton
  fun providePostExecutionThread(
      uiThread: UIThread): PostExecutionThread = uiThread

  @Provides
  @Singleton
  fun provideGitHubRepository(repository: GitHubRepositoryImpl): GitHubRepository = repository
}
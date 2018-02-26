package com.mio.githubaccess.injection.components

import android.content.Context
import com.mio.githubaccess.domain.GitHubRepository
import com.mio.githubaccess.domain.executor.PostExecutionThread
import com.mio.githubaccess.domain.executor.ThreadExecutor
import com.mio.githubaccess.injection.modules.AppModule
import com.mio.githubaccess.view.ui.base.BaseActivity
import dagger.Component
import javax.inject.Singleton

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or un-scoped bindings.
@Component(
    modules = [
      AppModule::class
    ]
)
interface AppComponent {
  fun inject(baseActivity: BaseActivity)

  //Exposed to sub-graphs.
  fun context(): Context

  fun threadExecutor(): ThreadExecutor

  fun postExecutionThread(): PostExecutionThread

  fun publicLinkRepository(): GitHubRepository
}
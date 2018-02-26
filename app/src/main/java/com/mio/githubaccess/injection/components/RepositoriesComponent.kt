package com.mio.githubaccess.injection.components

import com.mio.githubaccess.injection.PerActivity
import com.mio.githubaccess.injection.modules.ActivityModule
import com.mio.githubaccess.injection.modules.RepositoriesModule
import com.mio.githubaccess.view.ui.ReposActivity
import dagger.Component


@PerActivity
@Component(
    dependencies = [AppComponent::class],
    modules = [
      ActivityModule::class,
      RepositoriesModule::class
    ]
)
interface RepositoriesComponent {

  fun inject(reposActivity: ReposActivity)
}
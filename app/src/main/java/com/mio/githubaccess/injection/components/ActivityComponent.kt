package com.mio.githubaccess.injection.components

import android.app.Activity
import com.mio.githubaccess.injection.PerActivity
import com.mio.githubaccess.injection.modules.ActivityModule
import dagger.Component

/**
 * A base component upon which getOptionsDrawerFragment's components may depend. Activity-level components should
 * extend this component.
 * Subtypes of ActivityComponent should be decorated with annotation: [PerActivity]
 */
@PerActivity
@Component(
    dependencies = [AppComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {
  //Exposed to sub-graphs.
  fun activity(): Activity
}